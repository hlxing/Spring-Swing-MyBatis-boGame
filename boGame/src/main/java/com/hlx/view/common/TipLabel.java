package com.hlx.view.common;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TipLabel extends WordsLabel{

    public TipLabel(String words, int size) {
        super(words, size, false);
        this.setForeground(new Color(238, 228, 238));
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                setForeground(new Color(254, 243, 254));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                setForeground(new Color(238, 228, 238));
            }
        });
    }


}
