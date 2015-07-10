import java.time.DayOfWeek;
import java.time.LocalDate;

public class Problem19 {
    public static void main(String[] args) {
        System.out.println(countDays());
    }

    private static long countDays() {
        /**
         * Using the Java8 Date class is somewhat cheating however I am going to
         * use it because if this problem presented to me in real life this is how
         * I would solve it.
         *
         * It is not that difficult to write a simple Date class which wraps the three
         * integers and a Day of week enum with a nextDay() method
         */
        LocalDate start = LocalDate.of(1901, 1, 1);
        LocalDate end = LocalDate.of(2000, 12, 31);
        long count = 0;
        while(!start.equals(end)) {
            if(start.getDayOfWeek().equals(DayOfWeek.SUNDAY) && start.getDayOfMonth() == 1) {
                count++;
            }
            start = start.plusDays(1);
        }
        return count;
    }
}
