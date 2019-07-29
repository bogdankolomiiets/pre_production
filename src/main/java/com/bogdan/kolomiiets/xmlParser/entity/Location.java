package com.bogdan.kolomiiets.xmlParser.entity;

import java.util.TimeZone;

public class Location {
    private String name;
    private String type;
    private String country;
    private TimeZone timezone;
    private GeoLocation geoLocation;

    public Location() {
    }

    public Location(String name, String type, String country, TimeZone timezone, GeoLocation geoLocation) {
        this.name = name;
        this.type = type;
        this.country = country;
        this.timezone = timezone;
        this.geoLocation = geoLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public TimeZone getTimezone() {
        return timezone;
    }

    public void setTimezone(TimeZone timezone) {
        this.timezone = timezone;
    }

    public GeoLocation getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(GeoLocation geoLocation) {
        this.geoLocation = geoLocation;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name = '" + name + '\'' +
                ", type = '" + (type != null ? type : "" ) + '\'' +
                ", country = '" + country + '\'' +
                ", timezone = " + (timezone != null ? timezone : "''" ) + " " + geoLocation +
                '}';
    }
}
