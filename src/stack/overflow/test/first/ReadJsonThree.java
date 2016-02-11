package stack.overflow.test.first;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.io.FileUtils;

import java.io.File;

/**
 * Created by Pankaj Nimgade on 11-02-2016.
 */
public class ReadJsonThree {

    public static void main(String[] args) {

        File file = new File("file_json_test_two.txt");

        try {
            String result = FileUtils.readFileToString(file);
            System.out.println(result);

            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result); // result is your json data
            JsonObject obj = element.getAsJsonObject();

//            System.out.println(obj.toString());

            JsonArray asJsonArray = obj.getAsJsonArray("Result");

            for (int i = 0; i < asJsonArray.size(); i++) {
               JsonObject single_JsonObject= asJsonArray.get(i).getAsJsonObject();
                System.out.println(""+single_JsonObject.get("at_id"));
                System.out.println(""+single_JsonObject.get("admissionid"));
                System.out.println(""+single_JsonObject.get("class_id"));
                System.out.println(""+single_JsonObject.get("class_name"));
                System.out.println(""+single_JsonObject.get("at_date"));
                System.out.println(""+single_JsonObject.get("attendance"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
