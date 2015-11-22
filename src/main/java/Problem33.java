import java.util.HashSet;
import java.util.Set;

public class Problem33 {
    public static void main(String[] args) {
        System.out.println(cancellingFractions().stream()
                .reduce(new Fraction(1, 1), (f1, f2) -> f1.product(f2).minimal()).minimal());
    }

    private static Set<Fraction> cancellingFractions() {
        Set<Fraction> fractions = new HashSet<>();
        for (int i = 10; i < 100; i++) {
            for (int j = i; j < 100; j++) {
                Fraction f = new Fraction(i, j);
                Fraction cancelFraction = f.cancelDigits();
                Fraction reduceFraction = f.minimal();
                if(!cancelFraction.equals(f) && reduceFraction.equals(cancelFraction.minimal())) {
                    fractions.add(f);
                }
            }
        }
        return fractions;
    }
}
