package com.hlx.view.common;

import com.hlx.App;
import javax.swing.*;

/**
 * This label is made for build a background with image quickly
 * @author hlx
 * @version 1.0 2018-3-17
 */
public class BackgroundLabel extends JLabel{

    private ImageIcon image;

    public BackgroundLabel(String imgUrl) {
        super();
        this.setLayout(null);
        initImage(imgUrl);
        this.setSize(image.getIconWidth(),image.getIconHeight());
    }

    private void initImage(String imgUrl) {
        image = new ImageIcon(App.class.getResource(imgUrl));
        this.setIcon(image);
    }

    public void setImage(String imgUrl) {
        image = new ImageIcon(App.class.getResource(imgUrl));
        this.setIcon(image);
    }

    public void setImage(ImageIcon imageIcon) {
        this.setIcon(imageIcon);
    }
}
