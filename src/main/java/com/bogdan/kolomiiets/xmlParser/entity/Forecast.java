package com.bogdan.kolomiiets.xmlParser.entity;

import java.util.Arrays;
import java.util.List;

public class Forecast {
    private List<Time> timeList;

    public Forecast() {
    }

    public List<Time> getTime() {
        return timeList;
    }

    public void setTime(List timeList) {
        this.timeList = timeList;
    }

    @Override
    public String toString() {
        return "Forecast{" +
                timeList + '}';
    }
}
