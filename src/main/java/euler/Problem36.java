package euler;

import java.util.stream.IntStream;

public class Problem36 {
    public static void main(String[] args) {
        System.out.println(IntStream
                .range(1, 1_000_000)
                .filter(n -> isPalindrome("" + n))
                .filter(n -> isPalindrome(Util.toBinary(n)))
                .sum());
    }

    private static boolean isPalindrome(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}

