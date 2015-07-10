import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Problem25 {
    public static void main(String[] args) {
        Stream<BigInteger> fibanocciStream = fibanocciStream();
        int count = 1;
        Iterator<BigInteger> iterator = fibanocciStream.iterator();
        while(iterator.next().toString().length() < 1000) {
            count++;
        }
        System.out.println(count);
    }

    private static Stream<BigInteger> fibanocciStream() {
        return Stream.iterate(
                new BigInteger[]{BigInteger.ONE, BigInteger.ONE},
                f -> new BigInteger[]{f[1], f[0].add(f[1])}
        ).map(f -> f[0]);
    }
 }
