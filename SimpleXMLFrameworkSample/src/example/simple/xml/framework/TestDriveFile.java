package example.simple.xml.framework;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Pankaj Nimgade on 05-02-2016.
 */
public class TestDriveFile {

    public static  void main(String[] args){
        try{
            Path paths = Paths.get("");
            String project_Path = paths.toAbsolutePath().toString();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
