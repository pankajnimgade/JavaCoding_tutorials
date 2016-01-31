package test.excel.file.read;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * Created by Pankaj Nimgade on 29-01-2016.
 */
@Root (name = "Exrate", strict = false)
public class Exrate {
    @Attribute(required = false)
    private String CurrencyCode;

    @Attribute(required = false)
    private String CurrencyName;

    @Attribute(required = false)
    private String Buy;

    @Attribute(required = false)
    private String Transfer;

    @Attribute(required = false)
    private String Sell;

    public Exrate() {
    }

    public Exrate(String currencyCode, String currencyName, String buy, String transfer, String sell) {
        CurrencyCode = currencyCode;
        CurrencyName = currencyName;
        Buy = buy;
        Transfer = transfer;
        Sell = sell;
    }

    public String getCurrencyCode() {
        return CurrencyCode;
    }

    public String getCurrencyName() {
        return CurrencyName;
    }

    public String getBuy() {
        return Buy;
    }

    public String getTransfer() {
        return Transfer;
    }

    public String getSell() {
        return Sell;
    }
}
