package stack.overflow.test.two;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Pankaj Nimgade on 11-02-2016.
 */
public class ReadArrayFromFile {

    public static void main(String[] args) {

        try {
            File file = new File("file.txt");
            Path path = file.toPath();
            List<String> strings = Files.readAllLines(path);
//            List<String> strings = FileUtils.readLines(file);
            for (String s : strings) {
                System.out.println(s);
            }
            String[] string_array = new String[strings.size()];
            for (int i = 0; i < strings.size(); i++) {
                string_array[i] = strings.get(i);
            }
            System.out.println(Arrays.deepToString(string_array));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
