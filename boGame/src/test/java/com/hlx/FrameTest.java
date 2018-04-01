package com.hlx;

import com.hlx.config.PrizeEnum;
import com.hlx.model.Score;
import com.hlx.model.Setting;
import com.hlx.model.User;
import com.hlx.view.entry.EntryFrame;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;


public class FrameTest {

    private static final Logger logger = Logger.getLogger(FrameTest.class);

    @Test
    public void enumTest() {
        Setting setting = new Setting();
        setting.setNum(5);
        Integer id = setting.getNum();
        setting.setNum(id - 1);
        setting.setNum(id);
        System.out.println(setting.getNum());
    }


}
