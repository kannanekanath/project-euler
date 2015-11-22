package euler;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem28 {

    public static void main(String[] args) {
        int n = 1001;
        Long summation = 1 + spiralStream().limit((n - 1) / 2)
                .flatMap(Collection::stream).collect(Collectors.summingLong(Integer::longValue));
        System.out.println(summation);
    }

    private static Stream<List<Integer>> spiralStream() {
        UnaryOperator<List<Integer>> operator = integers -> {
            Integer last = integers.get(integers.size() - 1);
            int diff = (int) (Math.sqrt(last)) + 1;
            return Stream.iterate(diff + last, i -> i + diff)
                    .limit(integers.size()).collect(Collectors.toList());
        };
        return Stream.iterate(Arrays.asList(3, 5, 7, 9), operator);
    }
}
