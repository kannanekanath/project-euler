package euler;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem35 {

    public static void main(String[] args){
        System.out.println(IntStream.rangeClosed(2, 1000000).boxed()
                .filter(Problem35::isCircularPrime).count());
    }

    public static boolean isCircularPrime(int n) {
        return Util.rotations("" + n)
                .mapToLong(Long::valueOf).allMatch(Util::isPrime);
    }
}
