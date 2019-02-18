package xcore.commander.commands;

import xcore.commander.modules.parser.WeatherParser;

import java.io.IOException;

/**
 * Example command
 *
 * @author Arthur Kupriyanov
 */
public class Weather extends Command{

    @Override
    public String exec(String input) {

        // write executable code here and return response

        try {

            // getting response using module WeatherParser

            return new WeatherParser().getWeatherFullDescription();

        } catch (IOException e) {
            e.printStackTrace();
            return e.toString();
        }
    }

    @Override
    protected void setName() {

        // setting command name
        commandName = "weather";
    }
}
