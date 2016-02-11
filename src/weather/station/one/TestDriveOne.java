package weather.station.one;

/**
 * Created by Pankaj Nimgade on 11-02-2016.
 */
public class TestDriveOne {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentCondition one = new CurrentCondition(weatherData);


        weatherData.setMeasurements(10,15,25);
        weatherData.setMeasurements(14,85,211);
        weatherData.setMeasurements(20,17,275);
    }
}
