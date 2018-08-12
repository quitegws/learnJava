import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: gws
 * @Date: 19/07/2018 00:37
 * @Description:
 */
public class TimeDateCalendar {
    public static void main(String[] args) throws InterruptedException {
        Calendar calendar = Calendar.getInstance();
        Thread.sleep(3000);

        System.out.println(calendar.getTime());
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));//0-11
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println(calendar.get(Calendar.MINUTE));
        System.out.println(calendar.get(Calendar.SECOND));


        SimpleDateFormat oldFormatter = new SimpleDateFormat("yyyy/MM/dd");
        Date date1 = new Date();
        System.out.println(oldFormatter.format(date1));

        // Java 8
        DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate date2 = LocalDate.now();
        System.out.println(date2.format(newFormatter));

        new Thread(()->{
            log2("m1","m2");
        }).start();

    }

    public static void log2(String msg1, String msg2){
        synchronized(TimeDateCalendar.class){
            System.out.println(msg1+msg2);
        }
    }
}
