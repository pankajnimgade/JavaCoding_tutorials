package weather.station.one;

/**
 * Created by Pankaj Nimgade on 08-02-2016.
 */
public class WeatherData {

    //    instance variable ( data or knows or state)
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
    }

    public void measurmentsChanged(){
        float temp = getTemperature();
        float humidity = getHumidity();
        float pressure = getPressure();
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }
}
