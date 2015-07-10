import java.util.function.BiFunction;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Problem27 {

    public static void main(String[] args) {
        IntPredicate isPrime = i -> i > 1 && Problem3.isPrime((long) i);
        BiFunction<Integer, Integer, Integer> primeCount = (a, b) -> IntStream.iterate(0, n -> n + 1)
                .filter(n -> !isPrime.test(((n * n) + (n * a) + b))).findFirst().getAsInt();

        int maxa = -1, maxb = -1, maxvalue = -1;
        for (int i = -999; i < 1000; i++) {
            for (int j = -999; j < 1000; j++) {
                Integer currentValue = primeCount.apply(i, j);
                if(currentValue > maxvalue) {
                    maxa = i;
                    maxb = j;
                    maxvalue = currentValue;
                }
            }
        }
        System.out.println(maxa * maxb);
    }

}
