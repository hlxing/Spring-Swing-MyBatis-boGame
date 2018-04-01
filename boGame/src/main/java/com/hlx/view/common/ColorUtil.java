package com.hlx.view.common;

import java.awt.*;

/**
 * The util can build more brighter or darker color than original color approximately
 * @author hlx
 * @version 1.0 2018-3-17
 *
 */
public class ColorUtil {


    public static Color build(Color color,double size) {
        int r = (int) (color.getRed()*size);
        int g = (int) (color.getGreen()*size);
        int b = (int) (color.getBlue()*size);
        if(r>255) r=255;
        if(g>255) g=255;
        if(b>255) b=255;
        return new Color(r, g, b);
    }
}
