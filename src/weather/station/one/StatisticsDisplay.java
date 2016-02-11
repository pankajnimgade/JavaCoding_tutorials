package weather.station.one;

/**
 * Created by Pankaj Nimgade on 11-02-2016.
 */
public class StatisticsDisplay extends SuperDisplay implements Observer, DisplayElement {

    public StatisticsDisplay(Subject subject) {
        if (subject != null) {
            subject.registerObserver(this);
        }
    }

    @Override
    public void display() {

    }

    @Override
    public void update(float temperature, float humidity, float pressure) {

    }
}
