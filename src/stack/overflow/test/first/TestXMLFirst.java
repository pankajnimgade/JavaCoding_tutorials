package stack.overflow.test.first;

import org.simpleframework.xml.*;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.util.Entry;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pankaj Nimgade on 05-02-2016.
 */
public class TestXMLFirst {

    public static void main(String[] args) {
        try {

            Path paths = Paths.get("");
            String project_Path = paths.toAbsolutePath().toString();
            System.out.println("path\n" + project_Path);

            Serializer serializer = new Persister();
            File source = new File(project_Path + "\\src\\stack\\overflow\\test\\first\\some.xml");

            Scenario scenario = serializer.read(Scenario.class, source);

            System.out.println("" + scenario.getName());
            ArrayList<Cmd> cmds = scenario.getCmds();

            for (Cmd cmd : cmds) {
                System.out.println("Query Name: " + cmd.getName());

                List<Return> list = cmd.getList();

                if (list != null) {

                    for (Return string : list) {
                        System.out.println("Return Value: " + string);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

@Root(name = "scenario", strict = false)
class Scenario {

    @Attribute(name = "name", required = false)
    private String name;

    @ElementList(name = "cmd", inline = true, required = false)
    private ArrayList<Cmd> cmds;

    public String getName() {
        return name;
    }

    public ArrayList<Cmd> getCmds() {
        return cmds;
    }
}

@Root(name = "cmd", strict = false)
class Cmd implements Entry{

    @Attribute(name = "name", required = false)
    private String name;

    @ElementList(name = "return", inline = true, required = false)
    private List<Return> list = new ArrayList<>();

    @Override
    public String getName() {
        return name;
    }

    public List<Return> getList() {
        return list;
    }
}

@Root(strict = false)
class Return implements Entry{

    @Text(required = false)
    private String name;

    public String getName() {
        return name;
    }

}
