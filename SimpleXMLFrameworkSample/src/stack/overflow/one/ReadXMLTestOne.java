package stack.overflow.one;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

/**
 * Created by Pankaj Nimgade on 21-02-2016.
 */
public class ReadXMLTestOne {

    public static void main(String args[]) {
        try {
            Path paths = Paths.get("");
            String project_Path = paths.toAbsolutePath().toString();
            System.out.println("" + project_Path);
            String path = project_Path + "\\SimpleXMLFrameworkSample\\src\\stack\\overflow\\one\\one.xml";


            File file = new File(path);
            if (file.exists()) {
                System.out.println("Exists");

                /**
                 * Reading the xml file into an Object
                 */
                Serializer serializer_Read = new Persister();
                File source = new File(path);
                Response response = serializer_Read.read(Response.class, source);

                Collections.sort(response.getStations());
                System.out.println("" + response.getStations().size());
                for (Station station : response.getStations()) {
                    System.out.println("" + station.getStation_id());
                }

            } else {
                System.out.println("does not exist");
            }
        } catch (Exception e) {

        }
    }


}


@Root(name = "root", strict = false)
class Response {

    @ElementList(name = "station", inline = true)
    List<Station> stations;


    public List<Station> getStations() {
        return stations;
    }
}

@Root(name = "station", strict = false)
class Station implements Comparable<Station> {

    @Element(name = "station_id", required = false)
    private String station_id;

    @Element(name = "latitude", required = false)
    private String latitude;

    @Element(name = "longitude", required = false)
    private String longitude;

    @Element(name = "xml_url", required = false)
    private String xml_url;

    @Element(name = "distance", required = true)
    private int distance;

    public Station() {
    }

    public Station(String station_id, String latitude, String longitude, String xml_url) {
        this.station_id = station_id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.xml_url = xml_url;
    }

    public String getStation_id() {
        return station_id;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getXml_url() {
        return xml_url;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Station o) {
        Station station = (Station) o;
        return this.distance - station.getDistance();
    }
}
