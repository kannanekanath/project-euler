package euler;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class Problem20 {
    public static void main(String[] args) {
        System.out.println(bigFactorial(100).toString().chars().map(x -> x - '0').sum());
    }

    private static BigInteger bigFactorial(int n) {
        return IntStream.rangeClosed(1, n).boxed()
                .map(x -> new BigInteger(x.toString())).reduce(BigInteger.ONE, BigInteger::multiply);
    }
}
