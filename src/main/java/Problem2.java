import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Problem2 {

    static class FibanocciIterator implements Iterator<Long> {
        private final long max;
        private long n1 = 0, n2 = 1;
        FibanocciIterator(long max) {
            this.max = max;
        }
        @Override
        public boolean hasNext() {
            return n1 + n2 <= max;
        }
        @Override
        public Long next() {
            long output = n1 + n2;
            n1 = n2;
            n2 = output;
            return output;
        }
    }

    public static void main(String[] args) {
        Stream<Long> fibanocci = StreamSupport.stream(
                ((Iterable<Long>) () -> new FibanocciIterator(4_000_000)).spliterator(), false);
        System.out.println(fibanocci.filter(term -> term % 2 == 0).collect(Collectors.summingLong(x -> x)));
    }
}
