package weather.station.two.built.in.support;

/**
 * Created by Pankaj Nimgade on 11-02-2016.
 */
public abstract class SupperDisplay {

    //    instance variable ( data or knows or state)
    public float temperature;
    public float humidity;
    public float pressure;

    public SupperDisplay() {
        super();
    }

    abstract void display();


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
