package com.bogdan.kolomiiets.xmlParser.entity;

public class WeatherData {
    private Location location;
    private Sun sun;
    private Forecast forecast;
    private Meta meta;

    public WeatherData() {
    }

    public WeatherData(Location location, Sun sun, Forecast forecast, Meta meta) {
        this.location = location;
        this.sun = sun;
        this.forecast = forecast;
        this.meta = meta;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Sun getSun() {
        return sun;
    }

    public void setSun(Sun sun) {
        this.sun = sun;
    }

    public Forecast getForecast() {
        return forecast;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    @Override
    public String toString() {
        return "WeatherData{\n" + location +
                ", \n" + sun +
                ", \n" + forecast +
                ", \n" + meta +
                '}';
    }
}
