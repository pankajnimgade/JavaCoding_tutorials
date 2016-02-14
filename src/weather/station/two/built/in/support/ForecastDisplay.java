package weather.station.two.built.in.support;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Pankaj Nimgade on 11-02-2016.
 */
public class ForecastDisplay extends SupperDisplay implements Observer {

    private static final String TAG_CLASS = "ForecastDisplay";

    private Observable observable;

    public ForecastDisplay(Observable observable) {
        this.observable = observable;
        this.observable.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object arg) {
        if (observable instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) observable;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            this.pressure = weatherData.getPressure();
            display();
        }
    }

    @Override
    void display() {
        System.out.println(TAG_CLASS
                + "\nTemperature: " + this.temperature
                + "\nHumidity: " + this.humidity
                + "\nPressure: " + this.pressure+"\n");
    }
}
