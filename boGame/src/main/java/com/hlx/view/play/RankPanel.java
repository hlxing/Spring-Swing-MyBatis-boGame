package com.hlx.view.play;

import com.hlx.model.Score;
import com.hlx.view.common.PositionUtil;
import com.hlx.view.common.TipLabel;
import com.hlx.view.common.TranslucentPanel;

import java.util.*;

/**
 * The rank view of play frame
 * @author hlx
 * @version 2018-3-20
 */
public class RankPanel extends TranslucentPanel implements Observer{

    private DataService dataService;

    private List<ScorePanel> scorePanelList;

    public RankPanel(float transparency,DataService dataService) {
        super();
        this.setTransparency(transparency);
        this.setSize(260, 250);
        this.dataService = dataService;
        dataService.attach(this);
        initTitleLabel();
        initScoreLabel();
    }

    private void initTitleLabel() {
        TipLabel titleLabel = new TipLabel("积分榜", 20);
        titleLabel.setSize(60, 20);
        titleLabel.setLocation(-1, 15);
        PositionUtil.setMiddle(titleLabel,this);
    }

    private void initScoreLabel() {
        scorePanelList = new ArrayList<>(Arrays.asList(
                new ScorePanel(5),
                new ScorePanel(4),
                new ScorePanel(3),
                new ScorePanel(2),
                new ScorePanel(1)
        ));
        int y = 45;
        for (ScorePanel scorePanel : scorePanelList) {
            scorePanel.setLocation(40, y);
            y = y + 35;
            this.add(scorePanel);
        }
    }

    public void clear() {
        for (ScorePanel scorePanel : scorePanelList) {
            scorePanel.clear();
        }
    }

    public void update() {
        List<Score> scoreSet = dataService.getScoreList();
        int i = scoreSet.size()-1;
        for (Score score : scoreSet) {
            scorePanelList.get(i).setScore(score);
            i = i - 1;
        }
    }
}
