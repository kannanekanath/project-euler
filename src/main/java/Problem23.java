import java.util.List;
import java.util.function.Function;
import java.util.function.LongPredicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Problem23 {

    public static void main(String[] args) {
        //Function to check if N is abundant
        LongPredicate isAbundant = n -> LongStream.range(1, n).filter(i -> n % i == 0).sum() > n;
        //Function to generate abundant numbers up to a certain N
        Function<Long, List<Long>> abundantNumbersList = n -> LongStream.rangeClosed(1, n)
                .filter(isAbundant).boxed().collect(Collectors.toList());
        List<Long> abundantNumbers = abundantNumbersList.apply(28123L);
        System.out.println(LongStream.rangeClosed(1, 28123).filter(n -> isNotSum(abundantNumbers, n)).sum());
    }

    /**
     * Function to check given a list of sorted numbers and N if N can be expressed as sum of two numbers
     */
    private static boolean isNotSum(List<Long> numbers, Long target) {
        int start = 0, end = numbers.size() - 1;
        while(start <= end) {
            long sum = numbers.get(start) + numbers.get(end);
            if(sum == target) {
                return false;
            } else if(sum > target) {
                end--;
            } else {
                start++;
            }
        }
        return true;
    }

}
