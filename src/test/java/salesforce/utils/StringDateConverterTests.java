package salesforce.utils;

import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.testng.Assert.assertEquals;

public class StringDateConverterTests {
    private final int numTest10 = 10;
    private final int numTest20 = 20;
    private final int numTest15 = 15;

    @Test
    public void shouldReturnTodayDateWithTodayString() {
        String dateString = "TODAY";
        StringDateConverter dateConverter = new StringDateConverter();
        LocalDateTime actualDate = dateConverter.convertDate(dateString);
        assertEquals(actualDate, LocalDateTime.now().withNano(0));
    }

    @Test
    public void shouldReturnTomorrowDateWithTomorrowString() {
        String dateString = "TOMORROW";
        StringDateConverter dateConverter = new StringDateConverter();
        LocalDateTime actualDate = dateConverter.convertDate(dateString);
        LocalDateTime expectedDate = LocalDateTime.now().plusDays(1).withNano(0);
        assertEquals(actualDate, expectedDate);
    }

    @Test
    public void shouldReturnYesterdayDateWithYesterdayString() {
        String dateString = "YESTERDAY";
        StringDateConverter dateConverter = new StringDateConverter();
        LocalDateTime actualDate = dateConverter.convertDate(dateString);
        LocalDateTime expectedDate = LocalDateTime.now().minusDays(1).withNano(0);
        assertEquals(actualDate, expectedDate);
    }

    @Test
    public void shouldReturnStringDateAsDateWithSlash() {
        String dateString = "2021/05/13";
        StringDateConverter dateConverter = new StringDateConverter();
        LocalDateTime actualDate = dateConverter.convertDate(dateString);
        LocalDateTime expectedDate = LocalDate.parse("2021-05-13").atTime(LocalTime.now()).withNano(0);
        assertEquals(actualDate, expectedDate);
    }

    @Test
    public void shouldReturnStringDateAsDate() {
        String dateString = "2021-05-13";
        StringDateConverter dateConverter = new StringDateConverter();
        LocalDateTime actualDate = dateConverter.convertDate(dateString);
        LocalDateTime expectedDate = LocalDate.parse(dateString).atTime(LocalTime.now()).withNano(0);
        assertEquals(actualDate, expectedDate);
    }

    @Test
    public void shouldReturnDateWithSpecificConditionsInString() {
        String dateString = "2 days ago";
        StringDateConverter dateConverter = new StringDateConverter();
        LocalDateTime actualDate = dateConverter.convertDate(dateString);
        LocalDateTime expectedDate = LocalDateTime.now().minusDays(2).withNano(0);
        assertEquals(actualDate, expectedDate);
    }

    @Test
    public void shouldReturnDateTwoMonthsAgo() {
        String dateString = "2 months ago";
        StringDateConverter dateConverter = new StringDateConverter();
        LocalDateTime actualDate = dateConverter.convertDate(dateString);
        LocalDateTime expectedDate = LocalDateTime.now().minusMonths(2).withNano(0);
        assertEquals(actualDate, expectedDate);
    }

    @Test
    public void shouldReturnDateYearAndMonthsAgo() {
        String dateString = "15 months from now";
        int addMonthExpected = numTest15;
        StringDateConverter dateConverter = new StringDateConverter();
        LocalDateTime actualDate = dateConverter.convertDate(dateString);
        LocalDateTime expectedDate = LocalDateTime.now().plusMonths(addMonthExpected).withNano(0);
        assertEquals(actualDate, expectedDate);
    }

    @Test
    public void shouldReturnDateYearAndOneMonthAgo() {
        String dateString = "1 month from now";
        StringDateConverter dateConverter = new StringDateConverter();
        LocalDateTime actualDate = dateConverter.convertDate(dateString);
        LocalDateTime expectedDate = LocalDateTime.now().plusMonths(1).withNano(0);
        assertEquals(actualDate, expectedDate);
    }

    @Test
    public void shouldReturnDateOneHourAgo() {
        String dateString = "1 hour ago";
        StringDateConverter dateConverter = new StringDateConverter();
        LocalDateTime actualDate = dateConverter.convertDate(dateString);
        LocalDateTime expectedDate = LocalDateTime.now().plusHours(-1).withNano(0);
        assertEquals(actualDate, expectedDate);
    }

    @Test
    public void shouldReturnDateTwentyMinutesFromNow() {
        String dateString = "20 minutes from now";
        int addMonthExpected = numTest20;
        StringDateConverter dateConverter = new StringDateConverter();
        LocalDateTime actualDate = dateConverter.convertDate(dateString);
        LocalDateTime expectedDate = LocalDateTime.now().plusMinutes(addMonthExpected).withNano(0);
        assertEquals(actualDate, expectedDate);
    }

    @Test
    public void shouldReturnDateTenSecondsFromNow() {
        String dateString = "10 seconds from now";
        int addMonthExpected = numTest10;
        StringDateConverter dateConverter = new StringDateConverter();
        LocalDateTime actualDate = dateConverter.convertDate(dateString);
        LocalDateTime expectedDate = LocalDateTime.now().plusSeconds(addMonthExpected).withNano(0);
        assertEquals(actualDate, expectedDate);
    }
}
