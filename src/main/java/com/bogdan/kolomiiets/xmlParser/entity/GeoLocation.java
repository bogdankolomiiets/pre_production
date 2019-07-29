package com.bogdan.kolomiiets.xmlParser.entity;

public class GeoLocation {
    private int geobaseId;
    private String geobase;
    private Double longitude;
    private Double latitude;
    private Double altitude;

    public GeoLocation() {
    }

    public GeoLocation(int geobaseId, String geobase, Double longitude, Double latitude, Double altitude) {
        this.geobaseId = geobaseId;
        this.geobase = geobase;
        this.longitude = longitude;
        this.latitude = latitude;
        this.altitude = altitude;
    }

    public int getGeobaseId() {
        return geobaseId;
    }

    public void setGeobaseId(int geobaseId) {
        this.geobaseId = geobaseId;
    }

    public String getGeobase() {
        return geobase;
    }

    public void setGeobase(String geobase) {
        this.geobase = geobase;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getAltitude() {
        return altitude;
    }

    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }

    @Override
    public String toString() {
        return "GeoLocation{" +
                "geobaseId=" + geobaseId +
                ", geobase='" + geobase + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", altitude=" + altitude +
                '}';
    }
}
