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
            String path = project_Path + "\\SimpleXMLFrameworkSample\\src\\example\\simple\\xml\\framework\\two\\test_two.xml";
            System.out.println(path);

            /**
             * Writing....
             */
            Serializer serializer = new Persister();
            File file = new File(path);
            if (file == null) {
                file.createNewFile();
            }

            Security security = new Security();
            security.setSsl(false);
            security.setKeyStore("My_key_store");

            Server server = new Server();
            server.setHost("www.google.com");
            server.setPort(8080);
            server.setSecurity(security);

            Configuration configuration = new Configuration();
            configuration.setId(123);
            configuration.setServer(server);

            serializer.write(configuration, file);


        } catch (Exception e) {

        }
    }
}

@Root (name = "configuration", strict = false)
class Configuration {
//    State or data or knows

    @Element (name = "server", required = false)
    private Server server;

    @Attribute (name = "id",required = false)
    private int id;

    //    behavior or method or does


    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

@Root (name = "server", strict = false)
class Server {

    //    State or data or knows
    @Attribute (name = "port", required = false)
    private int port;

    @Element (name = "host", required = false)
    private String host;

    @Element (name = "security", required = false)
    private Security security;

    //    behavior or method or does


    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }
}
@Root(name = "security",strict = false)
class Security {
    //    state or data or knows
    @Attribute (name = "ssl", required = false)
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

    public boolean isSsl() {
        return ssl;
    }

    public void setSsl(boolean ssl) {
        this.ssl = ssl;
    }

    public String getKeyStore() {
        return keyStore;
    }

    public void setKeyStore(String keyStore) {
        this.keyStore = keyStore;
    }
}
