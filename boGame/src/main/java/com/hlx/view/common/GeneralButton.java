package com.hlx.view.common;

import javax.swing.*;
import java.awt.*;

/**
 * A general button that init the common attribute
 * @author hlx
 * @version 1.0 2018-3-18
 */
public class GeneralButton extends JButton {

    public GeneralButton(String text,int size) {
        super(text);
        this.setFocusPainted(false);
        this.setFont(new Font("Comic Sans", Font.PLAIN, size));
    }

}
