import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Annoying almost auto-generated class. We have one in Guava and Commons lang
 */
class Pair<X, Y> {
    X x; Y y;

    public Pair(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair<?, ?> pair = (Pair<?, ?>) o;

        if (x != null ? !x.equals(pair.x) : pair.x != null) return false;
        return !(y != null ? !y.equals(pair.y) : pair.y != null);

    }

    @Override
    public int hashCode() {
        int result = x != null ? x.hashCode() : 0;
        result = 31 * result + (y != null ? y.hashCode() : 0);
        return result;
    }

    public X getX() {
        return x;
    }

    public Y getY() {
        return y;
    }
}
public class Problem26 {

    public static void main(String[] args) {
        System.out.println(IntStream.range(1, 1000).boxed()
                .max(Comparator.comparingInt(x -> repeatDecimal(x).length())).get());
    }

    private static String repeatDecimal(int n) {
        List<Pair<Integer, Integer>> outputs = new ArrayList<>();
        int num = 10, index = -1;
        while(num != 0) {
            Pair<Integer, Integer> output = new Pair<>(num/n, num %n);
            if(outputs.contains(output)) {
                index = outputs.indexOf(output);
                break;
            }
            outputs.add(new Pair<>(num/n, num %n));
            num = output.y * 10;
        }
        return num == 0 ? "" : outputs.subList(index, outputs.size()).stream()
                .map(p -> p.getX().toString()).collect(Collectors.joining("", "", ""));
    }
}
