package practice08;

import java.io.EOFException;
import java.io.IOException;

/** Чтение без Scanner и без глобальных переменных: состояние хранится в System.in. */
public final class NaturalInput {
    private NaturalInput() { }

    public static long read() throws IOException {
        int c;
        do {
            c = System.in.read();
            if (c == -1) throw new EOFException("Нет числа или завершающего нуля");
        } while (Character.isWhitespace(c));
        long value = 0;
        boolean hasDigits = false;
        while (c != -1 && !Character.isWhitespace(c)) {
            if (c < '0' || c > '9') throw new IllegalArgumentException("Нужно неотрицательное целое");
            hasDigits = true;
            value = Math.addExact(Math.multiplyExact(value, 10), c - '0');
            c = System.in.read();
        }
        if (!hasDigits) throw new IllegalArgumentException("Нет цифр");
        return value;
    }
}
