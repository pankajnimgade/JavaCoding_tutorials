package stack.overflow.test.first;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.Map;
import java.util.Set;

/**
 * Created by Pankaj Nimgade on 11-02-2016.
 */
public class ReadJsonOne {


    public static void main(String[] args){

        File file = new File("file_json_test_one.txt");

        try {
            String result = FileUtils.readFileToString(file);
//            System.out.println(result);

            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result); // result is your json data
            JsonObject obj = element.getAsJsonObject();

//            System.out.println(obj.toString());

            JsonObject jsonObject = obj.getAsJsonObject("ActionRecord");

//            System.out.println(jsonObject);

            Set<Map.Entry<String, JsonElement>> stringSet = jsonObject.entrySet();

            for (Map.Entry<String, JsonElement> key :stringSet) {
                System.out.println(jsonObject.getAsJsonObject(key.getKey()).toString());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
