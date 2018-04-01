package com.hlx.view.settlement;

import com.hlx.config.PrizeEnum;
import com.hlx.model.Score;
import com.hlx.model.User;
import com.hlx.view.common.BackgroundLabel;
import com.hlx.view.common.WordsLabel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * The record server Settlement
 * @author hlx
 * @version 1.0 2018-3-24
 */
public class RecordPanel extends JPanel{

    private List<WordsLabel> recordLabelList;

    private BackgroundLabel levelLabel;

    public RecordPanel() {
        super();
        this.setLayout(null);
        this.setSize(845,50);
        this.setBackground(new Color(45, 232, 255));
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                setBackground(new Color(63, 216, 255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                setBackground(new Color(45, 232, 255));
            }
        });

        recordLabelList = new ArrayList<>(Arrays.asList(
                new WordsLabel("1号",24,false),
                new WordsLabel("123",24,false),
                new WordsLabel("502",24,false),
                new WordsLabel("312",24,false),
                new WordsLabel("402",24,false),
                new WordsLabel("502",24,false),
                new WordsLabel("602",24,false),
                new WordsLabel("727",24,false)
        ));
        int x = 115;
        for (WordsLabel recordLabel : recordLabelList) {
            recordLabel .setBounds(x, 12, 50, 30);
            this.add(recordLabel);
            x = x + 90;
        }
        levelLabel = new BackgroundLabel("view/image/level/1.png");
        levelLabel.setLocation(20, 15);
        this.add(levelLabel);
    }

    public void update(User user) {
        System.out.println(user);
        Score score = user.getScore();
        int level = 0;
        if (score.getRank() <= 5) {
            level = 6 - score.getRank();
        }
        levelLabel.setImage("view/image/level/"+level+".png");
        recordLabelList.get(0).setText(user.getId()+"号");
        Map<PrizeEnum,Integer> prizeMap = user.getPrizeMap();
        recordLabelList.get(1).setText(""+prizeMap.get(PrizeEnum.SHOW));
        recordLabelList.get(2).setText(""+prizeMap.get(PrizeEnum.LIFT));
        recordLabelList.get(3).setText(""+prizeMap.get(PrizeEnum.ENTER));
        recordLabelList.get(4).setText(""+prizeMap.get(PrizeEnum.RED));
        recordLabelList.get(5).setText(""+prizeMap.get(PrizeEnum.PAIR));
        Integer championSum = prizeMap.get(PrizeEnum.CHIEF) + prizeMap.get(PrizeEnum.FIVE)
                + prizeMap.get(PrizeEnum.FLOWER) + prizeMap.get(PrizeEnum.SIX);
        recordLabelList.get(6).setText("" + championSum);
        recordLabelList.get(7).setText("" + score.getNumber());
    }
}
