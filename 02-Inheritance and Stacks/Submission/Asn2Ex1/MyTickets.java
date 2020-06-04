/**
 * 
 * @author Ali Al-Musawi
 * @version 1.0
 * Assignment 2; CS-1027B; Spring 2019
 * 
 * This program reads in a .txt file and loads
 * its information, then processes it to 
 * generate a summary (report) of sales data.
 */
public class MyTickets {

	public static void main(String[] args) {
		
	InStringFile salesReader = new InStringFile("src/sales.txt"); // loading sales data.
	SalesReport report = new SalesReport(); // creating a sales report.
	
	try {
	report.getData(salesReader); // transferring the data into the program.
	
		try {
		report.computeStats(); // performing all calculations.
		report.displayResults(); // printing out a summary.
		
//	  To print out the Ticket objects by category, you may "uncomment"
//	  any of the following lines:
		
//		report.printWalkinTickets();
//		report.printRegularTickets();
//		report.printStudentTickets();
//		report.printAllTickets();
			
		}
		catch (DataUnavailableException e) {
			System.out.println(e.getMessage());
		}
	}
	catch (InvalidFileFormatException e) {
		System.out.println(e.getMessage());
	}
	
	

	}

}