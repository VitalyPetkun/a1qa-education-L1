package utils;

import framework.utils.MyLogger;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateUtils {
    public static String getDateForTextBoxSelectDate() {
        return new SimpleDateFormat("MM/dd/yyyy",  Locale.ENGLISH).format(new GregorianCalendar().getTime());
    }

    public static String getDateForTextBoxDateAndTime() {
        return new SimpleDateFormat("MMMM d, yyyy h:mm a",  Locale.ENGLISH).format(new GregorianCalendar().getTime());
    }

    public static String getNearestLeapYear() {
        MyLogger.logInfo("get nearest leap year.");
        GregorianCalendar gcalendar = new GregorianCalendar();
        int nearestLeapYear = gcalendar.get(Calendar.YEAR);
        while (!gcalendar.isLeapYear(nearestLeapYear)) {
            ++nearestLeapYear;
        }
        return String.valueOf(nearestLeapYear);
    }

    public static String getNearest_29_February_forTextBoxSelectDate() {
        MyLogger.logInfo("get nearest 29 February.");
        GregorianCalendar gcalendar = new GregorianCalendar();
        int nearestLeapYear = gcalendar.get(Calendar.YEAR);
        while (!gcalendar.isLeapYear(nearestLeapYear)) {
            ++nearestLeapYear;
        }
        return ("02/29/" + String.valueOf(nearestLeapYear));
    }
}
