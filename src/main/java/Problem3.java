import java.util.Objects;
import java.util.OptionalLong;
import java.util.function.LongPredicate;
import java.util.stream.LongStream;

public class Problem3 {

    protected static boolean isPrime(Long input) {
        Objects.requireNonNull(input);
        if(input <= 0) {throw new IllegalArgumentException("Please pass positive non zero number");}
        if(input <= 3) {return true;}
        if(input == 4) {return false;} //For 4 the sqrt is 2 and needs to be handled separately
        long squareRoot = (long) Math.ceil(Math.sqrt(input));
        OptionalLong biggestFactor = LongStream.range(2, squareRoot+1).filter(i -> input % i == 0).findFirst();
        return !biggestFactor.isPresent();
    }

    private static LongStream reverseRange(long endExclusive, long startInclusive) {
        return LongStream.iterate(endExclusive - 1, i -> i - 1).limit(endExclusive - startInclusive);
    }

    public static void main(String[] args) {
        Long input = 600851475143L;
        Long squareRoot = (long) Math.ceil(Math.sqrt(input));
        LongPredicate divisible = i -> input % i == 0;
        OptionalLong first = reverseRange(squareRoot, 2).filter(divisible.and(Problem3::isPrime)).findFirst();
        System.out.println(first.getAsLong());
    }
}

