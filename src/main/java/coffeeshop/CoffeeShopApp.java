package coffeeshop;

import java.util.Scanner;

// STEP 6 · CoffeeShopApp: the game you play. This is the class with main.
//
// It already runs. Click the green arrow next to main and try it.
//
// In Step 6 you finish it. Open UML.md ("Step 6") and the README ("Step 6") for the
// screens and the exact sentences. You add:
//   2 more private fields: shop and order
//   the game loop in run()
//   printBanner(), printMainMenu(), and one method for each menu choice
//
// Then drag check/coffeeshop/CoffeeShopAppTest.java into src/test/java/coffeeshop/ and run it.
// Commit message:  step 6: game loop

public class CoffeeShopApp {

    private Scanner input;
    private CoffeeShop shop;
    private Order order;

    // Sets up the scanner, creates Hornet Coffee, and starts the first order.
    public CoffeeShopApp(Scanner input) {
        this.input = input;
        this.shop = new CoffeeShop("Hornet Coffee");
        this.order = new Order();
    }

    // Runs the main game loop until the user chooses 0 to close the shop.
    public void run() {
        printBanner();
        boolean running = true;
        while (running) {
            printMainMenu();
            int choice = readNumber("Pick a number: ");
            switch (choice) {
                case 1 -> System.out.print(shop.getMenu());
                case 2 -> addItem();
                case 3 -> removeItem();
                case 4 -> viewOrder();
                case 5 -> useCoupon();
                case 6 -> checkout();
                case 7 -> System.out.println(shop.salesReport());
                case 0 -> {
                    running = false;
                    System.out.println("Shop closed. Goodbye!");
                }
                default -> System.out.println("That is not on the list. Pick 0 to 7.");
            }
        }
    }

    // Prints the ASCII coffee cup art and the shop title.
    private void printBanner() {
        System.out.println("      ( (");
        System.out.println("       ) )");
        System.out.println("    ........");
        System.out.println("    |      |]");
        System.out.println("    \\      /");
        System.out.println("     `----'");
        System.out.println("  HORNET COFFEE");
    }

    // Prints the main menu header with order details and numbered choices 1-7 and 0.
    private void printMainMenu() {
        System.out.println("=====================================");
        System.out.println("   " + shop.getName().toUpperCase() + "  -  Order #" + order.getOrderNumber() + "  (" + order.getItemCount() + " items)");
        System.out.println("=====================================");
        System.out.println(" 1. See the menu");
        System.out.println(" 2. Add an item");
        System.out.println(" 3. Remove an item");
        System.out.println(" 4. View my order");
        System.out.println(" 5. Use a coupon");
        System.out.println(" 6. Check out");
        System.out.println(" 7. Today's sales");
        System.out.println(" 0. Close the shop");
        System.out.println("-------------------------------------");
    }

    // Shows the menu, prompts for an item and drink size or food heating option, and adds a new item.
    private void addItem() {
        System.out.print(shop.getMenu());
        int number = readNumber("Item number: ");
        MenuItem picked = shop.getMenu().getItem(number);
        if (picked == null) {
            System.out.println("That item is not on the menu.");
            return;
        }
        MenuItem newItem;
        if (picked.isDrink()) {
            String sizeText = readText("Size (S, M, L): ");
            char size = sizeText.isEmpty() ? 'S' : sizeText.charAt(0);
            newItem = new Drink(picked.getName(), picked.getPrice(), size);
        } else {
            String heatText = readText("Heat it up? (y/n): ");
            boolean heated = heatText.equalsIgnoreCase("y");
            newItem = new Food(picked.getName(), picked.getPrice(), heated);
        }
        order.addItem(newItem);
        System.out.println("Added. Your order has " + order.getItemCount() + " items.");
    }

    // Removes an item by 1-based number if the order is not empty.
    private void removeItem() {
        if (order.isEmpty()) {
            System.out.println("Your order is empty.");
            return;
        }
        System.out.println(order);
        int number = readNumber("Item number to remove: ");
        if (order.removeItem(number)) {
            System.out.println("Removed.");
        } else {
            System.out.println("That item is not in your order.");
        }
    }

    // Displays the current order or prints that the order is empty.
    private void viewOrder() {
        if (order.isEmpty()) {
            System.out.println("Your order is empty.");
            return;
        }
        System.out.println(order);
    }

    // Prompts for a coupon code and reports whether it was applied.s
    private void useCoupon() {
        String code = readText("Coupon code: ");
        if (order.applyCoupon(code)) {
            System.out.println("Coupon applied.");
        } else {
            System.out.println("Invalid coupon code.");
        }
    }

    // Asks for a tip percentage, checks out the order, prints the total, and starts a fresh order.
    private void checkout() {
        if (order.isEmpty()) {
            System.out.println("Your order is empty.");
            return;
        }
        System.out.println(order);
        int tipPercent = readNumber("Tip percent (0, 10, 15, 20): ");
        double total = shop.checkout(order, tipPercent);
        System.out.println("Total: $" + String.format("%.2f", total));
        order = new Order();
    }

    // GIVEN CODE. Do not change it. Use it for every number the user types.
    // It keeps asking until the user types a whole number, so letters can not crash your game.
    private int readNumber(String prompt) {
        System.out.print(prompt);
        while (!input.hasNextInt()) {
            input.nextLine();                    // throw away what they typed
            System.out.print("Please type a number: ");
        }
        int number = input.nextInt();
        input.nextLine();                        // throw away the Enter key
        return number;
    }

    // GIVEN CODE. Do not change it. Use it for every word the user types.
    // Reads one line of text, with the spaces at the ends cut off.
    private String readText(String prompt) {
        System.out.print(prompt);
        return input.nextLine().trim();
    }

    // Start here. Click the green arrow next to this line to run the game.
    public static void main(String[] args) {
        CoffeeShopApp app = new CoffeeShopApp(new Scanner(System.in));
        app.run();
    }
}
