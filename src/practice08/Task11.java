package practice08;

import java.io.IOException;

public final class Task11 {
    // У рекурсивного метода нет параметров и глобальных переменных.
    public static long countOnes() throws IOException {
        long current = NaturalInput.read();
        if (current == 0) {
            long next = NaturalInput.read();
            if (next == 0) return 0;
            return (next == 1 ? 1 : 0) + countOnes();
        }
        return (current == 1 ? 1 : 0) + countOnes();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(countOnes());
    }
}
