package framework.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DateUtil {

    public static String getCurrentDate(String datePattern){
        DateFormat sdf = new SimpleDateFormat(datePattern);
        return sdf.format(new Date());
    }

    public static Date parseStringToDate(String dateString, String datePattern){
        Date date = null;
        try {
            date = new SimpleDateFormat(datePattern).parse(dateString);
        } catch (ParseException e) {
            LogUtil.error(e.toString());
        }
        return date;
    }

    public static boolean isSortedByDescendingDate(List<Date> dateList){
        boolean isSorted = true;
        for (int i = 0; i < dateList.size() - 1; i++){
            if (dateList.get(i).before(dateList.get(i+1))){
                isSorted = false;
                break;
            }
        }
        return isSorted;
    }
}
