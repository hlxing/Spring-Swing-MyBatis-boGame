package com.hlx.model;

import java.io.Serializable;
import java.util.List;

/**
 * The setting of bo game
 * It is designed to be ugly because of time
 * @author hlx
 * @version 1.1 2018-3-22
 */
public class Setting implements Serializable{

    private Integer num;

    private Integer num2;

    private Integer num3;

    private Integer num4;

    private Integer num5;

    private Integer num6;

    private Integer num7;

    public Setting(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7) {
        this.num = num;
        this.num2 = num2;
        this.num3 = num3;
        this.num4 = num4;
        this.num5 = num5;
        this.num6 = num6;
        this.num7 = num7;
    }

    public Setting() {
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getNum2() {
        return num2;
    }

    public void setNum2(Integer num2) {
        this.num2 = num2;
    }

    public Integer getNum3() {
        return num3;
    }

    public void setNum3(Integer num3) {
        this.num3 = num3;
    }

    public Integer getNum4() {
        return num4;
    }

    public void setNum4(Integer num4) {
        this.num4 = num4;
    }

    public Integer getNum5() {
        return num5;
    }

    public void setNum5(Integer num5) {
        this.num5 = num5;
    }

    public Integer getNum6() {
        return num6;
    }

    public void setNum6(Integer num6) {
        this.num6 = num6;
    }

    public Integer getNum7() {
        return num7;
    }

    public void setNum7(Integer num7) {
        this.num7 = num7;
    }

    public Integer select(int id) {
        switch (id) {
            case 0:
                return getNum();
            case 1:
                return getNum2();
            case 2:
                return getNum3();
            case 3:
                return getNum4();
            case 4:
                return getNum5();
            case 5:
                return getNum6();
        }
        return null;
    }

    public void update(int id, Integer number) {
        switch (id) {
            case 0:
                setNum(number);
                break;
            case 1:
                setNum2(number);
                break;
            case 2:
                setNum3(number);
                break;
            case 3:
                setNum4(number);
                break;
            case 4:
                setNum5(number);
                break;
            case 5:
                setNum6(number);
                break;
        }
    }

    @Override
    public String toString() {
        return "Setting{" +
                "num=" + num +
                ", num2=" + num2 +
                ", num3=" + num3 +
                ", num4=" + num4 +
                ", num5=" + num5 +
                ", num6=" + num6 +
                ", num7=" + num7 +
                '}';
    }
}
