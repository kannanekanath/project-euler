import java.util.Comparator;
import java.util.stream.LongStream;

public class Problem14 {
    public static void main(String[] args) {
        System.out.println(solution(1_000_000L));
    }

    private static long solution(long max) {
        return LongStream.range(1, max).boxed().max(Comparator.comparing(Problem14::chainLength)).get();
    }

    private static long collatzTerm(long n) {
        return n % 2 == 0 ? n/2 : (3*n) +  1;
    }

    private static Long chainLength(Long term) {
        long length = 1, t = term;
        while(t != 1) {
            t = collatzTerm(t);
            length++;
        }
        return length;
    }
}
