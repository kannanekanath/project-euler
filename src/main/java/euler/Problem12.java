package euler;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Problem12 {
    public static void main(String[] args) {
        System.out.println(solution(500));
    }

    private static long solution(int divisors) {
        return LongStream.range(5, 1000000)
                .mapToObj(l -> (l * (l + 1))/2)
                .filter(l -> numberOfDivisors(l) > divisors).findFirst().get();
    }

    private static long numberOfDivisors(long n) {
        if (n < 0) {throw new IllegalArgumentException();}
        if (n <= 2) {return n;}
        long sqrt = (long) Math.sqrt(n);
        boolean perfectSquare = sqrt * sqrt == n;
        long factors = LongStream.range(2, sqrt + 1).filter(i -> n % i == 0).count();
        return perfectSquare ? (factors * 2) + 1 : (factors * 2) + 2;
    }
}
