package example.simple.xml.framework.one;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Pankaj Nimgade on 06-02-2016.
 * <p/>
 * {http://simple.sourceforge.net/download/stream/doc/tutorial/tutorial.php#start}
 */
public class SerializingTestDriveOne {
    public static void main(String[] args) {
        try {
            Path paths = Paths.get("");
            String project_Path = paths.toAbsolutePath().toString();
            System.out.println("" + project_Path);
            String path = project_Path + "\\SimpleXMLFrameworkSample\\src\\example\\simple\\xml\\framework\\one\\test_one.xml";

            /**
             * Writing Object to the xml file
             */
            Serializer serializer_write = new Persister();
            Example example = new Example(12, "Test_example");
            File file = new File(path);
            serializer_write.write(example, file);

            /**
             * Reading the xml file into an Object
             */
            Serializer serializer_Read = new Persister();
            File source = new File(path);
            Example example_read = serializer_Read.read(Example.class, source);

            System.out.println("ID: "+example_read.getId());
            System.out.println("Text: "+example_read.getText());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

@Root(name = "root", strict = false)
class Example {

    @Attribute(name = "ID", required = false)
    private int id;

    @Element(name = "Text", required = false)
    private String text;

    public Example() {
        super();
    }

    public Example(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
