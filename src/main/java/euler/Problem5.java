package euler;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Problem5 {

    private static boolean checkRemainders(long counter, IntStream intStream) {
        return !intStream.filter(i -> counter % i != 0).findFirst().isPresent();
    }

    private static long evenlyDivisible() {
        return LongStream.iterate(20, i -> i + 1).filter(c -> checkRemainders(c, IntStream.range(1, 21))).findFirst().getAsLong();
    }

    public static void main(String[] args) {
        System.out.println(evenlyDivisible());
    }
}
