import java.util.Calendar;
import java.util.Date;

/**
 * @Author: gws
 * @Date: 2019-03-18 17:33
 * @Description:
 */
public class TimeConverter {


    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        Date now = new Date();
        long t = (2067L * 24 * 60 * 60 * 1000);
        long interval = now.getTime() - t;
        System.out.println(t);
        System.out.println(now.getTime());
        System.out.println(interval);
        now.setTime(interval);
        calendar.setTimeInMillis(interval);
        System.out.println(now.getDay());
    }
}
