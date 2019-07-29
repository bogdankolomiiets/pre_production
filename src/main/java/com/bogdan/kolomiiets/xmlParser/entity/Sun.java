package com.bogdan.kolomiiets.xmlParser.entity;

import java.util.Calendar;

public class Sun {
    private Calendar set;
    private Calendar rise;

    public Sun() {
    }

    public Sun(Calendar set, Calendar rise) {
        this.set = set;
        this.rise = rise;
    }

    public Calendar getSet() {
        return set;
    }

    public void setSet(Calendar set) {
        this.set = set;
    }

    public Calendar getRise() {
        return rise;
    }

    public void setRise(Calendar rise) {
        this.rise = rise;
    }

    @Override
    public String toString() {
        return "Sun{" +
                "set = " + (set != null ? set.getTime() : "") +
                ", rise = " + (rise != null ? rise.getTime() : "") +
                '}';
    }
}
