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
        return LongStream.range(2, n).parallel().filter(i -> n % i == 0).count() + 2;
    }
}
