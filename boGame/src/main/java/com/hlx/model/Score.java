package com.hlx.model;

/**
 * The score of user including
 * the value,rank,change of rank
 * @author hlx
 * @version 1.0 2018-3-21
 */
public class Score implements Comparable<Score>{

    private static final int CHANGE_DOWN = 1;

    private static final int CHANGE_NO = 2;

    private static final int CHANGE_UP = 3;

    private Integer id;

    private Integer number;

    private Integer rank;

    private int change;

    public Score(Integer id) {
        this.number = 0;
        this.change = 0;
        this.rank = 6;
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public int getChange() {
        return change;
    }

    public void setChange(int change) {
        this.change = change;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        if(this.rank<rank){
            change = CHANGE_DOWN;
        } else if (this.rank.equals(rank)) {
            change = CHANGE_NO;
        } else {
            change = CHANGE_UP;
        }
        this.rank = rank;
    }

    public Integer getId() {
        return id;
    }

    public int compareTo(Score o) {
        if (this.getNumber() > o.getNumber()) {
            return 1;
        } else if (this.getNumber() < o.getNumber()) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", number=" + number +
                ", rank=" + rank +
                ", change=" + change +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score1 = (Score) o;
        return id.equals(score1.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
