package euler;

import java.util.stream.IntStream;

public class Problem1 {

    public static void main(String[] args) {
        System.out.println(IntStream.range(1, 1000).parallel().filter(i -> i % 3 == 0 || i % 5 == 0).sum());
    }
}
