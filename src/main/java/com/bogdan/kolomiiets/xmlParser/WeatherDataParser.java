package com.bogdan.kolomiiets.xmlParser;

import com.bogdan.kolomiiets.xmlParser.entity.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class WeatherDataParser {
    private WeatherData weatherData;

    public static void main(String[] args) {
        WeatherDataParser weatherDataParser = new WeatherDataParser();
        weatherDataParser.parseXML("XMLtoParse.xml");
        System.out.println(weatherDataParser.weatherData);
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

    private Forecast parseForecast(Node item) {
        Forecast forecast = new Forecast();
        return forecast;
    }
}
