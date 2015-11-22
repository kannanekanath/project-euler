import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Problem32 {
    public static void main(String[] args) {
        Stream<String> perms = permutation("123456789");
        Set<String> output = new TreeSet<>();
        perms.forEach(p -> output.addAll(pandigital(p)));
        System.out.println(output.stream().mapToLong(Long::valueOf).sum());
    }

    private static Set<String> pandigital(String s) {
        Set<String> output = new TreeSet<>();
        for (int i = 1; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                Integer n1 = Integer.parseInt(s.substring(0, i));
                Integer n2 = Integer.parseInt(s.substring(i, j));
                Integer n3 = Integer.parseInt(s.substring(j));
                if (n1 * n2 == n3) {
                    output.add(n3.toString());
                }
            }
        }
        return output;
    }

    private static Stream<String> permutation(String s) {
        Integer factorial = Integer.valueOf("" + factorial(s.length()));
        return IntStream.range(0, factorial)
                .boxed()
                .map(index -> permutation(s, index));
    }

    private static String permutation(String s, int index) {
        String output = "";
        int length = s.length();
        for (int i = 0; i < length; i++) {
            long factorial = factorial(length - i - 1);
            int packet = (int) (index / factorial);
            char item = s.charAt(packet);
            output += item;
            s = s.replaceAll("" + item, "");
            index = Math.max(0, (int) (index - (packet * factorial)));
        }
        return output;
    }

    private static long factorial(int i) {
        return IntStream.rangeClosed(1, i).reduce(1, (p, a) -> p * a);
    }
}
