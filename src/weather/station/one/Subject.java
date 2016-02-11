package weather.station.one;

/**
 * Created by Pankaj Nimgade on 11-02-2016.
 */
public interface Subject {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}
