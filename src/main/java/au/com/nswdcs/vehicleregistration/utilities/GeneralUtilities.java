package au.com.nswdcs.vehicleregistration.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;

/**
 * Created by George Shafik on 16/9/2022
 */
public class GeneralUtilities {

    public static String getCurrentDateTime() {
        SimpleDateFormat yyyymddhhmmsssSeparatedSdf = new SimpleDateFormat("yyyyMMdd'T'hh:mm:sss");
        return yyyymddhhmmsssSeparatedSdf.format(Calendar.getInstance().getTime());
    }

    public static Date convertYYYYMMddToDate(String dateToConvert) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("+10:00"));
        Date dateConverted = sdf.parse(dateToConvert);
        return dateConverted;
    }

    public static String convertDatetoYYYYMMdd(Date dateToConvert) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(dateToConvert);
    }

    public static boolean isAnyNullOrEmpty(Object... args) {
        for (Object obj : args) {
            boolean isNull = Objects.isNull(obj);
            if(isNull) {
                return true;
            }
            else if(obj instanceof String && ((String) obj).isBlank()) {
                return true;
            }
        }

        return false;
    }
}
