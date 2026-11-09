package practice11;

import java.util.Date;
import java.util.Scanner;

public final class Task01 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("Фамилия разработчика:");
        String developer = in.nextLine();
        System.out.println("Дата и время получения задания (dd.MM.yyyy HH:mm, Москва):");
        Date received = Dates.parse(in.nextLine());
        Date submitted = new Date();
        System.out.println("Разработчик: " + developer);
        System.out.println("Получение: " + Dates.formatter("dd.MM.yyyy HH:mm:ss z").format(received));
        System.out.println("Сдача (момент запуска программы): "
                + Dates.formatter("dd.MM.yyyy HH:mm:ss z").format(submitted));
    }
}
