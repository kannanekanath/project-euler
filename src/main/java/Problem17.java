import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Problem17 {
    private static List<String> UNITS = Arrays.asList("ONE", "TWO", "THREE", "FOUR", "FIVE",
            "SIX", "SEVEN", "EIGHT", "NINE");
    private static List<String> TENS = Arrays.asList("TEN", "TWENTY", "THIRTY", "FORTY", "FIFTY",
            "SIXTY", "SEVENTY", "EIGHTY", "NINETY");
    private static List<String> TEN_TO_NINETEEN = Arrays.asList("TEN", "ELEVEN", "TWELVE", "THIRTEEN", "FOURTEEN",
            "FIFTEEN", "SIXTEEN", "SEVENTEEN", "EIGHTEEN", "NINETEEN");

    public static void main(String[] args) {
        System.out.println(IntStream.rangeClosed(1, 1000)
                .map(n -> Problem17.convertToWords(n).replaceAll(" ", "").length()).sum());
    }

    private static String convertToWords(int n) {
        if(n > 1000 || n < 1) {throw new IllegalArgumentException("Give me a number between 1 and 1000");}
        if(n == 1000) {return "ONE THOUSAND";}
        if(n >= 10 && n <= 19) {return TEN_TO_NINETEEN.get(n - 10);}
        int units = n % 10, tens = (n % 100) / 10, hundreds = (n % 1000) / 100;
        StringBuilder b = new StringBuilder();
        if(hundreds > 0) {
            b.append(UNITS.get(hundreds-1)).append(" HUNDRED ");
            //If we have some tens/units then we need to add an "AND"
            if(tens > 0 || units > 0) {
                b.append("AND ");
            }
        }
        if(tens > 0) {
            //For 311 we need "three hundred and eleven" but 321 is like normal
            if (tens == 1) {
                b.append(TEN_TO_NINETEEN.get((tens * 10) + units - 10));
            } else {
                b.append(TENS.get(tens - 1));
            }
            if(units > 0) {
                b.append(" ");
            }
        }
        if(units > 0 && tens != 1) {
            b.append(UNITS.get(units-1));
        }
        return b.toString();
    }
}
