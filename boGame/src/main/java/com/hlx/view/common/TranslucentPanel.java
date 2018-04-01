package com.hlx.view.common;

import javax.swing.*;
import java.awt.*;

/**
 * A panel that can be translucent by setting the transparency
 * @author hlx
 * @version 1.0 2017-?-?
 */
public class TranslucentPanel extends JPanel {

    private float transparency;

    public TranslucentPanel(){
        this.setLayout(null);
        setOpaque(false);
    }


    public void setTransparency(float transparency) {
        this.transparency = transparency;
    }

    @SuppressWarnings("Since15")
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D)g.create();
        graphics2D.setComposite(AlphaComposite.SrcOver.derive(transparency));
        graphics2D.fillRect(0, 0, getWidth(), getHeight());
        graphics2D.dispose();
    }
}
