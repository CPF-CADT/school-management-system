package progress.test_code;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class DateFunction {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2006, Calendar.MARCH, 11);
        Date currentDate = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = formatter.format(currentDate);
        System.out.println(formattedDate);
    }
}
