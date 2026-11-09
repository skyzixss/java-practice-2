package practice08;

import java.io.IOException;

public final class Task13 {
    public static void printOddPositions() throws IOException {
        long first = NaturalInput.read();
        if (first == 0) return;
        System.out.println(first);
        if (NaturalInput.read() == 0) return; // Пропускаем элемент с чётным номером.
        printOddPositions();
    }

    public static void main(String[] args) throws IOException {
        printOddPositions();
    }
}
