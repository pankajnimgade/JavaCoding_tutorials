package stack.overflow.test.three;

import java.util.ArrayList;

/**
 * Created by Pankaj Nimgade on 03-03-2016.
 */
public class TestDriveOne {

    public static void main(String[] args){

        ArrayList<Station> stations = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            stations.add(new Station("one"));
        }

        System.out.println();
        for (Station station :stations) {
            System.out.println(station.toString());
        }

    }
}

class Station{

    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        Station other_Station = (Station)obj;
        return this.name.trim().contentEquals(other_Station.toString().trim());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + name.hashCode();
        hash = 31 * hash + (null == name ? 0 : name.hashCode());
        return hash;
    }

    @Override
    public String toString() {
        return name;
    }
}

