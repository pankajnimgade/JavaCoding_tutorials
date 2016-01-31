package test.excel.file.read;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Pankaj Nimgade on 29-01-2016.
 */
@Root (name = "ExrateList", strict = false)
public class ExrateList {
    @Element(required = false)
    private String DateTime;

    @ElementList (inline = true,required= false)
    private List<Exrate> Exrate;

    @Element(required = false)
    private String Source;

    public ExrateList() {
    }

    public ExrateList(String dateTime, String source) {
        DateTime = dateTime;
        Source = source;
    }

    public String getDateTime() {
        return DateTime;
    }

    public List<Exrate> getList() {
        return Exrate;
    }

    public String getSource() {
        return Source;
    }
}
