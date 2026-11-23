package challenges;
import java.util.ArrayList;

// SECTION D: ArrayList. add, get, size, and the for-each loop.
// The test is src/test/java/challenges/ListChallengesTest.java.
// Change only the lines marked YOUR CODE. Each method says what to give back.
// Refresh: Part 12 (ArrayList and the for-each loop).

public class ListChallenges {

    // Returns a new list containing all items that do not match soldOut ignoring case.
    public static ArrayList<String> removeSoldOut(ArrayList<String> items, String soldOut) {
        ArrayList<String> remaining = new ArrayList<>();
        if (items == null) {
            return remaining;
        }
        for (String item : items) {
            boolean isSoldOut = (soldOut == null)
                    ? (item == null)
                    : (item != null && item.equalsIgnoreCase(soldOut));
            if (!isSoldOut) {
                remaining.add(item);
            }
        }
        return remaining;
    }

    // Returns the longest name in the list, breaking ties with the first occurrence, or "" if empty.
    public static String longestName(ArrayList<String> names) {
        if (names == null || names.isEmpty()) {
            return "";
        }
        String longest = "";
        for (String name : names) {
            if (name != null && name.length() > longest.length()) {
                longest = name;
            }
        }
        return longest;
    }

    // Returns true if any exact string appears more than once in the list.
    public static boolean hasRepeat(ArrayList<String> names) {
        if (names == null) {
            return false;
        }
        for (int i = 0; i < names.size(); i++) {
            String current = names.get(i);
            for (int j = i + 1; j < names.size(); j++) {
                String other = names.get(j);
                if ((current == null && other == null) || (current != null && current.equals(other))) {
                    return true;
                }
            }
        }
        return false;
    }
}
