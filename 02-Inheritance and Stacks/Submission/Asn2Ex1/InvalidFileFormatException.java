/**
 * 
 * @author Ali Al-Musawi
 * @version 1.0
 * Assignment 2; CS-1027B; Spring 2019
 * 
 * This class defines an exception related to methods in SalesReport.
 * If the wrong text file is imported, or the file is not formatted as intended
 * this exception is thrown.
 */
public class InvalidFileFormatException extends Exception {
	public InvalidFileFormatException(String message) {
		super(message);
	}

}
