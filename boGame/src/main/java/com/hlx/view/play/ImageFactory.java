package com.hlx.view.play;

import com.hlx.App;
import javax.swing.*;

/**
 * A simple factory that create the instance of imageIcon quickly
 * @author hlx
 * @version 1.0 2018-3-20
 */
public class ImageFactory {

    private static final String PREFIX = "view/image/number/";

    private static final String SUFFIX = ".png";

    public static ImageIcon getInstance(String id) {
        return new ImageIcon(App.class.getResource(PREFIX+id+SUFFIX));
    }
}
