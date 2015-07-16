import java.util.*;

public class Problem31 {
    public static void main(String[] args) {
        TreeSet<Integer> weights = new TreeSet<>(Comparator.<Integer>reverseOrder());
        weights.addAll(Arrays.asList(200, 100, 50, 20, 10, 5, 2, 1));
        System.out.println(countStack(200, weights));
    }

    private static <T> SortedSet<T> tailSetExclusive(SortedSet<T> set, T entry) {
        //Annoying method there is not tailSet in Java with exclusive.
        Iterator<T> iterator = set.tailSet(entry).iterator();
        if(iterator.hasNext()) {
            iterator.next();
            if(iterator.hasNext()) {
                return set.tailSet(iterator.next());
            } else {
                return Collections.emptySortedSet();
            }
        } else {
            return Collections.emptySortedSet();
        }
    }

    private static long countStack(int targetWeight, SortedSet<Integer> availableWeights) {
        if(targetWeight == 0) {return 1;}
        if(availableWeights.isEmpty()) {return 0;}
        Integer head = availableWeights.first();
        long count = 0;
        for (int i = 0; i <= targetWeight/head; i++) {
            count += countStack(targetWeight - (i * head), tailSetExclusive(availableWeights, head));
        }
        return count;
    }

}
