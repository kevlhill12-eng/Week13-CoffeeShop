package coffeeshop;

import java.util.ArrayList;

// STEP 5 · CoffeeShop: the shop, its menu, and every order it finished today.
//
// Open UML.md and find "Step 5 · CoffeeShop".
//   4 private fields: name, menu, completedOrders, totalSales
//   1 constructor:    CoffeeShop(String name)
//   7 methods:        getName(), getMenu(), checkout(), getOrdersCompleted(),
//                     getTotalSales(), getItemsSold(), salesReport()
//
// Then drag check/coffeeshop/CoffeeShopTest.java into src/test/java/coffeeshop/ and run it.
// Commit message:  step 5: CoffeeShop

public class CoffeeShop {

    private String name;
    private Menu menu;
    private ArrayList<Order> completedOrders;
    private double totalSales;

    // Creates a coffee shop with a menu, empty order history, and zero sales.
    public CoffeeShop(String name) {
        this.name = name;
        this.menu = new Menu();
        this.completedOrders = new ArrayList<>();
        this.totalSales = 0.0;
    }

    // Returns the coffee shop's name.
    public String getName() {
        return name;
    }

    // Returns the coffee shop's menu.
    public Menu getMenu() {
        return menu;
    }

    // Calculates total for a non-empty order, records it, updates sales, and returns total.
    public double checkout(Order order, int tipPercent) {
        if (order == null || order.isEmpty()) {
            return 0.0;
        }
        double total = order.getTotal(tipPercent);
        completedOrders.add(order);
        totalSales += total;
        return total;
    }

    // Returns the number of completed orders.
    public int getOrdersCompleted() {
        return completedOrders.size();
    }

    // Returns total sales across all completed orders.
    public double getTotalSales() {
        return totalSales;
    }

    // Returns the total number of items sold across all completed orders.
    public int getItemsSold() {
        int count = 0;
        for (Order order : completedOrders) {
            count += order.getItemCount();
        }
        return count;
    }

    // Formats today's sales summary report.
    public String salesReport() {
        return name + " - today's sales\n"
                + "  Orders: " + getOrdersCompleted() + "\n"
                + "  Items sold: " + getItemsSold() + "\n"
                + "  Total: $" + String.format("%.2f", totalSales);
    }

}
