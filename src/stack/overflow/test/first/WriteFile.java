package stack.overflow.test.first;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Pankaj Nimgade on 10-02-2016.
 */
public class WriteFile {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("somename_" + i);
        }

        File file = new File("file.txt");
        try {
            FileUtils.writeLines(file, list);

            ArrayList<String> strings = (ArrayList<String>) FileUtils.readLines(file);

           ArrayList<Name> names = new ArrayList<>();

            for (String single:strings) {
                names.add(new Name(single));
                if (names.size() == 20) {
                    break;
                }
            }

            for (Name single_name:names) {
                System.out.println(single_name.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

class Name {

    String name;

    public Name(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        return this.name.equalsIgnoreCase(((Name) obj).getName());
    }
}
