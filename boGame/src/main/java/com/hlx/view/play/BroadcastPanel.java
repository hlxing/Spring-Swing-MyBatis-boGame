package com.hlx.view.play;

import com.hlx.config.PrizeEnum;
import com.hlx.view.common.BackgroundLabel;
import com.hlx.view.common.TipLabel;
import com.hlx.view.common.TranslucentPanel;

/**
 * The broadcast view of play frame
 * that include tip,score
 * @author hlx
 * @version 1.0 2018-3-20
 */
public class BroadcastPanel extends TranslucentPanel implements Observer{

    private DataService dataService;

    private static final String SCORE_TIP = "+@";

    private static final String PRIZE_TIP = "恭喜选手#博中@,再接再厉";

    private static final String PRIZE_TIP2 = "恭喜选手#无奖,继续努力";

    private TipLabel scoreLabel;

    private TipLabel tipLabel;

    public BroadcastPanel(float transparency,DataService dataService) {
        super();
        this.setTransparency(transparency);
        this.setSize(635, 95);
        this.dataService = dataService;
        dataService.attach(this);
        initSignLabel();
        initTipLabel();
        initScoreLabel();
    }

    private void initScoreLabel() {
        scoreLabel = new TipLabel("", 20);
        scoreLabel.setBounds(560,40,40,30);
        this.add(scoreLabel);
    }

    private void initTipLabel() {
        tipLabel = new TipLabel("", 20);
        tipLabel.setBounds(120, 45, 360, 20);
        this.add(tipLabel);
    }

    private void initSignLabel() {
        BackgroundLabel signLabel = new BackgroundLabel("view/image/background/broadcast.png");
        signLabel.setLocation(50,30);
        this.add(signLabel);
    }

    public void clear() {
        tipLabel.setText("");
        scoreLabel.setText("");
    }

    public void update() {
        Integer currentUser = dataService.getCurrentUser();
        PrizeEnum prize = dataService.getCurrentPrize();
        if (prize != PrizeEnum.BLANK) {
            String tip = PRIZE_TIP.replaceAll("#", "" + currentUser)
                    .replaceAll("@", prize.getDesc());
            String score = SCORE_TIP.replaceAll("@", "" + prize.getScore());
            tipLabel.setText(tip);
            scoreLabel.setText(score);
        } else {
            String tip = PRIZE_TIP2.replaceAll("#", "" + currentUser);
            tipLabel.setText(tip);
            scoreLabel.setText("");
        }
    }
}
