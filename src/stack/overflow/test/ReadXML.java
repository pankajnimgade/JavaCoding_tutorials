package stack.overflow.test;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import test.excel.file.read.Exrate;
import test.excel.file.read.ExrateList;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Pankaj Nimgade on 29-01-2016.
 */
public class ReadXML {

    public static void main(String[] args) {
        try {
            Path paths = Paths.get("");
            String project_Path = paths.toAbsolutePath().toString();
            System.out.println("" + project_Path);
            File file = new File(project_Path + "\\excel_files\\some.xml");

            Serializer serializer = new Persister();

            ExrateList example = serializer.read(ExrateList.class, file);

            System.out.println("" + example.getDateTime());
            for (Exrate exrate:example.getList()) {
                System.out.println(""+exrate.getCurrencyName()+"\t "+exrate.getCurrencyCode()+"\t "+exrate.getTransfer()+"\t "+exrate.getBuy()+"\t "+exrate.getSell());
            }
            System.out.println("" + example.getSource());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
