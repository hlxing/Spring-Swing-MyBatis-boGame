package com.hlx.view.play;

import com.hlx.view.common.TipLabel;

/**
 * The custom label that about the name of prize
 * and the num of prize
 * @author hlx
 * @version 1.0 2018-3-20
 */
public class PrizeLabel extends TipLabel {

    private int num;

    private String words;

    public PrizeLabel(String words, int num,int size) {
        super(words + num, size);
        this.words = words;
    }

    public void setNum(int num) {
        this.num = num;
        this.setText(words + num);
    }

    public int getNum() {
        return num;
    }
}
