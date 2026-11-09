package practice13;

import java.util.Locale;

public final class StringTask {
    private StringTask() { }
    public static void analyze(String text) {
        System.out.println("Исходная строка: " + text);
        System.out.println("Последний символ: " + (text.isEmpty() ? "(строка пуста)" : text.charAt(text.length() - 1)));
        System.out.println("Заканчивается на !!!: " + text.endsWith("!!!"));
        System.out.println("Начинается с I like: " + text.startsWith("I like"));
        System.out.println("Содержит Java: " + text.contains("Java"));
        int index = text.indexOf("Java");
        System.out.println("Индекс Java: " + index);
        System.out.println("Замена a на o: " + text.replace('a', 'o'));
        System.out.println("Верхний регистр: " + text.toUpperCase(Locale.ROOT));
        System.out.println("Нижний регистр: " + text.toLowerCase(Locale.ROOT));
        System.out.println("Подстрока: " + (index < 0 ? "Java не найдена" : text.substring(index, index + 4)));
    }
    public static void main(String[] args) {
        analyze(args.length == 0 ? "I like Java!!!" : args[0]);
    }
}
