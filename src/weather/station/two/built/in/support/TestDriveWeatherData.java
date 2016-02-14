package weather.station.two.built.in.support;

/**
 * Created by Pankaj Nimgade on 12-02-2016.
 */
public class TestDriveWeatherData {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        GeneralDisplay generalDispl, ay = new GeneralDisplay(weatherData);
        weatherData.setMeasurements(45, 87, 47);
        weatherData.setMeasurements(99, 54, 22);
        weatherData.setMeasurements(33, 48, 11);

        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        weatherData.setMeasurements(0.1f, 0.5f, 0.9f);
        weatherData.setMeasurements(.11f, .54f, .22f);
        weatherData.setMeasurements(.33f, .048f, .11f);
    }
}
