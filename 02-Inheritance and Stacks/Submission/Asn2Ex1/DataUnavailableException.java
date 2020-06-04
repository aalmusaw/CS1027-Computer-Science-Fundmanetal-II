/**
 * 
 * @author Ali Al-Musawi
 * @version 1.0
 * Assignment 2; CS-1027B; Spring 2019
 * 
 * This class defines an exception related to methods in SalesReport.
 * If any data processing is performed without loading data
 * this exception is thrown. Note that even if the data is read,
 * if it is not stored properly, this exception is still thrown.
 */
public class DataUnavailableException extends Exception {
	public DataUnavailableException(String message) {
		super(message);
	}
}
