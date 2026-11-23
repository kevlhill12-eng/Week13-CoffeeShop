package edu.desu.cis;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
/*
Hornet Coffee


    Hornet Coffee is a console-based coffee shop simulator where customers browse the menu, customize orders, apply coupons, check out with a tip, and track daily sales.

           How to Run It

    Open `src/main/java/coffeeshop/CoffeeShopApp.java` in IntelliJ and click the green Run button next to `public static void main(String[] args)`.

            Classes

MenuItem: Represents a general item for sale with a name, base price, drink status check, and formatted price string.
 Drink: Extends `MenuItem` to add drink sizes (`S`, `M`, `L`) with size upcharges and custom size-included formatting.
Food: Extends `MenuItem` to support warming food items for a heating fee and updating the display text when heated.
Menu: Stores the eight starting drinks and food items in an `ArrayList` and retrieves items using 1-based menu numbering.
Order Manages a single customer order with an automatic order number, item list, coupon discount logic, and total calculation with tip.
CoffeeShop: Holds the shop's menu, completed orders, and total revenue while handling checkout and generating today's sales report.
CoffeeShopApp: Runs the interactive main menu loop and connects user input to the shop and current order.


*/
    Aligning 1-based user menu and order numbers with 0-based `ArrayList` indexes—and making sure adding a drink creates a new `Drink` instead of modifying the menu's default small drink—caused issues until I added bounds checks (`1` to `size()`) and instantiated a fresh `Drink` or `Food` on every addition.
    static void main() {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        IO.println(String.format("Hello and welcome!"));

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            IO.println("i = " + i);
        }
    }
}
