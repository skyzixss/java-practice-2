package practice08;

import java.math.BigInteger;
import java.util.Scanner;

/** Число последовательностей из a нулей и b единиц без соседних нулей. */
public final class Task09 {
    public static BigInteger count(int a, int b) {
        if (a < 0 || b < 0) throw new IllegalArgumentException("a и b должны быть >= 0");
        if (a == 0) return BigInteger.ONE;
        if ((long) a > (long) b + 1) return BigInteger.ZERO;
        return count(a, b, new BigInteger[a + 1][b + 1]);
    }

    private static BigInteger count(int a, int b, BigInteger[][] memo) {
        if (a == 0) return BigInteger.ONE;
        if ((long) a > (long) b + 1) return BigInteger.ZERO;
        if (b == 0) return BigInteger.ONE; // Остался единственный ноль.
        if (memo[a][b] == null) {
            // Последовательность начинается с 1 или с 01.
            memo[a][b] = count(a, b - 1, memo).add(count(a - 1, b - 1, memo));
        }
        return memo[a][b];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(count(in.nextInt(), in.nextInt()));
    }
}
