package com.bogdan.kolomiiets.xmlParser.entity;

import java.util.Calendar;

public class Meta {
    private Calendar lastUpdate;
    private Calendar nextUpdate;
    private Double calcTime;

    public Meta() {
    }

    public Meta(Calendar lastUpdate, Calendar nextUpdate, Double calcTime) {
        this.lastUpdate = lastUpdate;
        this.nextUpdate = nextUpdate;
        this.calcTime = calcTime;
    }

    public Calendar getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Calendar lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Calendar getNextUpdate() {
        return nextUpdate;
    }

    public void setNextUpdate(Calendar nextUpdate) {
        this.nextUpdate = nextUpdate;
    }

    public Double getCalcTime() {
        return calcTime;
    }

    public void setCalcTime(Double calcTime) {
        this.calcTime = calcTime;
    }

    @Override
    public String toString() {
        return "Meta{" +
                "lastUpdate = " + lastUpdate +
                ", nextUpdate = " + nextUpdate +
                ", calcTime = " + calcTime +
                '}';
    }
}
