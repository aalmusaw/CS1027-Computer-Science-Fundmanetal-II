/**
 * 
 * @author Ali Al-Musawi
 * @version 1.0
 * Assignment 2; CS-1027B; Spring 2019
 * This class defines state and behavior of candies.
 *
 */
public class Candy {
	private String colour;
	private String flavour;
	private boolean eaten;
	
	/**
	 * Class constructor.
	 * @param colour the candy colour.
	 * @param flavour the fruit flavour of the candy.
	 */
	public Candy(String colour, String flavour) {
		this.colour = colour;
		this.flavour = flavour;
		eaten = false;
	}
	
	/**
	 *
	 * A method that simulates eating a candy.
	 * @return true if the candy is eaten.
	 * Note the candy can only be eaten once.
	 */
	public boolean eat() {
		if (eaten)
			return false;
		else
			eaten = true;
			return true;
	}
	
	/**
	 * A query method for colour.
	 * @return candy colour.
	 */
	public String getColour() {
		return colour;
	}
	
	/**
	 * A query method for flavour.
	 * @return candy fruit flavour.
	 */
	public String getFlavour() {
		return flavour;
	}
	
	/**
	 * A method that returns a string representation of a Candy object.
	 */
	public String toString() {
		return String.format("Candy Colour: %s%nCandy Flavour: %s%n", colour, flavour);
	}
	
	
}
