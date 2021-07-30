package salesforce.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class StringToDate {
    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

    /**
     * Converts literal date String to a date format.
     *
     * @param stringToConvert a literal date String.
     * @return a date format.
     */
    public Date convert(final String stringToConvert) {
        if (stringToConvert == null || stringToConvert.equals("")) {
            throw new IllegalArgumentException("Invalid Argument: Unsupported String Format");
        }
        if (stringToConvert.matches("TODAY|TOMORROW|YESTERDAY")) {
            return dayName(stringToConvert);
        }
        if (stringToConvert.contains("ago") || stringToConvert.contains("from now")) {
            return getDateValue(stringToConvert);
        }
        if (stringToConvert.contains("/")) {
            try {
                return dateFormat.parse(stringToConvert);
            } catch (ParseException exception) {
                throw new IllegalArgumentException(exception);
            }
        }
        throw new IllegalArgumentException("Invalid Argument: Unsupported String Format");
    }

    /**
     * Converts 'TODAY, TOMORROW, YESTERDAY' to a date format.
     *
     * @param dateString a literal date String.
     * @return a date format.
     */
    public Date dayName(final String dateString) {
        if ("TODAY".equals(dateString)) {
            return getTodayDate();
        }
        if ("TOMORROW".equals(dateString)) {
            return getTimelineDate(1, Calendar.DATE);
        }
        if ("YESTERDAY".equals(dateString)) {
            return getTimelineDate(- 1, Calendar.DATE);
        }
        throw new IllegalArgumentException("Invalid Argument: Unsupported String Format");
    }

    /**
     * Converts literal dates that contains 'ago, from now' to a date format.
     *
     * @param dateString a literal date String.
     * @return a date format.
     */
    public Date getDateValue(final String dateString) {
        if (dateString.contains(" years ") || dateString.contains(" year ")) {
            return getTimeLine(getIntFromString(dateString), Calendar.YEAR, dateString);
        }
        if (dateString.contains(" months ") || dateString.contains(" month ")) {
            return getTimeLine(getIntFromString(dateString), Calendar.MONTH, dateString);
        }
        if (dateString.contains(" days ") || dateString.contains(" day ")) {
            return getTimeLine(getIntFromString(dateString), Calendar.DATE, dateString);
        }
        throw new IllegalArgumentException("Invalid Argument: Unsupported String Format");
    }

    /**
     * Gets a future or past 'day, month, year' in date format.
     *
     * @param number the number of 'day, month, year' from now.
     * @param type the type of value (day, month, year).
     * @param dateString a literal date String.
     * @return a date format.
     */
    public Date getTimeLine(int number, int type, String dateString) {
        if (dateString.contains(" from now")) {
            return getTimelineDate(number, type);
        }
        if (dateString.contains(" ago")) {
            return getTimelineDate(- number, type);
        }
        throw new IllegalArgumentException("Invalid Argument: Unsupported String Format");
    }

    /**
     * Gets actual date in date format.
     *
     * @return a date format.
     */
    public Date getTodayDate() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    /**
     * Gets a future or past 'day, month, year' in date format.
     *
     * @param number the number of 'day, month, year' from now.
     * @param type the type of value (day, month, year).
     * @return a date format.
     */
    public Date getTimelineDate(final int number, final int type) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(type, number);
        return calendar.getTime();
    }

    /**
     * Gets a number that is inside a string.
     *
     * @param string a string that contains a number.
     * @return a number that is inside a string.
     */
    public int getIntFromString(final String string) {
        return Integer.parseInt(string.replaceAll("[\\D]", ""));
    }

}
