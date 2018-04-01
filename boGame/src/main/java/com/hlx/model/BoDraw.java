package com.hlx.model;

import java.io.Serializable;

/**
 * The BoDraw is bo draw which like a historical record of the lottery
 * It include the user,prize,num of prize,time
 * @author hlx
 * @version 1.0 2018-3-16
 */
public class BoDraw implements Serializable{

    private String user;

    private String prize;

    private Integer size;

    private Long timeStamp;

    public BoDraw() {
    }

    public BoDraw(String user, String prize, Integer size, Long timeStamp) {
        this.user = user;
        this.prize = prize;
        this.size = size;
        this.timeStamp = timeStamp;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "BoDraw{" +
                "user='" + user + '\'' +
                ", prize='" + prize + '\'' +
                ", size=" + size +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
