package com.cxk.cai.entity;

import java.util.List;

public class Types {
    private OneType oneType;
    private List<TwoType> twoType;

    public OneType getOneType() {
        return oneType;
    }

    public void setOneType(OneType oneType) {
        this.oneType = oneType;
    }

    public List<TwoType> getTwoType() {
        return twoType;
    }

    public void setTwoType(List<TwoType> twoType) {
        this.twoType = twoType;
    }
}
