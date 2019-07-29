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

    @Override
    public String toString() {
        return "\n\tTime{" +
                "day=" + (day != null ? day.get(Calendar.YEAR) + "-" + (day.get(Calendar.MONTH) + 1)+ "-" + day.get(Calendar.DATE) : "") +
                ", " + symbol +
                ", " + precipitation +
                ", " + windDirection +
                ", " + windSpeed +
                ", \n\t" + temperature +
                ", " + pressure +
                ", " + humidity +
                ", " + clouds +
                '}';
    }

    public class Symbol {
        private String var;
        private String name;
        private int number;

        public String getVar() {
            return var;
        }

        public void setVar(String var) {
            this.var = var;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        @Override
        public String toString() {
            return "Symbol{" +
                    "var='" + var + '\'' +
                    ", name='" + name + '\'' +
                    ", number=" + number +
                    '}';
        }
    }

    public class Precipitation{
        private String type;
        private double value;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Precipitation{" +
                    "type='" + type + '\'' +
                    ", value=" + value +
                    '}';
        }
    }

    public class WindDirection {
        private String name;
        private String code;
        private int deg;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public int getDeg() {
            return deg;
        }

        public void setDeg(int deg) {
            this.deg = deg;
        }

        @Override
        public String toString() {
            return "WindDirection{" +
                    "name='" + name + '\'' +
                    ", code='" + code + '\'' +
                    ", deg=" + deg +
                    '}';
        }
    }

    public class WindSpeed {
        private String name;
        private double mps;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getMps() {
            return mps;
        }

        public void setMps(double mps) {
            this.mps = mps;
        }

        @Override
        public String toString() {
            return "WindSpeed{" +
                    "name='" + name + '\'' +
                    ", mps=" + mps +
                    '}';
        }
    }

    public class Temperature {
        private double day;
        private double morn;
        private double eve;
        private double night;
        private double max;
        private double min;

        public double getDay() {
            return day;
        }

        public void setDay(double day) {
            this.day = day;
        }

        public double getMorn() {
            return morn;
        }

        public void setMorn(double morn) {
            this.morn = morn;
        }

        public double getEve() {
            return eve;
        }

        public void setEve(double eve) {
            this.eve = eve;
        }

        public double getNight() {
            return night;
        }

        public void setNight(double night) {
            this.night = night;
        }

        public double getMax() {
            return max;
        }

        public void setMax(double max) {
            this.max = max;
        }

        public double getMin() {
            return min;
        }

        public void setMin(double min) {
            this.min = min;
        }

        @Override
        public String toString() {
            return "Temperature{" +
                    "day=" + day +
                    ", morn=" + morn +
                    ", eve=" + eve +
                    ", night=" + night +
                    ", max=" + max +
                    ", min=" + min +
                    '}';
        }
    }

    public class Pressure{
        private double value;
        private String unit;

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        @Override
        public String toString() {
            return "Pressure{" +
                    "value=" + value +
                    ", unit='" + unit + '\'' +
                    '}';
        }
    }

    public class Humidity{
        private int value;
        private String unit;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        @Override
        public String toString() {
            return "Humidity{" +
                    "value=" + value +
                    ", unit='" + unit + '\'' +
                    '}';
        }
    }

    public class Clouds {
        private String value;
        private String unit;
        private int all;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public int getAll() {
            return all;
        }

        public void setAll(int all) {
            this.all = all;
        }

        @Override
        public String toString() {
            return "Clouds{" +
                    "value='" + value + '\'' +
                    ", unit='" + unit + '\'' +
                    ", all=" + all +
                    '}';
        }
    }
}

