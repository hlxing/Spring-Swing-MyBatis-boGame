package com.hlx.view.record;

import javax.swing.*;
import java.awt.*;

/**
 * The component sever the recordPanel that show the num of prize
 * @author hlx
 * @version 1.0 2018-3-18
 */
public class PrizeLabel extends JLabel {

    public PrizeLabel(String prize,Integer size) {
        super();
        String str = prize + "X  " + size;
        this.setFont(new Font("微软雅黑", Font.PLAIN,40 ));
        this.setText(str);
        this.setHorizontalTextPosition(CENTER);
        this.setForeground(Color.BLACK);
        this.setSize(350,80);
    }

    public void update(String prize, Integer size) {
        String str = prize + "X  " + size;
        this.setText(str);
    }


}
