import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Problem9 {


    public static void main(String[] args) {
        System.out.println(answerPredicate(1000));
    }

    private static Integer answerPredicate(int number) {
        for (int i = 1; i < number - 1; i++) {
            for (int j = 1; j < number - 1; j++) {
                int k = number - i - j;
                if(isRightAngled(i, j, k)) {
                    return i * j * k;
                }
            }
        }
        throw new IllegalArgumentException();
    }

    private static boolean isRightAngled(int a, int b, int c) {
        List<Integer> triangleSizes = Arrays.asList(a, b, c);
        int max = triangleSizes.stream().max(Comparator.<Integer>naturalOrder()).get();
        return max * max == triangleSizes.stream().filter(x -> x != max).mapToInt(x -> x * x).sum();
    }
}
