package practice08;

import java.io.IOException;

public final class Task10 {
    public static long reverse(long n) {
        if (n <= 0) throw new IllegalArgumentException("Нужно натуральное число без нулей");
        return reverse(n, 0);
    }

    private static long reverse(long n, long result) {
        if (n == 0) return result;
        long digit = n % 10;
        if (digit == 0) throw new IllegalArgumentException("В числе есть ноль");
        return reverse(n / 10, Math.addExact(Math.multiplyExact(result, 10), digit));
    }

    public static void main(String[] args) throws IOException {
        System.out.println(reverse(NaturalInput.read()));
    }
}
