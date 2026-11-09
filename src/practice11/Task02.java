package practice11;

import java.util.Date;
import java.util.Scanner;

public final class Task02 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите дату и время: dd.MM.yyyy HH:mm (Москва)");
        Date entered = Dates.parse(in.nextLine());
        Date now = new Date();
        int result = entered.compareTo(now);
        System.out.println("Сейчас: " + Dates.formatter("dd.MM.yyyy HH:mm:ss z").format(now));
        System.out.println(result < 0 ? "Введённая дата раньше текущей" :
                result > 0 ? "Введённая дата позже текущей" : "Даты совпадают");
    }
}
