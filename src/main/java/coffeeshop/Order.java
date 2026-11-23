package coffeeshop;

import java.util.ArrayList;

// STEP 4 · Order: one customer's order.
//
// Open UML.md and find "Step 4 · Order". This is the biggest class. Build it one method at a
// time, and run the test after each one.
//   2 constants:      COUPON_CODE, COUPON_PERCENT   (public static final)
//   1 static field:   nextOrderNumber, starts at 1
//   3 private fields: orderNumber, items, discountPercent
//   1 constructor:    Order()
//   10 methods:       getOrderNumber(), addItem(), removeItem(), getItemCount(), isEmpty(),
//                     getSubtotal(), applyCoupon(), getDiscount(), getTotal(), toString()
//
// Then drag check/coffeeshop/OrderTest.java into src/test/java/coffeeshop/ and run it.
// Commit message:  step 4: Order

public class Order {

    public static final String COUPON_CODE = "HORNET10";
    public static final int COUPON_PERCENT = 10;

    private static int nextOrderNumber = 1;

    private int orderNumber;
    private ArrayList<MenuItem> items;
    private int discountPercent;

    // Creates a new order with a unique sequential order number.
    public Order() {
        this.orderNumber = nextOrderNumber;
        nextOrderNumber++;
        this.items = new ArrayList<>();
        this.discountPercent = 0;
    }

    // Returns this order's number.
    public int getOrderNumber() {
        return orderNumber;
    }

    // Adds a menu item to this order.
    public void addItem(MenuItem item) {
        if (item != null) {
            items.add(item);
        }
    }

    // Removes the 1-based item from the order and returns true if valid.
    public boolean removeItem(int number) {
        if (number < 1 || number > items.size()) {
            return false;
        }
        items.remove(number - 1);
        return true;
    }

    // Returns the total number of items in the order.
    public int getItemCount() {
        return items.size();
    }

    // Returns true if the order has no items.
    public boolean isEmpty() {
        return items.isEmpty();
    }

    // Returns the sum of getPrice() across all items in the order.
    public double getSubtotal() {
        double subtotal = 0.0;
        for (MenuItem item : items) {
            subtotal += item.getPrice();
        }
        return subtotal;
    }

    // Applies the coupon if the trimmed, case-insensitive code matches COUPON_CODE.
    public boolean applyCoupon(String code) {
        if (code != null && code.trim().equalsIgnoreCase(COUPON_CODE)) {
            discountPercent = COUPON_PERCENT;
            return true;
        }
        return false;
    }

    // Returns the dollar discount amount based on the current subtotal and discountPercent.
    public double getDiscount() {
        return getSubtotal() * discountPercent / 100.0;
    }

    // Returns the final total after applying the discount and tip on the discounted amount.
    public double getTotal(int tipPercent) {
        double discountedTotal = getSubtotal() - getDiscount();
        int effectiveTip = Math.max(0, tipPercent);
        return discountedTotal + (discountedTotal * effectiveTip / 100.0);
    }

    // Formats the order details, numbered items, subtotal, and optional discount line.
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order #").append(orderNumber).append("\n");
        for (int i = 0; i < items.size(); i++) {
            sb.append("  ").append(i + 1).append(". ").append(items.get(i).toString()).append("\n");
        }
        sb.append("Subtotal: $").append(String.format("%.2f", getSubtotal()));
        if (discountPercent > 0) {
            sb.append("\nDiscount: -$").append(String.format("%.2f", getDiscount()));
        }
        return sb.toString();
    }

}
