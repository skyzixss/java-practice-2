package practice08;

import java.io.IOException;

public final class Task12 {
    public static void printOdd() throws IOException {
        long number = NaturalInput.read();
        if (number == 0) return;
        if (number % 2 != 0) System.out.println(number);
        printOdd();
    }

    public static void main(String[] args) throws IOException {
        printOdd();
    }
}
