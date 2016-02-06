package example.simple.xml.framework.three;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Pankaj Nimgade on 07-02-2016.
 */
public class TestDriveThree {

    public static void main(String[] args) {
        try{

            Path paths = Paths.get("");
            String project_Path = paths.toAbsolutePath().toString();
            System.out.println("" + project_Path);
            String path = project_Path + "\\SimpleXMLFrameworkSample\\src\\example\\simple\\xml\\framework\\three\\test_three.xml";

            File file = new File(path);

            if (file == null) {
                file.createNewFile();
            }

            Serializer serializer = new Persister();
            OptionalExample optionalExample = new OptionalExample();

            optionalExample.setAddress("something to be");
            optionalExample.setId("some id");

            serializer.write(optionalExample, file);


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

@Root(name = "optionalExample", strict = false)
class OptionalExample{

    @Attribute(name = "version",required = false)
    private String version;

    @Attribute(name = "id")
    private String id;

    @Element(name = "name", required = false)
    private String name;

    @Element (name = "address")
    private String address;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
