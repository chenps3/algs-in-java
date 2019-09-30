package com.chenps3.algs;

public class Dto {

    private Integer key;

    private Integer value;

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Dto() {
    }

    public Dto(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }
}
