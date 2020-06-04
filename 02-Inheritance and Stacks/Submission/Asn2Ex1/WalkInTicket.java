/**
 * 
 * @author Ali Al-Musawi
 * @version 1.0
 * Assignment 2; CS-1027B; Spring 2019
 * 
 * This class inherits form the Ticket superclass.
 */
public class WalkInTicket extends Ticket {
	
	/**
	 * Class constructor. Sets the price to $40.00 automatically.
	 * @param num the ticket number used to generate a new ticket.
	 */
	public WalkInTicket(int num) {
		super(num);
		ticketPrice = 40.00;
	}
	
	/**
	 * A method that represents a walk-in ticket as a String. 
	 * @return the ticket number along with the price and type in a formatted manner.
	 */
	public String toString() {
		return super.toString() + "Ticket Type: Walk-in\n";
	}
}
