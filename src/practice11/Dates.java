package practice11;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class Dates {
    private Dates() { }
    public static TimeZone zone() { return TimeZone.getTimeZone("Europe/Moscow"); }
    public static SimpleDateFormat formatter(String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern, new Locale("ru", "RU"));
        format.setTimeZone(zone());
        format.setLenient(false);
        return format;
    }
    public static Date parse(String text) throws ParseException {
        if (!text.matches("[0-9]{2}\\.[0-9]{2}\\.[0-9]{4} [0-9]{2}:[0-9]{2}")) {
            throw new ParseException("Ожидается dd.MM.yyyy HH:mm", 0);
        }
        ParsePosition position = new ParsePosition(0);
        Date date = formatter("dd.MM.yyyy HH:mm").parse(text, position);
        if (date == null || position.getIndex() != text.length()) {
            throw new ParseException("Несуществующая дата или время", Math.max(0, position.getErrorIndex()));
        }
        return date;
    }
    public static Calendar createCalendar(int year, int month, int day, int hour, int minute) {
        if (year < 1 || month < 1 || month > 12) throw new IllegalArgumentException("Неверный год/месяц");
        Calendar calendar = Calendar.getInstance(zone());
        calendar.clear();
        calendar.setLenient(false);
        calendar.set(year, month - 1, day, hour, minute);
        calendar.getTime(); // Немедленная проверка даты без автоматического переноса.
        return calendar;
    }
}
