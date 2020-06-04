/**
 * 
 * @author Ali Al-Musawi
 * @version 1.0
 * Assignment 3; CS-1027B; Spring 2019
 * This is a helper class. Objects of this class contain the binary code for each character from the Huffman Tree.
 *
 */
public class EncodingData {
	private char symbol; // what to encode
	private String encoding; // after encoding
	
	/**
	 * Class constructor
	 * @param symbol to encode.
	 * @param encoding encoded result.
	 */
	public EncodingData(char symbol, String encoding) {
		this.symbol = symbol;
		this.encoding = encoding;
	}
	
	/**
	 * Accessor method
	 * @return attribute symbol as char
	 */
	public char getSymbol() {
		return symbol;
	}
	
	/**
	 * Accessor method
	 * @return attribute encoding as String
	 */
	public String getEncoding() {
		return encoding;
	}
	
	/**
	 * Mutator method
	 * @param symbol the new symbol to use.
	 */
	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	
	/**
	 * Mutator method
	 * @param encoding a new encoding.
	 */
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
	
	/**
	 * A method to check equality based on the attribute symbol.
	 */
	public boolean equals(Object obj) {
		return this.symbol == ((EncodingData) obj).getSymbol();
	}
	
	/**
	 * A method that returns a String with the object attributes.
	 */
	public String toString() {
		return String.format("Symbol: %s%nEncoding: %s%n",Character.toString(symbol), encoding);
	}
	
	

}
