import java.util.stream.LongStream;

public class Problem10 {


    public static void main(String[] args) {
        System.out.println(solution(2_000_000L));
    }

    private static Long solution(Long number) {
        return LongStream.range(2, number + 1).filter(Problem3::isPrime).sum();
    }
}
