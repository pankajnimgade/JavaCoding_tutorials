package train.test.one.reading.excel;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Pankaj Nimgade on 22-01-2016.
 */
public class FindCurrentDirectory {

    public FindCurrentDirectory() {

    }

    public static void main(String[] args){
        System.out.println("something to be");
        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));

        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current relative path is: " + s);
    }

}
