package practice14;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Выбраны задания 2, 3 и 7. */
public final class RegexTasks {
    private static final Pattern EXACT = Pattern.compile("abcdefghijklmnopqrstuv18340");
    private static final Pattern PRICE = Pattern.compile(
            "(?<![\\p{L}\\p{N}_.,+\\-])(?:0|[1-9][0-9]*)(?:\\.[0-9]{1,2})?\\h+(?:USD|RUB|EU)(?![\\p{L}\\p{N}_])");
    private static final Pattern PASSWORD = Pattern.compile(
            "(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])[A-Za-z0-9_]{8,}");

    private RegexTasks() { }
    public static boolean isExact(String text) { return EXACT.matcher(text).matches(); }
    public static List<String> extractPrices(String text) {
        List<String> result = new ArrayList<>();
        Matcher matcher = PRICE.matcher(text);
        while (matcher.find()) result.add(matcher.group());
        return result;
    }
    public static boolean isStrongPassword(String text) { return PASSWORD.matcher(text).matches(); }
    public static void main(String[] args) {
        System.out.println("Задание 2. Точное совпадение:");
        for (String text : new String[] {"abcdefghijklmnopqrstuv18340", "abcdefghijklmnoasdfasdpqrstuv18340"}) {
            System.out.println(text + " -> " + isExact(text));
        }
        System.out.println("Задание 3. Цены:");
        String prices = "25.98 USD; 1200 RUB; 19.5 EU; 44 ERR; 0.004 EU; 10.00 USD";
        System.out.println(prices);
        System.out.println(extractPrices(prices));
        System.out.println("Задание 7. Надёжность пароля:");
        for (String password : new String[] {"F032_Password", "TrySpy1", "smart_pass", "A007", "TrySpy12"}) {
            System.out.println(password + " -> " + isStrongPassword(password));
        }
    }
}
