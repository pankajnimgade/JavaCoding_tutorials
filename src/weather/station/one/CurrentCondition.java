package weather.station.one;

/**
 * Created by Pankaj Nimgade on 11-02-2016.
 */
public class CurrentCondition extends SuperDisplay implements Observer, DisplayElement{

    private static final String CLASS_NAME = "CurrentCondition";
    private Subject subject;

    public CurrentCondition(Subject subject) {
        if (subject != null) {
            this.subject = subject;
            subject.registerObserver(this);
        }
    }

    @Override
    public void display() {
        System.out.println();
        System.out.println(CLASS_NAME
                +"\nTemperature: "+temperature
                +"\nHumidity: "+humidity
                +"\nPressure: "+pressure);
        System.out.println();

    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }
}
