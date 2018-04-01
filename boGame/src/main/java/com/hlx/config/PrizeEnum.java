package com.hlx.config;

/**
 * A list of bo game prizes
 * @author hlx
 * @version 1.0 2018-3-16
 */
public enum PrizeEnum {
    SHOW("一秀",1),
    LIFT("二举",2),
    ENTER("四进",5),
    RED("三红",10),
    PAIR("对堂",25),
    CHIEF("状元",50),
    FIVE("五子登科",50),
    SIX("六杯红",50),
    FLOWER("状元插金花",50),
    BLANK("NULL",0);

    private String desc;

    private int score;

    PrizeEnum(String desc, int score) {
        this.desc = desc;
        this.score = score;
    }

    public String getDesc() {
        return desc;
    }

    public int getScore() {
        return score;
    }

    public static PrizeEnum get(Integer id){
        switch (id) {
            case 0:
                return SHOW;
            case 1:
                return LIFT;
            case 2:
                return ENTER;
            case 3:
                return RED;
            case 4:
                return PAIR;
            case 5:
                return CHIEF;
        }
        return BLANK;
    }
}
