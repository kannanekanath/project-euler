import java.math.BigInteger;

public class Problem16 {
    public static void main(String[] args) {
        String output = BigInteger.valueOf(2).pow(1000).toString();
        System.out.println(output.chars().map(x -> x - '0').sum());
    }
}
