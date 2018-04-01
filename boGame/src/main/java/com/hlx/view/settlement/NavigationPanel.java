package com.hlx.view.settlement;

import com.hlx.view.common.WordsLabel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A navigation server Settlement
 * @author hlx
 * @version 1.0 2018-3-24
 */
public class NavigationPanel extends JPanel{


    public NavigationPanel() {
        super();
        this.setSize(845, 50);
        this.setLayout(null);
        this.setBackground(new Color(193, 220, 252));
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                setBackground(new Color(186, 212, 243));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                setBackground(new Color(193, 220, 252));
            }
        });
        List<WordsLabel> tipLabelList = new ArrayList<>(Arrays.asList(
                new WordsLabel("等级",24,false),
                new WordsLabel("玩家",24,false),
                new WordsLabel("一秀",24,false),
                new WordsLabel("二举",24,false),
                new WordsLabel("四进",24,false),
                new WordsLabel("三红",24,false),
                new WordsLabel("对堂",24,false),
                new WordsLabel("状元",24,false),
                new WordsLabel("积分",24,false)
        ));
        int x = 25;
        for (WordsLabel tipLabel : tipLabelList) {
            tipLabel.setBounds(x, 12, 50, 30);
            this.add(tipLabel);
            x = x + 90;
        }
    }
}
