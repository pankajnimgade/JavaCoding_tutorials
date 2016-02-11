package stack.overflow.test.first;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Pankaj Nimgade on 11-02-2016.
 */
public class TestDriveNumberFOrmat {

    public static void main(String[] args){

        String createdTime = "1279340983";
        Date date1 = new Date(Long.parseLong(createdTime) * 1000); // right here

        System.out.println(date1.toString());
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss zzz");
        sdf1.setTimeZone(TimeZone.getTimeZone("GMT"));
        System.out.println(sdf1.format(date1));
    }
}
