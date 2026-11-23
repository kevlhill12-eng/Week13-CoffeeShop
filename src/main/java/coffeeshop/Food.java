package coffeeshop;

// STEP 2 · Food: a MenuItem that can be heated up for 50 cents.
//
// Open UML.md and find "Step 2 · Food extends MenuItem".
// First change the class line below to:   public class Food extends MenuItem {
//
//   1 constant:      HEAT_FEE   (public static final double)
//   1 private field: heated
//   1 constructor:   Food(String name, double price, boolean heated). Its first line is super(name, price);
//   3 methods:       isHeated(), and the overrides getPrice(), toString()
//
// Then drag check/coffeeshop/FoodTest.java into src/test/java/coffeeshop/ and run it.
// Commit message (after Drink is green too):  step 2: Drink and Food

public class Food extends MenuItem {

    public static final double HEAT_FEE = 0.50;

    private boolean heated;

    // Creates a Food item and stores whether it is heated.
    public Food(String name, double price, boolean heated) {
        super(name, price);
        this.heated = heated;
    }

    // Returns true if the food item is heated.
    public boolean isHeated() {
        return heated;
    }

    // Returns the item price plus HEAT_FEE if heated.s
    @Override
    public double getPrice() {
        if (heated) {
            return super.getPrice() + HEAT_FEE;
        }
        return super.getPrice();
    }

    // Formats the food item with ", heated" when heated, or delegates to MenuItem.toString().
    @Override
    public String toString() {
        if (heated) {
            return getName() + ", heated - $" + String.format("%.2f", getPrice());
        }
        return super.toString();
    }

}
