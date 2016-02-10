package stack.overflow.test.first;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Pankaj Nimgade on 10-02-2016.
 */
public class WriteFile {

    public static void main(String[] args){
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("somename_"+i);
        }

        File file = new File("file.txt");
        try {
            FileUtils.writeLines(file, list);

            ArrayList<String> strings = (ArrayList<String>) FileUtils.readLines(file);

            for (String single_name:strings) {
                System.out.println(single_name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
