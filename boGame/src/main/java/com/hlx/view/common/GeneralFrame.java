package com.hlx.view.common;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * A general frame that init the common attribute
 * @author hlx
 * @version 1.0 2018-3-16
 */
public class GeneralFrame extends JFrame {

    /**
     * The member is a temp for implementing the movable interface
     * and make the frame have the opportunity to move
     */
    private Point point;

    /**
     *
     * @param isNoTitle if true, remove the title of frame
     */
    public GeneralFrame(boolean isNoTitle) {
        this.setSize(800, 600);
        this.setVisible(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        if(isNoTitle){
            updateTitle();
        }
    }


    /**
     * remove the title and keep the frame movable
     * @warn It must be used before the frame is made displayable(e.g. visible=true)
     */
    private void updateTitle() {
        this.setUndecorated(true);
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                point = e.getPoint();
            }
        });
        this.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                JFrame frame = (JFrame) e.getSource();
                Point p = new Point(e.getX() + frame.getX(), e.getY() + frame.getY());
                frame.setLocation(p.x - point.x, p.y - point.y);
            }
        });
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}
