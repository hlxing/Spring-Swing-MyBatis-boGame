package com.hlx.view.common;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * The abstract label that be used for showing some words
 * @author hlx
 * @version 1.0 2018-3-17
 */
public class WordsLabel extends JLabel{

    public WordsLabel(String words,int size,boolean mouseListener,int horizontalAlignment) {
        super(words,horizontalAlignment);
        this.setFont(new Font("微软雅黑",Font.PLAIN,size));
        if(mouseListener)
            initListener();
    }

    public WordsLabel(String words,int size,boolean mouseListener) {
        super(words);
        this.setFont(new Font("微软雅黑",Font.PLAIN,size));
        if(mouseListener)
            initListener();
    }


    private void initListener() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                JLabel label = (JLabel)e.getSource();
                //make the component opaque
                setOpaque(true);
                Color color = label.getForeground();
                label.setBackground(ColorUtil.build(color,0.85));
                label.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                JLabel label = (JLabel)e.getSource();
                label.setOpaque(false);
                label.repaint();
            }
        });
    }


}
