import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class Problem29 {


    public static void main(String[] args) {
        Set<BigInteger> numbers = new HashSet<>();
        int max = 100;
        for (int a = 2; a <= max ; a++) {
            for (int b = 2; b <= max; b++) {
                numbers.add(new BigInteger("" + a).pow(b));
            }
        }
        System.out.println(numbers.size());
    }
}
