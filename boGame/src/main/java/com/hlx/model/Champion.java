package com.hlx.model;

import com.hlx.config.PrizeEnum;

/**
 * A model that includes the owner of champion
 * and the type of champion
 * @author hlx
 * @version 1.0 2018-3-24
 */
public class Champion {

    private Integer user;

    private PrizeEnum prize;

    public Champion() {
    }

    public Champion(Integer user, PrizeEnum prize) {
        this.user = user;
        this.prize = prize;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public PrizeEnum getPrize() {
        return prize;
    }

    public void setPrize(PrizeEnum prize) {
        this.prize = prize;
    }
}
