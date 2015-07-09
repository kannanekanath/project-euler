import java.util.stream.LongStream;

public class Problem15 {

    public static void main(String[] args) {
        System.out.println(permutations(20));
    }

    private static Long permutations(int n) {
        /**
         * The answer is basically 2n!/(n! * n!)
         * But with n > 20 you get overflow problems. Basically we cancel out
         * n! and remaining even terms are scratched out
         */
        long reduce = LongStream.iterate((2 * n) - 1, i -> i - 2).limit(n / 2).reduce(1, (i, j) -> i * j);
        return ((long)Math.pow(2, n/2) * reduce)/factorial(n/2);
    }

    private static Long factorial(int n) {
        return LongStream.rangeClosed(2, n).reduce(1, (i, j) -> i * j);
    }
}
