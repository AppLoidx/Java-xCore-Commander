package xcore.commander.modules.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Weather parser<br>
 * Needs network connection
 *
 * @version 1.0.0
 * @author Arthur Kupriyanov
 * @see org.jsoup.Jsoup
 */
public class WeatherParser {
    private String city = "saint_petersburg";
    private Document doc;
    public WeatherParser() throws IOException {
        doc = Jsoup.connect(String.format("https://world-weather.ru/pogoda/russia/%s/",city)).get();
    }
    WeatherParser(String city) throws IOException {
        this.city = city;
        doc = Jsoup.connect(String.format("https://world-weather.ru/pogoda/russia/%s/",city)).get();
    }

    public String getWeatherFullDescription() throws IOException {
        Elements elements = doc.select("span.dw-into");
        return elements.text().replace("Подробнее", "").replace("Скрыть","");
    }

    public String getWeatherTodayDescription() throws IOException {
        Elements elements = doc.select("span.dw-into");
        return elements.text().split("Подробнее")[0];
    }

    public String getTemperature(int day){
        return getDaysTemperature().get(day);
    }

    private ArrayList<String> getDaysTemperature(){
        Elements elements = doc.select("div.day-temperature");
        return new ArrayList<>(elements.eachText());
    }

}
