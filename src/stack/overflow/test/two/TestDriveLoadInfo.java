package stack.overflow.test.two;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.commons.io.IOUtils;

import javax.net.ssl.HttpsURLConnection;
import java.net.URL;
import java.util.HashMap;

/**
 * Created by Pankaj Nimgade on 07-02-2016.
 */
public class TestDriveLoadInfo {

    public static void main(String[] args) {

        try {

            URL url = new URL("https://blockchain.info/ticker");
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            httpsURLConnection.connect();
            String result = IOUtils.toString(httpsURLConnection.getInputStream());
            System.out.println("" + result);

            HashMap<String, Information> map = new HashMap<>();

            JsonElement jsonElement = (new Gson()).fromJson(result, JsonElement.class);
            JsonObject jsonObject = jsonElement.getAsJsonObject();



        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class Information {

    private String a_15m;
    private String last;
    private String buy;
    private String sell;
    private String symbol;

    public String getA_15m() {
        return a_15m;
    }

    public void setA_15m(String a_15m) {
        this.a_15m = a_15m;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getBuy() {
        return buy;
    }

    public void setBuy(String buy) {
        this.buy = buy;
    }

    public String getSell() {
        return sell;
    }

    public void setSell(String sell) {
        this.sell = sell;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
