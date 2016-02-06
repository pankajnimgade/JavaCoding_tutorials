package example.simple.xml.framework.two;

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
 */
public class TestDriveTwo {

    public static void main(String[] args) {
        try {
            Path paths = Paths.get("");
            String project_Path = paths.toAbsolutePath().toString();
            System.out.println("" + project_Path);
            String path = project_Path + "\\SimpleXMLFrameworkSample\\src\\example\\simple\\xml\\framework\\two\\test_one.xml";
            System.out.println(path);

            Serializer serializer = new Persister();
            File file = new File(path);

            Configuration configuration = serializer.read(Configuration.class, file);

            System.out.println(""+configuration.getIdentity());
            System.out.println(""+configuration.getServer().getHost());


        } catch (Exception e) {

        }
    }
}

@Root
class Configuration {
//    State or data or knows

    @Element
    private Server server;

    @Attribute
    private int id;

    //    behavior or method or does

    public int getIdentity() {
        return id;
    }

    public Server getServer() {
        return server;
    }
}

class Server {

    //    State or data or knows
    @Attribute
    private int port;

    @Element
    private String host;

    @Element
    private Security security;

    //    behavior or method or does

    public int getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }

    public Security getSecurity() {
        return security;
    }
}

class Security {
    //    state or data or knows
    @Attribute
    private boolean ssl;

    @Element
    private String keyStore;

    public Security() {
    }

    public Security(boolean ssl, String keyStore) {
        this.ssl = ssl;
        this.keyStore = keyStore;
    }

    // behavior or method or function or does
    public boolean isSSL() {
        return ssl;
    }

    public String getKeyStore() {
        return keyStore;
    }
}
