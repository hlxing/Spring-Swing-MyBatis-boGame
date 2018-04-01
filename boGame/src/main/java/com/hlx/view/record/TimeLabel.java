package com.hlx.view.record;

import com.hlx.util.TimeUtil;
import javax.swing.*;
import java.awt.*;

/**
 * The component sever recordPanel that show time info
 * @author hlx
 * @version 1.0 2018-3-18
 */
public class TimeLabel extends JLabel {

    public TimeLabel(Long timeStamp) {
        super();
        String time = TimeUtil.parseTimeStamp(timeStamp);
        this.setText(time);
        this.setHorizontalTextPosition(CENTER);
        this.setFont(new Font("Comic Sans", Font.PLAIN,20));
        this.setSize(120,30);
    }


}
