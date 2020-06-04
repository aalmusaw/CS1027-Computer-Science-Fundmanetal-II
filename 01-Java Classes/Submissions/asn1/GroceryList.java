/*
 * @author Ali Al-Musawi 251008221
 *         aalmusaw@uwo.ca
 *         Assignment 1, CS 1027B, Spring 2019
 *
 * This class defines the size of the shopping cart,
 * as well as how to add items, get total cost, and
 * create a visual summary of the total bill (receipt).
 */
package asn1;

import java.util.Arrays;
import java.util.List;

public class GroceryList {
    private GroceryItemOrder[] items;
    private int numItems;
    public static final int MAX_ITEM_QUANTITY = 10;
/*
 * Class Constructor
 * Ensures the maximum variety purchased is ten.
 */
    GroceryList() {
        this.items = new GroceryItemOrder[MAX_ITEM_QUANTITY];
        this.numItems = 0;
    }
/*
 * @param item is an object of class GroceryItemOrder.
 * item is added to the grocery list provided no more than 9
 * different varieties have been purchased.
 */
    public void addItem(GroceryItemOrder item) {
        if (numItems < MAX_ITEM_QUANTITY) {
            items[numItems] = item;
            numItems++;
            return;
        }
    }
/*
 * @returns the sum of the individual costs of each item per total quantity purchased.
 */
    public double getTotalCost() {
        double sum = 0.0;
        for (int i = 0; i < numItems; i++) {
            sum += items[i].getCost();
        }
        return sum;
    }
/*
 * @param itemName is the name of the desired item to check for in the shopping cart.
 * @returns whether or not the item is in the shopping cart.
 */ 
    public boolean GroceryListQuery(String itemName) {
    	String[] groceryNameList = new String[numItems];
    	for (int j=0; j<numItems; j++) {
    		groceryNameList[j] = items[j].getItemName();
    		
    	}
    	boolean found = Arrays.stream(groceryNameList).anyMatch(itemName::equals);
    	return found;
    }


/*
 * @returns a virtual receipt with a detailed summary of the items purchased
 * as well as the price per total quantity per item in the order they were added.
 */
        public String toString() {
            String cart = String.format("%s%n### |%-8s  |%-9s|%-7s|%n%s%n","-".repeat(35),
                    "Item Name", "Quantity", "Price", "-".repeat(35));
            for(int i = 0; i < numItems; i++) {
                cart += String.format("%02d  |%-8s   |    %-5d|$%-6.2f|%n",i+1,items[i].getItemName(),
                        items[i].getQuantity(), items[i].getCost());
            }
            cart += String.format("%s", "-".repeat(35));
            cart += String.format("%n%-6s%21s%s%7.2f", "Total:"," ","$", getTotalCost());
            cart += String.format("%n%s", "-".repeat(35));
            return cart;
        }
}
