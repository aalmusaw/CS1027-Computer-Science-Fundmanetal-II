/**
 * 
 * @author Ali Al-Musawi
 * @version 1.0
 * Assignment 2; CS-1027B; Spring 2019
 * 
 * This class inherits form the Ticket superclass.
 */
public class StudentTicket extends Ticket{
	
	private int daysPriorToEvent;
	
	/**
	 * Class constructor. Sets the price to $15.00 or $10.00
	 * depending on when the ticket is purchased.
	 * @param num the ticket number used to generate a new ticket.
	 * @param daysPrior the number of days prior to the event when
	 * the ticket is purchased.
	 */
	public StudentTicket(int num, int daysPrior) {
		super(num);
		daysPriorToEvent = daysPrior;
		if (purchasedPrior())
			ticketPrice = 10.00;
		else
			ticketPrice = 15.00;
	}
	
	/**
	 * A method that represents a student ticket as a String. 
	 * @return the ticket number along with the price, type, and a note in a formatted manner.
	 */
	public String toString() {
		String str = super.toString() + "Ticket Type: Student\n";
		if (purchasedPrior())
			str += String.format("Note: The ticket was purchased %d days before the event.%n"
					+ "      A total discount of $20 has been applied!%n      Student ID is required.%n", daysPriorToEvent);
		else
			str += "Note: A total discount of $15 has been applied!\n      Student ID is required.\n";
		return str;	
	}
	
	/**
	 * A query method to determine whether a discount is applied.
	 * @return true if the ticket is purchased 10 days or more
	 * before the event.
	 */
	private boolean purchasedPrior() {
		if (daysPriorToEvent >= 10)
			return true;
		else
			return false;
	}
	
}
