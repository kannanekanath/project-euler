package euler;

import java.util.function.Predicate;

public class Problem4 {
    public static int palindrome() {
        Predicate<Integer> palindrome = x -> x.toString().equals(new StringBuffer().append(x).reverse().toString());
        int maxProduct = -1;
        for (int i = 999; i >= 100; i--) {
            for (int j = 999; j >= 100; j--) {
                int product = i * j;
                if(product > maxProduct && palindrome.test(product)) {
                    maxProduct = product;
                }
            }
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        System.out.println(palindrome());
    }
}
