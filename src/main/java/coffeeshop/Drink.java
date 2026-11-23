package coffeeshop;

// STEP 2 · Drink: a MenuItem that comes in a size, S, M or L.
//
// Open UML.md and find "Step 2 · Drink extends MenuItem".
// First change the class line below to:   public class Drink extends MenuItem {
// (It does not say "extends" yet, so this file still compiles while you work on Step 1.)
//
//   2 constants:     MEDIUM_UPCHARGE, LARGE_UPCHARGE   (public static final double)
//   1 private field: size
//   1 constructor:   Drink(String name, double price, char size). Its first line is super(name, price);
//   4 methods:       getSize(), and the overrides getPrice(), isDrink(), toString()
//
// Then drag check/coffeeshop/DrinkTest.java into src/test/java/coffeeshop/ and run it.
// Commit message (after Food is green too):  step 2: Drink and Food

public class Drink extends MenuItem{

    public static final double MEDIUM_UPCHARGE = 0.50;
    public static final double LARGE_UPCHARGE = 1.00;

    private char size;

    // Creates a Drink and normalizes any size other than M or L to 'S'.
    public Drink(String name, double price, char size) {
        super(name, price);
        char upper = Character.toUpperCase(size);
        if (upper == 'M' || upper == 'L') {
            this.size = upper;
        } else {
            this.size = 'S';
        }
    }

    // Returns the drink's size ('S', 'M', or 'L').
    public char getSize() {
        return size;
    }

    // Returns the base price plus the size upcharge for medium or large drinks.
    @Override
    public double getPrice() {
        double total = super.getPrice();
        if (size == 'M') {
            total += MEDIUM_UPCHARGE;
        } else if (size == 'L') {
            total += LARGE_UPCHARGE;
        }
        return total;
    }

    // Returns true because a Drink is a drink.
    @Override
    public boolean isDrink() {
        return true;

    }
}
