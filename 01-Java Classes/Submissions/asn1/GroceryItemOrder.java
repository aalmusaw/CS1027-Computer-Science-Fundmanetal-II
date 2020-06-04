/*
 * @author Ali Al-Musawi 251008221
 *         aalmusaw@uwo.ca
 *         Assignment 1, CS 1027B, Spring 2019
 *
 * This class defines grocery items. More specifically,
 * it defines their name, how many of which a customer purchase,
 * and the price per unit. Finally, it defines accessor and
 * mutator methods relating to its fields.
 */
package asn1;

public class GroceryItemOrder {
    private String itemName;
    private int quantity;
    private double pricePerItem;
/*
 * Class Constructor
 * @param itemName is the name of the item ordered.
 * @param itemQuantity refers to the quantity ordered of the same item.
 * @param pricePerUnit is the price of one unit of the item in $##.##
 */
    GroceryItemOrder(String itemName,int itemQuantity, double pricePerUnit) {
        this.itemName = itemName;
        this.quantity = itemQuantity;
        this.pricePerItem = pricePerUnit;
    }
/*
 * @returns the cost per total quantity purchased.
 */
    public double getCost() {
        return quantity*pricePerItem;
    }
/*
 * @returns the name of the item purchased.
 */
    public String getItemName() {
        return itemName;
    }
/*
 * @returns the total quantity purchased of an item.
 */
    public int getQuantity() {
        return quantity;
    }
/*
 * @param Quantity is the desired number of units to purchase per item.
 */
    public void setQuantity(int Quantity) {
        quantity = Quantity;
        return;
    }
}

