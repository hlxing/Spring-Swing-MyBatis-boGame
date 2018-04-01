package com.hlx.view.play;


import com.hlx.model.Score;
import com.hlx.view.common.BackgroundLabel;
import com.hlx.view.common.TipLabel;
import com.hlx.view.common.TranslucentPanel;

/**
 * The component that serve the RankPanel
 * @author hlx
 * @version 1.0 2018-3-21
 */
public class ScorePanel extends TranslucentPanel{

    private TipLabel scoreLabel;

    private TipLabel userLabel;

    private BackgroundLabel changeLabel;

    public ScorePanel(int level) {
        super();
        this.setLayout(null);
        this.setSize(180, 30);
        this.setTransparency((float) 0);
        initLevelLabel(level);
        initUserLabel();
        initScoreLabel();
        initChangeLabel();
    }

    private void initChangeLabel() {
        String imgUrl = "view/image/change/0.png";
        changeLabel = new BackgroundLabel(imgUrl);
        changeLabel.setLocation(165,5);
        this.add(changeLabel);
    }

    private void initScoreLabel() {
        scoreLabel = new TipLabel("", 13);
        scoreLabel.setBounds(120, 5, 35, 15);
        this.add(scoreLabel);
    }

    private void initUserLabel() {
        userLabel = new TipLabel("", 13);
        userLabel.setBounds(70, 5, 40, 15);
        this.add(userLabel);
    }

    private void initLevelLabel(int level) {
        String imgUrl = "view/image/level/" + level + ".png";
        BackgroundLabel levelLabel = new BackgroundLabel(imgUrl);
        levelLabel.setLocation(0,0);
        this.add(levelLabel);
    }

    public void setScore(Score score) {
        scoreLabel.setText("" + score.getNumber());
        userLabel.setText(score.getId() + "号");
        changeLabel.setImage("view/image/change/" + score.getChange() + ".png");
    }

    public void clear() {
        changeLabel.setImage("view/image/change/0.png");
        userLabel.setText("");
        scoreLabel.setText("");
    }

}
