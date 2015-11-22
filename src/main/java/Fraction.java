public class Fraction {
    private final int n;
    private final int d;
    public Fraction(int n, int d) {
        if (d <= 0) {
            throw new IllegalArgumentException("Denominator has to be greater than 0");
        }
        this.n = n;
        this.d = d;
    }
    public Fraction minimal() {
        int gcd = gcd(n, d);
        return n == 0 || gcd == 1 ? this : new Fraction(n/gcd, d/gcd);
    }

    public Fraction cancelDigits() {
        if (n == d) {
            return new Fraction(0, 1);
        }
        String num = "" + n, den = "" + d;
        for (int i = 1; i <= 9; i++) {
            String digit = "" + i;
            while(num.contains(digit) && den.contains(digit)) {
                num = num.replaceFirst(digit, "");
                den = den.replaceFirst(digit, "");
            }
        }
        int denInt = Math.max(1, den.equals("") ? 1 : new Integer(den));
        int numInt = den.equals("") ? 0 : new Integer(num);
        return new Fraction(numInt, denInt);
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return Math.abs(a);
        }
        return gcd(b, a % b);
    }

    public Fraction add(Fraction f) {
        if (n == 0) {
            return f;
        }
        int lcm = d * f.d;
        int num = (n * (lcm / d) + (f.n * (lcm / f.d)));
        return new Fraction(num, lcm);
    }

    public Fraction product(Fraction f) {
        if (n == 0 || f.n == 0) {
            return this;
        }
        return new Fraction(n * f.n, d * f.d);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fraction fraction = (Fraction) o;

        if (n != fraction.n) return false;
        return d == fraction.d;

    }

    @Override
    public int hashCode() {
        int result = n;
        result = 31 * result + d;
        return result;
    }

    @Override
    public String toString() {
        return "Fraction{" + n + "/" + d + "}";
    }
}
