package challenges;

// SECTION C: Arrays. for loops over an array, and a 2D array.
// The test is src/test/java/challenges/ArrayChallengesTest.java.
// Change only the lines marked YOUR CODE. Each method says what to give back.
// Refresh: Part 08 (for loops and nested loops), Part 10 (arrays and 2D arrays).

public class ArrayChallenges {

    // Finds the lowest price in the array, or returns 0.0 when empty.
    public static double cheapest(double[] prices) {
        if (prices == null || prices.length == 0) {
            return 0.0;
        }
        double lowest = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < lowest) {
                lowest = prices[i];
            }
        }
        return lowest;
    }

    // Counts how many prices are strictly greater than the limit.
    public static int countOver(double[] prices, double limit) {
        if (prices == null) {
            return 0;
        }
        int count = 0;
        for (double price : prices) {
            if (price > limit) {
                count++;
            }
        }
        return count;
    }

    // Returns the row index with the highest total cups, first index on ties, or -1 if empty.
    public static int busiestDay(int[][] cups) {
        if (cups == null || cups.length == 0) {
            return -1;
        }
        int bestRow = 0;
        int bestTotal = Integer.MIN_VALUE;
        for (int row = 0; row < cups.length; row++) {
            int rowTotal = 0;
            if (cups[row] != null) {
                for (int hourCups : cups[row]) {
                    rowTotal += hourCups;
                }
            }
            if (rowTotal > bestTotal) {
                bestTotal = rowTotal;
                bestRow = row;
            }
        }
        return bestRow;
    }
}

