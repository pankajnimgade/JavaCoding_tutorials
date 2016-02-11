package stack.overflow.test.first;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;

/**
 * Created by Pankaj Nimgade on 11-02-2016.
 */
public class ReadJsonTwo {

    public static void main(String[] args){

        File file = new File("file_json_test_one.txt");

        try {
            String result = FileUtils.readFileToString(file);
            System.out.println(result);

            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result); // result is your json data
            JsonObject obj = element.getAsJsonObject();

//            System.out.println(obj.toString());

            JsonObject jsonObject = obj.getAsJsonObject("ActionRecord");

            Type type = new TypeToken<Map<String, Record>>(){}.getType();
            Map<String, Record> myMap = (new Gson()).fromJson(jsonObject.toString(), type);

            Set<String>  stringSet = myMap.keySet();

            for (String string:stringSet) {
                Record record = myMap.get(string);
                System.out.println(record.getPoint());
            }
            System.out.println(jsonObject.toString());

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class ActionRecord{
    @SerializedName("ActionRecord")
    Set<Map.Entry<String, Record>> stringSet;

    public Set<Map.Entry<String, Record>> getStringSet() {
        return stringSet;
    }

    public void setStringSet(Set<Map.Entry<String, Record>> stringSet) {
        this.stringSet = stringSet;
    }
}

class Record{
    private String Desc;
    private String Done;
    private String MaxTimes;
    private String Point;
    private String Times;

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public String getDone() {
        return Done;
    }

    public void setDone(String done) {
        Done = done;
    }

    public String getMaxTimes() {
        return MaxTimes;
    }

    public void setMaxTimes(String maxTimes) {
        MaxTimes = maxTimes;
    }

    public String getPoint() {
        return Point;
    }

    public void setPoint(String point) {
        Point = point;
    }

    public String getTimes() {
        return Times;
    }

    public void setTimes(String times) {
        Times = times;
    }
}
