package com.bogdan.kolomiiets.xmlParser.entity;

public class WeatherData {
    private String xmlVersion;
    private String encoding;
    private Location location;
    private Sun sun;
    private Forecast forecast;
    private Meta meta;

    public WeatherData() {
    }

    public WeatherData(String xmlVersion, String encoding, Location location, Sun sun, Forecast forecast, Meta meta) {
        this.xmlVersion = xmlVersion;
        this.encoding = encoding;
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

    public String getXmlVersion() {
        return xmlVersion;
    }

    public void setXmlVersion(String xmlVersion) {
        this.xmlVersion = xmlVersion;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    @Override
    public String toString() {
        return "WeatherData{\n\txml version = " + xmlVersion + " encoding = " + encoding + "\n" + location +
                ", \n" + sun +
                ", \n" + forecast +
                ", \n" + meta +
                '}';
    }
}
