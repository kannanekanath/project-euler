public final class P031 {

    public static void main(String[] args) {
        System.out.println(new P031().run());
    }


    public String run() {
        // Knapsack problem. ways[i][j] is the number of ways to use
        // any of the first i coin values to form an unordered sum of j.
        int target = 10;
        int[] coinSizes = { 1, 2, 5, 10};
        int[] ways = new int[target+1];
        ways[0] = 1;

        for (int i = 0; i < coinSizes.length; i++) {
            for (int j = coinSizes[i]; j <= target; j++) {
                System.out.println(String.format("i=%s, w[%s] += w[%s], w[%s] = %s", i, j, (j-coinSizes[i]), (j-coinSizes[i]), ways[j-coinSizes[i]]));
                ways[j] += ways[j - coinSizes[i]];
            }
        }
        System.out.println(ways[ways.length-1]);
        return null;
    }

}