package challenges;

// SECTION B: Strings. length, charAt, substring, indexOf, toUpperCase, trim, equals.
// The test is src/test/java/challenges/StringChallengesTest.java.
// Change only the lines marked YOUR CODE. Each method says what to give back.
// Refresh: Part 11 (String methods and wrapper classes), Part 14 (printf).

public class StringChallenges {

    // Builds a cup code from up to the first three letters of name, a dash, and uppercase size.
    public static String orderCode(String name, char size) {
        String safeName = (name == null) ? "" : name.trim();
        int prefixLength = Math.min(3, safeName.length());
        String prefix = safeName.substring(0, prefixLength).toUpperCase();
        char upperSize = Character.toUpperCase(size);
        return prefix + "-" + upperSize;
    }

    // Trims whitespace and formats the name in title case, or returns "Guest" if blank.
    public static String cupName(String name) {
        if (name == null) {
            return "Guest";
        }
        String trimmed = name.trim();
        if (trimmed.isEmpty()) {
            return "Guest";
        }
        String first = trimmed.substring(0, 1).toUpperCase();
        String rest = trimmed.substring(1).toLowerCase();
        return first + rest;
    }

    // Counts case-insensitive occurrences of word in order, advancing past each match.
    public static int countWord(String order, String word) {
        if (order == null || word == null || word.isEmpty()) {
            return 0;
        }
        String lowerOrder = order.toLowerCase();
        String lowerWord = word.toLowerCase();
        int count = 0;
        int searchFrom = 0;
        while (searchFrom <= lowerOrder.length() - lowerWord.length()) {
            int foundAt = lowerOrder.indexOf(lowerWord, searchFrom);
            if (foundAt == -1) {
                break;
            }
            count++;
            searchFrom = foundAt + lowerWord.length();
        }
        return count;
    }

    // Pads name with dots up to a 20-character prefix and appends the price formatted to 2 decimals.
    public static String receiptLine(String name, double price) {
        String safeName = (name == null) ? "" : name;
        StringBuilder sb = new StringBuilder(safeName);
        while (sb.length() < 20) {
            sb.append('.');
        }
        sb.append('$').append(String.format("%.2f", price));
        return sb.toString();
    }
}