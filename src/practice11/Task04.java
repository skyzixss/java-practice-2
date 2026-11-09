package practice11;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public final class Task04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите год месяц число, затем часы минуты:");
        Calendar calendar = Dates.createCalendar(in.nextInt(), in.nextInt(), in.nextInt(),
                in.nextInt(), in.nextInt());
        Date date = calendar.getTime();
        System.out.println("Date: " + Dates.formatter("dd.MM.yyyy HH:mm:ss z").format(date));
        System.out.printf("Calendar: %04d-%02d-%02d %02d:%02d%n", calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
    }
}
