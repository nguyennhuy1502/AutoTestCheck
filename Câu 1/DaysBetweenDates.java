import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DaysBetweenDates {
    public static void main(String[] args) throws ParseException {
        String startDateStr = "20170220";
        String closeDateStr = "20211224";
        
        DateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date startDate = format.parse(startDateStr);
        Date closeDate = format.parse(closeDateStr);
        
        long daysBetween = TimeUnit.DAYS.convert(closeDate.getTime() - startDate.getTime(), TimeUnit.MILLISECONDS);
        System.out.println("Total days between the start date and close date: " + daysBetween);
    }
}