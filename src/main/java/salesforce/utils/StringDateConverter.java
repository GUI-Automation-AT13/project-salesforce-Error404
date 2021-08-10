package salesforce.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Locale;

public class StringDateConverter {

    private static LocalDateTime date;
    private static final String SIMPLE_DATE_FORMAT = "\\d{4}(-|/)(0[1-9]|1[012])(-|/)(0[1-9]|[12][0-9]|[3][01])";
    private static final String SIMPLE_TIME_FORMAT = "T\\d{2}:\\d{2}:\\d{2}";
    private static final String SINGLE_WORD_FORMAT = "[ADEORSMWYT]+";
    private static final String ENUM_FORMAT = "[\\d]+\\s((day|days)|(month|months)|(year|years)|(seconds|second)"
            + "|(minutes|minute)|(hour|hours))\\s(from now|ago)";

    /**
     * Sends the String to the method to convert.
     * @param dateString the String date to convert.
     * Param format allowed:
     * 1. TODAY | YESTERDAY | TOMORROW.
     * 2. *number* day(s) | month(s) | year(s) | hour(s) | minute(s) | second(s) from now | ago.
     * 3. Date only = year -|/ month -|/ day
     *    Time only = T hour:minute:second
     *    Date and time = year -|/ month -|/ day T hour:minute:second
     * @return dateString as LocalDateTime
     */
    public static LocalDateTime convertDate(final String dateString) {
        if (validateNullEmpty(dateString)) {
            try  {
                if (dateString.matches(SIMPLE_DATE_FORMAT) || dateString.matches(SIMPLE_TIME_FORMAT)
                        || dateString.matches(SIMPLE_DATE_FORMAT.concat(SIMPLE_TIME_FORMAT))) {
                    dateStringConvert(dateString);
                } else if (dateString.matches(SINGLE_WORD_FORMAT)) {
                    singleWordDateConvert(dateString);
                } else if (dateString.matches(ENUM_FORMAT)) {
                    specificDateStringConvert(dateString);
                }
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid Argument: Unsupported String Format.");
            }
            return date.withNano(0);
        } else {
            throw new IllegalArgumentException("Invalid Argument: Unsupported String Format.");
        }
    }

    /**
     * Converts a String in the format "number days | month | year  ago | from now".
     * @param dateString String to convert.
     */
    private static void specificDateStringConvert(final String dateString) {
        String[] splited = dateString.split(" ");
        int number = Integer.parseInt(splited[0]);
        if (splited[1].endsWith("s")) {
            splited[1] = splited[1].substring(0, splited[1].lastIndexOf("s"));
        }
        if (splited[2].equals("ago")) {
            number = -number;
        }
        switch (DateStringTypeEnum.valueOf(splited[1].toUpperCase(Locale.ROOT))) {
            case DAY: date = LocalDateTime.now().plusDays(number); break;
            case MONTH: date = LocalDateTime.now().plusMonths(number); break;
            case YEAR: date = LocalDateTime.now().plusYears(number); break;
            case HOUR: date = LocalDateTime.now().plusHours(number); break;
            case MINUTE: date = LocalDateTime.now().plusMinutes(number); break;
            case SECOND: date = LocalDateTime.now().plusSeconds(number); break;
            default: break;
        }
    }

    /**
     * Converts a String in Date format.
     * Accepts only date with "/" or with "-".
     * Accepts only Time starting with T.
     * @param dateString String to convert.
     */
    private static void dateStringConvert(final String dateString) {
        String stringDateImproved = dateString;
        if (stringDateImproved.contains("/")) {
            stringDateImproved = stringDateImproved.replace("/", "-");
        }
        if (!stringDateImproved.contains("T") || !stringDateImproved.contains(":")) {
            date = LocalDate.parse(stringDateImproved).atTime(LocalTime.now());
        } else if (!stringDateImproved.contains("-")) {
            date = LocalTime.parse(stringDateImproved).atDate(LocalDate.now());
        } else {
            date = LocalDateTime.parse(stringDateImproved);
        }
    }

    /**
     * Converts a String with single word, "TODAY", "YESTERDAY", "TOMORROW".
     * @param dateString String to convert.
     */
    private static void singleWordDateConvert(final String dateString) {
        switch (DateStringTypeEnum.valueOf(dateString)) {
            case TODAY: date = LocalDateTime.now(); break;
            case TOMORROW: date = LocalDateTime.now().plusDays(1); break;
            case YESTERDAY: date = LocalDateTime.now().minusDays(1); break;
            default: break;
        }
    }

    /**
     * Validates the String, avoiding null or empty.
     * @param dateString String to validate.
     * @return true if String is valid.
     */
    private static boolean validateNullEmpty(final String dateString) {
        if (dateString == null || dateString == "") {
            return false;
        }
        return true;
    }
}
