package practice11;

import java.util.Scanner;

public final class Task03 {
    public static void main(String[] args) throws Exception {
        Student student = new Student(101, "Иван", "Петров", "Информатика", 1,
                "КВБО-12-25", 4.5, Dates.parse("15.05.2006 00:00"));
        System.out.println("Формат: SHORT, MEDIUM или FULL:");
        BirthdayFormat selected = BirthdayFormat.valueOf(new Scanner(System.in).nextLine()
                .trim().toUpperCase(java.util.Locale.ROOT));
        student.setBirthdayFormat(selected);
        System.out.println(student);
        System.out.println("Все доступные форматы:");
        for (BirthdayFormat format : BirthdayFormat.values()) {
            System.out.println(format + ": " + student.formatBirthday(format));
        }
    }
}
