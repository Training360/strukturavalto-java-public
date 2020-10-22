package datenewtypes;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class JavaTimeTest {

   @Test
   public void testLocalDateTime() {
       LocalDate localDate = LocalDate.now();
       System.out.println(localDate);

       LocalDateTime localDateTime = LocalDateTime.now();
       System.out.println(localDateTime);

       LocalTime localTime = LocalTime.now();
       System.out.println(localTime);

       LocalDate localDate1 = LocalDate.of(2018, 1, 12);
       assertThat(localDate1.toString(), equalTo("2018-01-12"));

       LocalDateTime localDateTime1 = LocalDateTime.of(2018, 1, 12, 16, 0);
       assertThat(localDateTime1.toString(), equalTo("2018-01-12T16:00"));

       LocalTime localTime1 = LocalTime.of(16, 0);
       assertThat(localTime1.toString(), equalTo("16:00"));

       assertThat(localDateTime1.plusDays(1).plusHours(1).toString(),
               equalTo("2018-01-13T17:00"));

       assertThat(localDateTime.isAfter(localDateTime1), equalTo(true));
   }

   @Test
    public void testConvert() {
       LocalDateTime localDateTime = LocalDateTime.of(2018, 1, 12, 16, 0);
       LocalDate localDate = localDateTime.toLocalDate();
       LocalTime localTime = localDateTime.toLocalTime();
       assertThat(localDate.toString(), equalTo("2018-01-12"));
       assertThat(localTime.toString(), equalTo("16:00"));

       LocalDateTime localDateTime1 = LocalDateTime.of(localDate, localTime);
       assertThat(localDateTime1.toString(), equalTo("2018-01-12T16:00"));
   }

   @Test
    public void testJavaUtilDate() {
       Date date = new Date();
       LocalDateTime localDateTime =
               LocalDateTime.ofInstant(date.toInstant(),
                       ZoneId.systemDefault());
       System.out.println(localDateTime);

       Date date1 = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
       System.out.println(date1);
   }

   @Test
    public void testChronoUnit() {
       LocalDateTime localDateTime = LocalDateTime.of(2018, 1, 12, 16, 0);
       LocalDateTime localDateTime1 = LocalDateTime.of(2018, 1, 16, 16, 0);

       assertThat(ChronoUnit.DAYS.between(localDateTime, localDateTime1), equalTo(4L));

   }

   @Test
    public void testField() {
       LocalDateTime localDateTime = LocalDateTime.of(2018, 1, 12, 16, 0);
       assertThat(localDateTime.getDayOfMonth(), equalTo(12));
   }

   @Test
    public void testFormat() {
       LocalDateTime localDateTime = LocalDateTime.of(2018, 1, 12, 16, 0);
       DateTimeFormatter formatter =
               DateTimeFormatter.ofPattern("yyyy. MMMM dd. hh:mm").withLocale(Locale.ENGLISH);
       String s = localDateTime.format(formatter);

       assertThat(s, equalTo("2018. January 12. 04:00"));
   }

   @Test
    public void testParse() {
       DateTimeFormatter formatter =
               DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
       String s = "2018-01-12 16:00";
       LocalDateTime localDateTime =
               LocalDateTime.parse(s, formatter);
       assertThat(localDateTime.getDayOfMonth(), equalTo(12));
   }



}
