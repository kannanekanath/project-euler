import java.util.function.Function;
import java.util.function.LongPredicate;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Problem30 {
    public static void main(String[] args) {
        Function<Long, Long> sumOfDigitPowers = n -> n.toString().chars()
                .boxed().mapToLong(x -> (long)Math.pow((x - '0'), 5)).sum();
        LongPredicate isSumOfPowers = x -> x == sumOfDigitPowers.apply(x);
        //Find the first number where i * (9 ^ 5) has less digits than i
        int maxDigits = IntStream.iterate(2, i -> i + 1)
                .filter(i -> i > String.valueOf(i * (long)Math.pow(9, 5)).length()).findFirst().getAsInt();

        long sum = LongStream.rangeClosed(2, (long) Math.pow(10, maxDigits - 1))
                .filter(isSumOfPowers).sum();
        System.out.println(sum);
    }
}
