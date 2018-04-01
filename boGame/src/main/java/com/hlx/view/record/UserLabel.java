package com.hlx.view.record;

import javax.swing.*;
import java.awt.*;

/**
 * The component sever recordPanel that show user info
 * @author hlx
 * @version 1.0 2018-3-18
 */
public class UserLabel extends JLabel{

    public UserLabel(String user) {
        super(user,CENTER);
        this.setSize(80, 80);
        this.setFont(new Font("Comic Sans", Font.PLAIN,30 ));
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setStroke(new BasicStroke(3.0f));
        g.setColor(new Color(51, 137, 255));
        g.drawRect(10,10,60,60);
    }



}
