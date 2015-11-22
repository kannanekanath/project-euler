package euler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Problem24 {
    public static void main(String[] args) {
        List<Integer> inputs = IntStream.rangeClosed(0, 9).boxed().collect(Collectors.toList());
        List<Integer> permutation = permutationNumber(1_000_000L - 1, inputs);
        System.out.println(permutation.stream().map(Object::toString).collect(Collectors.joining("", "", "")));
    }

    private static <T> Stream<List<T>> permutations(List<T> items) {
        //number of permutations = n!
        return LongStream.range(0, factorial.apply((long) items.size()))
                .mapToObj(i -> permutationNumber(i, items));
    }

    private static Function<Long, Long> factorial = n -> LongStream.rangeClosed(1, n).reduce(1, (i, j) -> i * j);

    private static <T> List<T> permutationNumber(long permutationIndex, List<T> items) {
        List<T> permutationList = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            long subFactorial = factorial.apply((long) (items.size()- i - 1));
            int q = (int) (permutationIndex / subFactorial);
            permutationIndex = (int) (permutationIndex % subFactorial);
            T item = items.stream().filter(n -> !permutationList.contains(n)).skip(q).findFirst().get();
            permutationList.add(item);
        }
        return permutationList;
    }
 }
