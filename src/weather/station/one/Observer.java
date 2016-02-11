package weather.station.one;

/**
 * Created by Pankaj Nimgade on 11-02-2016.
 */
public interface Observer {

    void update(float temperature, float humidity, float pressure);
}
