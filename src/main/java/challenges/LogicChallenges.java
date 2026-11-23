package challenges;

// SECTION A: Logic. if, else if, && and ||, and a little math.
// The test is src/test/java/challenges/LogicChallengesTest.java.
// Change only the lines marked YOUR CODE. Each method says what to give back.
// Refresh: Part 06 (if and switch), Part 07 (logical operators), Part 13 (methods).

public class LogicChallenges {

    // Returns the extra cost for a drink size, or -1.0 if the size is invalid.
    public static double sizeUpcharge(char size) {
        char upper = Character.toUpperCase(size);
        if (upper == 'S') {
            return 0.0;
        }
        if (upper == 'M') {
            return 0.50;
        }
        if (upper == 'L') {
            return 1.00;
        }
        return -1.0;
    }

    // Checks if hour (0-23) falls within happy hour on a weekday or weekend.
    public static boolean isHappyHour(int hour, boolean weekend) {
        if (hour < 0 || hour > 23) {
            return false;
        }
        if (weekend) {
            return hour >= 12 && hour <= 17;
        }
        return hour >= 14 && hour <= 16;
    }

    // Calculates free drinks earned every 10 stamps from existing plus bought drinks.
    public static int freeDrinks(int stamps, int bought) {
        if (stamps < 0 || bought < 0) {
            return 0;
        }
        return (stamps + bought) / 10;
    }

    // Computes the minimum coin count using quarters, dimes, nickels, and pennies.
    public static int coinsForChange(int cents) {
        if (cents <= 0) {
            return 0;
        }
        int remaining = cents;
        int coins = remaining / 25;
        remaining %= 25;

        coins += remaining / 10;
        remaining %= 10;

        coins += remaining / 5;
        remaining %= 5;

        coins += remaining;
        return coins;
    }
}
