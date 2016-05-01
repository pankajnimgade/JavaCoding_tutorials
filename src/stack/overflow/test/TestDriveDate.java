package stack.overflow.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Pankaj Nimgade on 21-03-2016.
 */
public class TestDriveDate {

    public static void main(String[] args) {

        Date initial_date = new Date();
//        System.out.println("initial_date:\t"+initial_date.toString());
        Calendar c = Calendar.getInstance();
        c.setTime(initial_date);
        c.add(Calendar.DATE, 1);
        Date final_date = c.getTime();
//        System.out.println("final_date:\t"+final_date.toString());

//        shiftDate(new Date());

        setWindowEdit();
    }

    private static void setWindowEdit() {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date start_Date = simpleDateFormat.parse("01-01-2016");
            System.out.println(start_Date);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(start_Date);
            System.out.println("Calender:\t"+calendar.getTime());
            calendar.add(Calendar.DATE,1);
            System.out.println("Calender:\t"+calendar.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void shiftDate(Date d) {
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.add(Calendar.DATE, 1);
        d.setTime(c.getTimeInMillis());
        System.out.println(d.toString());
    }


}
