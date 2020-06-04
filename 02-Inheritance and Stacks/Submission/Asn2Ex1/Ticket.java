/**
 * 
 * @author Ali Al-Musawi
 * @version 1.0
 * Assignment 2; CS-1027B; Spring 2019
 * 
 * This class defines the Ticket superclass from which three other
 * ticket types inherit. No instance of this class will be created.
 */
public class Ticket {
	protected int ticketNumber; // modifier is protected to allow for inheritance.
	protected double ticketPrice; // see note above
	
	/**
	 * Class constructor that creates a Ticket instance given a number.
	 * @param num the ticket number used to generate a new ticket.
	 */
	public Ticket(int num) {
		ticketNumber = num;
	}
	
	/**
	 * A method that sets the ticket price.
	 * @param price the ticket price.
	 */
	public void setPrice(double price) {
		ticketPrice = price;
	}
	
	/**
	 * A price query method.
	 * @return the ticket price.
	 */
	public double getPrice() {
		return ticketPrice;
	}
	
	/**
	 * A method that changes the ticket number.
	 * @param num the new ticket number.
	 */
	public void setNumber(int num) {
		ticketNumber = num;
	}
	
	/**
	 * A ticket number query method.
	 * @return
	 */
	public int getNumber() {
		return ticketNumber;
	}
	
	/**
	 * A method that represents a ticket as a String. 
	 * @return the ticket number along with the price in a formatted manner.
	 */
	public String toString() {
		return String.format("Ticket Number: %d%nTicket Price: $%.2f%n", ticketNumber, ticketPrice);
	}
	
}
