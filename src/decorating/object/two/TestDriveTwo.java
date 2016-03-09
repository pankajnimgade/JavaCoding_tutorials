package decorating.object.two;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Pankaj Nimgade on 07-03-2016.
 */
public class TestDriveTwo {

    public static void main(String[] args) {

        Path paths = Paths.get("");
        String project_Path = paths.toAbsolutePath().toString();
        File file = new File(project_Path + "\\src\\decorating\\object\\two\\text.txt");

        if (file != null) {
            if (file.exists()) {
                System.out.println("file exists");
                try {

                    InputStream inputStream = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream(file)));
                    int c = 0;
                    while ((c = inputStream.read())>=0) {
                        System.out.print((char)c);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
