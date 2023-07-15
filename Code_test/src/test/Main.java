package test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class Main {

    public static void main(String[] args) {
        LocalDateTime timePoint = LocalDateTime.now(); // 현재의 날짜와 시간

// 2012년 12월 12일의 시간에 대한 정보를 가지는 LocalDate객체를 만드는 방법
        LocalDate ld1 = LocalDate.of(2012, Month.DECEMBER, 12); // 2012-12-12 from values
// 17시 18분에 대한 LocalTime객체를 구한다.
        LocalTime lt1 = LocalTime.of(17, 18); // 17:18 (17시 18분)the train I took home today
// 10시 15분 30초라는 문자열에 대한 LocalTime객체를 구한다.
        LocalTime lt2 = LocalTime.parse("10:15:30"); // From a String

        LocalDate theDate = timePoint.toLocalDate();
        System.out.println(ld1);
        System.out.println(lt1);
        System.out.println(lt2);
        System.out.println(theDate);


        Month month = timePoint.getMonth();
        System.out.println(month);

        int day = timePoint.getDayOfMonth();
        int hour = timePoint.getHour();
        int minute = timePoint.getMinute();
        int second = timePoint.getSecond();
// 달을 숫자로 출력한다 1월도 1부터 시작하는 것을 알 수 있습니다.
        System.out.println(month.getValue() + "/" + day + "  " + hour + ":" + minute + ":" + second);
    }
}
