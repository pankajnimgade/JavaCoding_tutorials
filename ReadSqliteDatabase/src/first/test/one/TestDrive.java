package first.test.one;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Pankaj Nimgade on 06-03-2016.
 */
public class TestDrive {
    public static void main(String[] args) {

        Path paths = Paths.get("");
        String project_Path = paths.toAbsolutePath().toString();
        System.out.println(project_Path);
        String path = project_Path+"\\ReadSqliteDatabase\\src\\first\\test\\one\\myttc.db";

        File file = new File(path);
        if (file.exists()){
            System.out.println("yes");
        }
    }
}
