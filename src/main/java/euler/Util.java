package euler;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.OptionalLong;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Util {

    public static Stream<String> permutations(String s) {
        Integer factorial = Integer.valueOf("" + factorial(s.length()));
        return IntStream.range(0, factorial)
                .boxed()
                .map(index -> permutations(s, index));
    }

    public static Stream<String> rotations(String s) {
        List<String> rotations = new ArrayList<>();
        String rotation = s;
        rotations.add(s);
        while (!(rotation = rotate(rotation)).equals(s)) {
            rotations.add(rotation);
        }
        return rotations.stream();
    }

    public static String toBinary(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Please pass a non negative number");
        }
        if (n == 0) {
            return "0";
        }
        StringBuilder output = new StringBuilder();
        while (n > 0) {
            output.append(n % 2);
            n = n/2;
        }
        return output.reverse().toString();
    }

    private static String rotate(String s) {
        return s.substring(s.length() - 1) + s.substring(0, s.length() - 1);
    }

    public static boolean isPrime(Long input) {
        Objects.requireNonNull(input);
        if(input <= 0) {throw new IllegalArgumentException("Please pass positive non zero number");}
        if(input <= 3) {return true;}
        if(input == 4) {return false;} //For 4 the sqrt is 2 and needs to be handled separately
        long squareRoot = (long) Math.ceil(Math.sqrt(input));
        OptionalLong biggestFactor = LongStream.range(2, squareRoot + 1).filter(i -> input % i == 0).findFirst();
        return !biggestFactor.isPresent();
    }

    private static String permutations(String s, int index) {
        String output = "";
        int length = s.length();
        for (int i = 0; i < length; i++) {
            long factorial = factorial(length - i - 1);
            int packet = (int) (index / factorial);
            char item = s.charAt(packet);
            output += item;
            s = s.replaceFirst("" + item, "");
            index = Math.max(0, (int) (index - (packet * factorial)));
        }
        return output;
    }

    private static long factorial(int i) {
        return IntStream.rangeClosed(1, i).reduce(1, (p, a) -> p * a);
    }
}
