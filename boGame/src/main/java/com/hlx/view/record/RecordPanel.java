package com.hlx.view.record;

import com.hlx.config.PrizeEnum;
import com.hlx.model.BoDraw;
import com.hlx.util.TimeUtil;
import com.hlx.view.common.BackgroundLabel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * A panel about record of bo game
 * @author hlx
 * @version 1.0 2018-3-18
 */
public class RecordPanel extends JPanel{

    private BackgroundLabel levelLabel;

    private UserLabel userLabel;

    private TimeLabel timeLabel;

    PrizeLabel prizeLabel;

    private BoDraw boDraw;

    public RecordPanel(BoDraw boDraw) {
        super();
        this.boDraw = boDraw;
        this.setBackground(new Color(158, 145,240));
        this.setSize(530,80);
        this.setLayout(null);
        this.setVisible(false);
        initLevelLabel();
        initListener();
    }

    public void setBoDraw(BoDraw boDraw) {
        this.boDraw = boDraw;
        levelLabel.setImage("view/image/letter/"
                +levelJudge(boDraw.getPrize())+".png");
        userLabel.setText(boDraw.getUser());
        timeLabel.setText(TimeUtil.parseTimeStamp(boDraw.getTimeStamp()));
        prizeLabel.update(boDraw.getPrize(),boDraw.getSize());
    }

    private void initListener() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JPanel panel = (JPanel)e.getSource();
                panel.setBackground(new Color(189, 176,240));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                JPanel panel = (JPanel)e.getSource();
                panel.setBackground(new Color(158, 145,240));
            }
        });
    }

    private void initLevelLabel() {
        levelLabel = new BackgroundLabel("view/image/letter/"
                +levelJudge(boDraw.getPrize())+".png");
        levelLabel.setLocation(0,0);
        this.add(levelLabel);
        userLabel = new UserLabel(boDraw.getUser());
        userLabel.setLocation(85, 0);
        this.add(userLabel);
        prizeLabel = new PrizeLabel(boDraw.getPrize(), boDraw.getSize());
        prizeLabel.setLocation(180, 0);
        this.add(prizeLabel);
        timeLabel = new TimeLabel(boDraw.getTimeStamp());
        timeLabel.setLocation(430,55);
        this.add(timeLabel);
    }


    private String levelJudge(String prize) {
        if (PrizeEnum.SHOW.getDesc().equals(prize)) {
            return "e";
        } else if (PrizeEnum.LIFT.getDesc().equals(prize)) {
            return "d";
        } else if (PrizeEnum.ENTER.getDesc().equals(prize)) {
            return "c";
        } else if (PrizeEnum.RED.getDesc().equals(prize)) {
            return "b";
        } else if (PrizeEnum.PAIR.getDesc().equals(prize)) {
            return "a";
        } else
            return "s";
    }
}
