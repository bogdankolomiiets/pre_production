package com.bogdan.kolomiiets.xmlParser.entity;

import java.util.Calendar;

public class Time {
    private Calendar day;
    private Symbol symbol;
    private Precipitation precipitation;
    private WindDirection windDirection;
    private WindSpeed windSpeed;
    private Temperature temperature;
    private Pressure pressure;
    private Humidity humidity;
    private Clouds clouds;

    public Time() {
    }

    public Calendar getDay() {
        return day;
    }

    public void setDay(Calendar day) {
        this.day = day;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public Precipitation getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(Precipitation precipitation) {
        this.precipitation = precipitation;
    }

    public WindDirection getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(WindDirection windDirection) {
        this.windDirection = windDirection;
    }

    public WindSpeed getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(WindSpeed windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public Pressure getPressure() {
        return pressure;
    }

    public void setPressure(Pressure pressure) {
        this.pressure = pressure;
    }

    public Humidity getHumidity() {
        return humidity;
    }

    public void setHumidity(Humidity humidity) {
        this.humidity = humidity;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    class Symbol {
        private String var;
        private String name;
        private int number;

        public Symbol(String var, String name, int number) {
            this.var = var;
            this.name = name;
            this.number = number;
        }
    }

    class Precipitation{
        private String type;
        private double value;

        public Precipitation(String type, double value) {
            this.type = type;
            this.value = value;
        }
    }

    class WindDirection {
        private String name;
        private String code;
        private int deg;

        public WindDirection(String name, String code, int deg) {
            this.name = name;
            this.code = code;
            this.deg = deg;
        }
    }

    class WindSpeed {
        private String name;
        private double mps;

        public WindSpeed(String name, double mps) {
            this.name = name;
            this.mps = mps;
        }
    }

    class Temperature {
        private double day;
        private double morn;
        private double eve;
        private double night;
        private double max;
        private double min;

        public Temperature(double day, double morn, double eve, double night, double max, double min) {
            this.day = day;
            this.morn = morn;
            this.eve = eve;
            this.night = night;
            this.max = max;
            this.min = min;
        }
    }

    class Pressure{
        private double value;
        private String unit;

        public Pressure(double value, String unit) {
            this.value = value;
            this.unit = unit;
        }
    }

    class Humidity{
        private int value;
        private String unit;

        public Humidity(int value, String unit) {
            this.value = value;
            this.unit = unit;
        }
    }

    class Clouds {
        private String value;
        private String unit;
        private int all;

        public Clouds(String value, String unit, int all) {
            this.value = value;
            this.unit = unit;
            this.all = all;
        }
    }
}

