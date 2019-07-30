package com.bogdan.kolomiiets.xmlParser;

import com.bogdan.kolomiiets.xmlParser.entity.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class WeatherDataParser {
    private WeatherData weatherData;

    public static void main(String[] args) {
        WeatherDataParser weatherDataParser = new WeatherDataParser();
        weatherDataParser.parseXML("XMLtoParse.xml");
        System.out.println(weatherDataParser.weatherData);
        System.out.println("===================================================");
        File file = WeatherDataExporter.exportWeatherDataToXML("WeatherDataExp.xml", weatherDataParser.weatherData);

    }

    public void parseXML(String fileName) {
        //Get Document Builder Factory
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder;
        Document document = null;
        try(InputStream inputStream = ClassLoader.getSystemResourceAsStream(fileName)) {
            //getting document builder
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            //build document
            document = documentBuilder.parse(inputStream);

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        //Normalize the XML Structure
        document.getDocumentElement().normalize();

        //getting and check root node
        Element root = document.getDocumentElement();
        if (root.getNodeName().equals("weatherdata")) {
            weatherData = new WeatherData();
            weatherData.setXmlVersion(document.getXmlVersion());
            weatherData.setEncoding(document.getXmlEncoding());
        } else {
            System.out.println("Attention, root element is incorrect!!!");
            return;
        }

        NodeList nodeList = document.getDocumentElement().getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++){
            if (nodeList.item(i) instanceof Element) {
                String nodeName = nodeList.item(i).getNodeName();
                if (nodeName.equals("location")){
                    weatherData.setLocation(parseLocation(nodeList.item(i)));
                }
                if (nodeName.equals("meta")){
                    weatherData.setMeta(parseMeta(nodeList.item(i)));
                }
                if (nodeName.equals("sun")){
                    weatherData.setSun(parseSun(nodeList.item(i)));
                }
                if (nodeName.equals("forecast")){
                    weatherData.setForecast(parseForecast(nodeList.item(i)));
                }
            }
        }
    }

    private Location parseLocation(Node item) {
        Location location = new Location();
        NodeList list = item.getChildNodes();
        for (int i = 0; i < list.getLength(); i++){
            if (list.item(i).getNodeName().equals("name")) location.setName(list.item(i).getTextContent());
            if (list.item(i).getNodeName().equals("type")) location.setType(list.item(i).getNodeValue());
            if (list.item(i).getNodeName().equals("country")) location.setCountry(list.item(i).getTextContent());
            if (list.item(i).getNodeName().equals("timezone") && list.item(i).hasAttributes()) location.setTimezone(TimeZone.getTimeZone(list.item(i).getTextContent()));
            if (list.item(i).getNodeName().equals("location")) {
                NamedNodeMap namedNodeMap = list.item(i).getAttributes();
                GeoLocation geoLocation = new GeoLocation(
                        Integer.valueOf(namedNodeMap.getNamedItem("geobaseid").getNodeValue()),
                        namedNodeMap.getNamedItem("geobase").getNodeValue(),
                        Double.valueOf(namedNodeMap.getNamedItem("longitude").getNodeValue()),
                        Double.valueOf(namedNodeMap.getNamedItem("latitude").getNodeValue()),
                        Double.valueOf(namedNodeMap.getNamedItem("altitude").getNodeValue())
                );
                location.setGeoLocation(geoLocation);
            }
        }
        return location;
    }

    private Meta parseMeta(Node item) {
        Meta meta = new Meta();
        NodeList list = item.getChildNodes();
        for (int i = 0; i < list.getLength(); i++){
            if (list.item(i).getNodeName().equals("lastupdate") && list.item(i).hasAttributes()) {
                meta.setLastUpdate(Calendar.getInstance());
            }
            if (list.item(i).getNodeName().equals("calctime")) {
                meta.setCalcTime(Double.parseDouble(list.item(i).getTextContent()));
            }
            if (list.item(i).getNodeName().equals("nextupdate") && list.item(i).hasAttributes()) {
                meta.setNextUpdate(Calendar.getInstance());
            }
        }
        return meta;
    }

    private Sun parseSun(Node item) {
        Sun sun = new Sun();
        NamedNodeMap namedNodeMap = item.getAttributes();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date;
        Calendar calendar = Calendar.getInstance();
        try {
            //set sun set
                date = sdf.parse(namedNodeMap.getNamedItem("set").getNodeValue());
                calendar.setTime(date);
                sun.setSet(calendar);

            //set sun rise
            date = sdf.parse(namedNodeMap.getNamedItem("rise").getNodeValue());
            calendar = Calendar.getInstance();
            calendar.setTime(date);
            sun.setRise(calendar);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sun;
    }

    private Forecast parseForecast(Node nodeForecast) {
        Forecast forecast = new Forecast();
        List<Time> timeList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        if (nodeForecast != null) {
            NodeList nodeList = nodeForecast.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                if (nodeList.item(i) instanceof Element) {
                    Element element = (Element) nodeList.item(i);
                    Calendar calendar = Calendar.getInstance();

                    //new Time instance
                    Time time = new Time();

                    //getting day attributes from element
                    try {
                        calendar.setTime(sdf.parse(element.getAttribute("day")));
                        time.setDay(calendar);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    NodeList list = element.getChildNodes();
                    for (int j = 0; j < list.getLength(); j++) {
                        if (list.item(j) instanceof Element) {
                            Element localElement = (Element) list.item(j);
                            if (localElement.hasAttributes()) {
                                if (localElement.getTagName().equals("symbol")) {
                                    Time.Symbol symbol = time.new Symbol();
                                    symbol.setVar(localElement.getAttribute("var"));
                                    symbol.setName(localElement.getAttribute("name"));
                                    symbol.setNumber(Integer.parseInt(localElement.getAttribute("number")));
                                    time.setSymbol(symbol);
                                }
                                if (localElement.getTagName().equals("precipitation")) {
                                    Time.Precipitation precipitation = time.new Precipitation();
                                    precipitation.setType(localElement.getAttribute("type"));
                                    precipitation.setValue(Double.parseDouble(localElement.getAttribute("value")));
                                    time.setPrecipitation(precipitation);
                                }
                                if (localElement.getTagName().equals("windDirection")){
                                    Time.WindDirection windDirection = time.new WindDirection();
                                    windDirection.setName(localElement.getAttribute("name"));
                                    windDirection.setCode(localElement.getAttribute("code"));
                                    windDirection.setDeg(Integer.parseInt(localElement.getAttribute("deg")));
                                    time.setWindDirection(windDirection);
                                }
                                if (localElement.getTagName().equals("windSpeed")){
                                    Time.WindSpeed windSpeed = time.new WindSpeed();
                                    windSpeed.setName(localElement.getAttribute("name"));
                                    windSpeed.setMps(Double.parseDouble(localElement.getAttribute("mps")));
                                    time.setWindSpeed(windSpeed);
                                }
                                if (localElement.getTagName().equals("temperature")){
                                    Time.Temperature temperature = time.new Temperature();
                                    temperature.setDay(Double.parseDouble(localElement.getAttribute("day")));
                                    temperature.setMorn(Double.parseDouble(localElement.getAttribute("morn")));
                                    temperature.setEve(Double.parseDouble(localElement.getAttribute("eve")));
                                    temperature.setNight(Double.parseDouble(localElement.getAttribute("night")));
                                    temperature.setMax(Double.parseDouble(localElement.getAttribute("max")));
                                    temperature.setMin(Double.parseDouble(localElement.getAttribute("min")));
                                    time.setTemperature(temperature);
                                }
                                if (localElement.getTagName().equals("pressure")){
                                    Time.Pressure pressure = time.new Pressure();
                                    pressure.setValue(Double.parseDouble(localElement.getAttribute("value")));
                                    pressure.setUnit(localElement.getAttribute("unit"));
                                    time.setPressure(pressure);
                                }
                                if (localElement.getTagName().equals("humidity")){
                                    Time.Humidity humidity = time.new Humidity();
                                    humidity.setValue(Integer.parseInt(localElement.getAttribute("value")));
                                    humidity.setUnit(localElement.getAttribute("unit"));
                                    time.setHumidity(humidity);
                                }
                                if (localElement.getTagName().equals("clouds")){
                                    Time.Clouds clouds = time.new Clouds();
                                    clouds.setValue(localElement.getAttribute("value"));
                                    clouds.setUnit(localElement.getAttribute("unit"));
                                    clouds.setAll(Integer.parseInt(localElement.getAttribute("all")));
                                    time.setClouds(clouds);
                                }
                            }
                        }
                    }
                    timeList.add(time);
                }
            }
        }
        forecast.setTime(timeList);
        return forecast;
    }
}
