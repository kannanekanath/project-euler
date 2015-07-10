import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Problem21 {
    public static void main(String[] args) {
        System.out.println(amicableNumbersSum(10000));
    }

    private static long amicableNumbersSum(long max) {
        return LongStream.range(1, max).filter(Problem21::isAmicableNumber).sum();
    }

    private static boolean isAmicableNumber(long n) {
        long sum = divisorSum(n);
        return n != sum && n == divisorSum(sum);
    }

    private static long divisorSum(long n) {
        return LongStream.range(1, n).filter( i -> n % i == 0).sum();
    }
}
