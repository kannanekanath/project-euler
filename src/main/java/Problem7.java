import java.util.stream.LongStream;

public class Problem7 {

    public static void main(String[] args) {
        System.out.println(answerPredicate(10001));
    }

    private static long answerPredicate(int i) {
        return LongStream.iterate(2, x -> x+1).filter(Problem3::isPrime).skip(i-1).findFirst().getAsLong();
    }

}
