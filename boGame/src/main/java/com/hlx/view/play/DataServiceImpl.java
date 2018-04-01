package com.hlx.view.play;

import com.hlx.config.PrizeEnum;
import com.hlx.model.Champion;
import com.hlx.model.Score;
import com.hlx.model.Setting;
import com.hlx.model.User;
import com.hlx.service.RecognitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * This is a data transfer service
 * @author hlx
 * @version 1.0 2018-3-22
 */
@Service
public class DataServiceImpl implements DataService {

    private List<Observer> observerList;

    private Setting setting;

    private int maxUser;
    
    private int maxChampion;

    private Integer currentUser;

    private PrizeEnum currentPrize;

    private Map<Integer,User> userMap;

    // record the champion and the owner of champion
    private List<Champion> championList;

    //record the score and the value of score
    private List<Score> scoreList;

    private RecognitionService recognitionService;

    @Autowired
    public DataServiceImpl(RecognitionService recognitionService) {
        this.recognitionService = recognitionService;
        observerList = new ArrayList<>();

    }

    public Setting getSetting() {
        return setting;
    }

    public Integer getCurrentUser() {
        return currentUser;
    }

    public PrizeEnum getCurrentPrize() {
        return currentPrize;
    }

    public Map<Integer, User> getUserMap() {
        return userMap;
    }

    public List<Score> getScoreList() {
        return scoreList;
    }

    public void setDate(String result) {
        // update the setting
        currentPrize = recognitionService.recognize(result);
        int prizeId = currentPrize.ordinal() > 5 ? 5 : currentPrize.ordinal();
        Integer prizeNum = setting.select(prizeId);
        if ((prizeNum==null)||((prizeNum == 0)&&currentPrize.ordinal()<PrizeEnum.CHIEF.ordinal())) {
            currentPrize = PrizeEnum.BLANK;
        }else if(currentPrize!=PrizeEnum.BLANK){
            if(currentPrize.ordinal()<PrizeEnum.CHIEF.ordinal()){
                setting.update(prizeId,prizeNum-1);
            }else{
                if(maxChampion==0)  currentPrize = PrizeEnum.BLANK;
            }
        }
        // update the info about user
        User user = userMap.get(currentUser);
        Map<PrizeEnum,Integer> prizeMap = user.getPrizeMap();
        Integer num = prizeMap.get(currentPrize);
        prizeMap.put(currentPrize, num + 1);
        Score score = user.getScore();
        score.setNumber(score.getNumber()+currentPrize.getScore());
        // update the championMap
        if (currentPrize == PrizeEnum.CHIEF || currentPrize == PrizeEnum.FIVE ||
                currentPrize == PrizeEnum.FLOWER || currentPrize == PrizeEnum.SIX) {
            Champion currentChampion = new Champion(currentUser, currentPrize);
            if (championList.size() < maxChampion ) {
                championList.add(currentChampion);
            }else if(championList.size()!=0){
                setting.update(prizeId,prizeNum);
                Champion minChampion = championList.get(0);
                for (Champion champion : championList) {
                    if (champion.getPrize().ordinal() <= minChampion.getPrize().ordinal()) {
                        minChampion = champion;
                    }
                }
                if (currentChampion.getPrize().ordinal() > minChampion.getPrize().ordinal()) {
                    User minUser = userMap.get(minChampion.getUser());
                    Score minScore = minUser.getScore();
                    minScore.setNumber(minScore.getNumber()-currentPrize.getScore());
                    Integer minNum = minUser.getPrizeMap().get(currentPrize);
                    minUser.getPrizeMap().put(currentPrize, minNum - 1);
                    championList.remove(minChampion);
                    championList.add(currentChampion);
                }
            }
        }
        //This is the most impossible situation(six red)
        if (currentPrize == PrizeEnum.SIX) {
            for(int i=0;i<6;i++) {
                PrizeEnum prizeEnum = PrizeEnum.get(i);
                Integer preNum = prizeMap.get(prizeEnum);
                prizeMap.put(prizeEnum, preNum + setting.select(i));
                score.setNumber(score.getNumber() + setting.select(i)*prizeEnum.getScore());
                setting.update(i,0);
            }
        }
        // update the scoreSet
        if (!scoreList.contains(score)) {
            scoreList.add(score);
        }
        scoreList.sort(Comparator.comparing(Score::getNumber));
        if (scoreList.size() == 6) {
            Score minScore = scoreList.get(0);
            minScore.setRank(6);
            scoreList.remove(0);
        }
        int i = scoreList.size();
        for (Score oldScore : scoreList) {
            oldScore.setRank(i);
            i = i - 1;
        }
        remind();
        // update the current user
        currentUser = currentUser < maxUser ? currentUser+1 : 1;
    }



    /**
     *
     * @param setting the setting about bo game
     */
    public void initData(Setting setting) {
        this.setting = setting;
        maxUser = setting.getNum7();
        maxChampion = setting.getNum6();
        currentUser = 1;
        currentPrize = null;
        userMap = new HashMap<>();
        for(int i=1;i<=maxUser;i++) {
            userMap.put(i, new User(i));
        }
        championList = new ArrayList<>();
        scoreList = new ArrayList<>();
    }

    public void attach(Observer observer) {
        observerList.add(observer);
    }

    public void remind() {
        for (Observer observer : observerList) {
            observer.update();
        }
    }
}
