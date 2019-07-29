package com.bogdan.kolomiiets.xmlParser.entity;

public class Forecast {
    private Time time;

    public Forecast() {
    }

    public Forecast(Time time) {
        this.time = time;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Forecast{" +
                "time=" + time +
                '}';
    }
}
