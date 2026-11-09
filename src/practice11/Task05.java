package practice11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/** Учебное измерение, не замена JMH. Каждая операция получает новую одинаковую коллекцию. */
public final class Task05 {
    private static volatile long sink;

    private static List<Integer> make(boolean linked, int size) {
        List<Integer> result = linked ? new LinkedList<>() : new ArrayList<>();
        for (int i = 0; i < size; i++) result.add(i);
        return result;
    }

    private static long measure(boolean linked, int operation, int size, int repeats) {
        List<Integer> list = make(linked, size); // Заполнение не входит в измерение.
        long checksum = 0;
        long start = System.nanoTime();
        for (int i = 0; i < repeats; i++) {
            switch (operation) {
                case 0: list.add(i); break;
                case 1: list.add(list.size() / 2, i); break;
                case 2: checksum += list.remove(list.size() / 2); break;
                case 3: checksum += list.contains(size - 1) ? 1 : 0; break;
                default: throw new IllegalArgumentException("Неизвестная операция");
            }
        }
        long elapsed = System.nanoTime() - start;
        sink = checksum + list.size(); // Результат вычислений наблюдаем снаружи цикла.
        return elapsed;
    }

    public static void main(String[] args) {
        int size = 20_000;
        int repeats = 1_000;
        String[] names = {"Добавление в конец", "Вставка в середину по индексу",
                "Удаление из середины по индексу", "Поиск contains (последний элемент)"};
        System.out.println("Размер: " + size + "; операций в серии: " + repeats);
        System.out.println("Прогрев: 3 серии; результат: медиана 7 серий, мс");
        System.out.printf("%-43s %12s %12s%n", "Операция", "ArrayList", "LinkedList");
        for (int operation = 0; operation < names.length; operation++) {
            for (int warmup = 0; warmup < 3; warmup++) {
                measure(false, operation, size, repeats);
                measure(true, operation, size, repeats);
            }
            long[] array = new long[7];
            long[] linked = new long[7];
            for (int trial = 0; trial < 7; trial++) {
                // Чередуем порядок, чтобы одна коллекция не измерялась всегда первой.
                if (trial % 2 == 0) {
                    array[trial] = measure(false, operation, size, repeats);
                    linked[trial] = measure(true, operation, size, repeats);
                } else {
                    linked[trial] = measure(true, operation, size, repeats);
                    array[trial] = measure(false, operation, size, repeats);
                }
            }
            Arrays.sort(array);
            Arrays.sort(linked);
            System.out.printf(Locale.ROOT, "%-43s %12.3f %12.3f%n", names[operation],
                    array[3] / 1_000_000.0, linked[3] / 1_000_000.0);
        }
        System.out.println("Время зависит от JVM, прогрева и компьютера. Сравниваются именно указанные операции.");
    }
}
