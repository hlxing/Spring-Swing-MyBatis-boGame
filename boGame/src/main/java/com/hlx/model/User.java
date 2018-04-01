package com.hlx.model;

import com.hlx.config.PrizeEnum;
import java.util.HashMap;
import java.util.Map;

/**
 * The concrete info about user
 * @author hlx
 * @version 1.0 2018-3-21
 */
public class User {

    private Integer id;

    private Score score;

    private Map<PrizeEnum,Integer> prizeMap;

    public User(Integer id) {
        this.id = id;
        score = new Score(id);
        prizeMap = new HashMap<>();
        prizeMap.put(PrizeEnum.SHOW, 0);
        prizeMap.put(PrizeEnum.LIFT,0);
        prizeMap.put(PrizeEnum.ENTER, 0);
        prizeMap.put(PrizeEnum.RED, 0);
        prizeMap.put(PrizeEnum.PAIR, 0);
        prizeMap.put(PrizeEnum.CHIEF, 0);
        prizeMap.put(PrizeEnum.FIVE, 0);
        prizeMap.put(PrizeEnum.SIX, 0);
        prizeMap.put(PrizeEnum.FLOWER, 0);
        prizeMap.put(PrizeEnum.BLANK,0);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public Map<PrizeEnum, Integer> getPrizeMap() {
        return prizeMap;
    }

    public void setPrizeMap(Map<PrizeEnum, Integer> prizeMap) {
        this.prizeMap = prizeMap;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", score=" + score +
                ", prizeMap=" + prizeMap +
                '}';
    }
}
