package example.simple.xml.framework.one;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Pankaj Nimgade on 06-02-2016.
 */
public class SerializingTestDriveOne {
    public static void main(String[] args) {
        try {
            Path paths = Paths.get("");
            String project_Path = paths.toAbsolutePath().toString();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


class Example {

}
