/**
 * 
 * @author Ali Al-Musawi
 * @version 1.0
 * Assignment 2; CS-1027B; Spring 2019
 * 
 * This class defines the Sales Report class.
 * This class stores, processes sales data and generates a formatted report.
 */

public class SalesReport {
	private int totalSales;
	private double totalSalesVolume;
	private double[] salesVolumeByType;
	private double averageSales;
	private String highestFigureByTicket;
	private String highestFigureByDollar;
	private String[] salesByType = new String[3];
	private Ticket[][] ticketsList;
	
	/**
	 * Class constructor.
	 */
	public SalesReport() {}
	
	/**
	 * A method to retrieve data from a file using the class InStringFile.
	 * The data is first read in and stored as String.
	 * Next, the data is sorted into arrays.
	 * Then, new Ticket objects are created using the sorted arrays.
	 * Finally, all the Ticket objects are stored into a Ticket matrix
	 * where each row stores a different subclass of Ticket.
	 * @param reader an instance of InStringFile.
	 */
	public void getData(InStringFile reader) throws InvalidFileFormatException {
		try {
		// initialize string variables to store categorized data from the imported txt file.
		String walkinTickets="";
		String regularTickets="";
		String studentTickets="";
		while(!reader.endOfFile()) {
			String line = reader.read()+"\n";
			if (line.contains("walkin")) walkinTickets += line;
			if (line.contains("regular")) regularTickets += line;
			if (line.contains("student")) studentTickets += line;
		}
		
		// Split the categorized variables above into arrays that contain information about tickets.
		String[][] sortedData = {null, null, null};
		sortedData[0] = walkinTickets.split("\n");
		sortedData[1] = regularTickets.split("\n");
		sortedData[2] = studentTickets.split("\n");
		
		//Create a matrix that stores the tickets themselves by category.
		// The first row contains WalkinTicket objects.
		// The second row contains RegularTicket objects.
		// The third row contains StudentTicket objects.
		Ticket[][] tickets = {null, null, null};
		tickets[0] = new WalkInTicket[sortedData[0].length];
		tickets[1] = new RegularTicket[sortedData[1].length];
		tickets[2] = new StudentTicket[sortedData[2].length];
		for (int i = 0; i < sortedData[0].length; i++) {
			String[] ticket = sortedData[0][i].split(" ");
			int ticketNum = Integer.parseInt(ticket[0]);
			tickets[0][i] = new WalkInTicket(ticketNum);
		}
		for (int i = 0; i < sortedData[1].length; i++) {
			String[] ticket = sortedData[1][i].split(" ");
			int ticketNum = Integer.parseInt(ticket[0]);
			int daysPrior = Integer.parseInt(ticket[4].replace("\n", ""));
			tickets[1][i] = new RegularTicket(ticketNum, daysPrior);
		}
		for (int i = 0; i < sortedData[2].length; i++) {
			String[] ticket = sortedData[2][i].split(" ");
			int ticketNum = Integer.parseInt(ticket[0]);
			int daysPrior = Integer.parseInt(ticket[4].replace("\n", ""));
			tickets[2][i] = new StudentTicket(ticketNum, daysPrior);
		}
		
		// Save the Ticket objects into the class field ticketsList.
		ticketsList = tickets;
		}
		catch (Exception e) {
			throw new InvalidFileFormatException("The loaded data is not in the expected format.");
		}
		
		finally {
			reader.close();
		}
	}
	
	/**
	 * A method that computes a variety of sales analytics.
	 * All the information is taken from class fields.
	 * All the results are in turn stored into class fields.
	 */
	public void computeStats() throws DataUnavailableException {
		if (!dataAvailable()) throw new DataUnavailableException("No data detected. Please load sales data before analyzing.");
		// Stores information on sales by type into an array.
		// Visit comments on lines 48-50 for the order of storage.
		salesByType[0] = String.format("Walk-in Tickets Sales: %d.", ticketsList[0].length);
		salesByType[1] = String.format("Regular Tickets Sales: %d.", ticketsList[1].length);
		salesByType[2] = String.format("Student Tickets Sales: %d.", ticketsList[2].length);
		
		// Computing sales volume by type
		double salesVolume[] = {0, 0, 0};
		for (int i = 0; i < ticketsList.length; i++) {
			for (int j = 0; j < ticketsList[i].length; j++) {
				salesVolume[i] += ticketsList[i][j].ticketPrice;
			}
		}
		
		// Storing the result into the class field salesVolumeByType.
		salesVolumeByType = salesVolume;
		
		// Computing the largest sale by dollar and storing the result as a string in a class field.
		if (salesVolume[0]>salesVolume[1]&&salesVolume[0]>salesVolume[2]) {
			highestFigureByDollar = String.format("Largest Sale By Dollar (Walk-in): $%.2f",salesVolume[0]);
		}
		else if (salesVolume[1]>salesVolume[0]&&salesVolume[1]>salesVolume[2]) {
			highestFigureByDollar = String.format("Largest Sale By Dollar (Regular): $%.2f",salesVolume[1]);
		}
		else {
			highestFigureByDollar = String.format("Largest Sale By Dollar (Student): $%.2f",salesVolume[2]);
		}
		
		// Computing the largest sale by unit and storing the result as a string in a class field.
		if (ticketsList[0].length>ticketsList[1].length&&ticketsList[0].length>ticketsList[2].length) {
			highestFigureByTicket = String.format("Largest Sale By Ticket (Walk-in): %d.",ticketsList[0].length);
		}
		else if (ticketsList[1].length>ticketsList[0].length&&ticketsList[1].length>ticketsList[2].length) {
			highestFigureByTicket = String.format("Largest Sale By Ticket (Regular): %d.",ticketsList[1].length);
		}
		else {
			highestFigureByTicket = String.format("Largest Sale By Ticket (Student): %d.",ticketsList[2].length);
		}
		
		// Computing the total number of units (tickets) sold.
		totalSales = ticketsList[0].length + ticketsList[1].length + ticketsList[2].length;
		
		// Computing the total volume of sales in dollars.
		totalSalesVolume = salesVolume[0]+salesVolume[1]+salesVolume[2];
		
		// Computing the average dollar sale.
		averageSales = totalSalesVolume/totalSales;
		
	}
	
	/**
	 * A method that prints out a report summarizing sales data.
	 */
	public void displayResults() throws DataUnavailableException{
		if (!dataAvailable()) throw new DataUnavailableException("No data detected. Please load sales data before analyzing.");
		String report = "";
		report += "Sales Status: \n";
		report += salesByType[0] + "\n" + salesByType[1] + "\n" + salesByType[2] + "\n\n";
		report += "Sales Analytics: \n";
		report += String.format("Total Tickets Sold: %d.%n", totalSales);
		report += String.format("Total Sales' Volume: $%.2f%n", totalSalesVolume);
		report += String.format("Average Sale: $%.2f%n", averageSales);
		report += highestFigureByTicket+"\n";
		report += highestFigureByDollar+"\n";
		System.out.println(report);
	}
	
	/**
	 * A method that prints out all WalkinTicket objects.
	 */
	public void printWalkinTickets() {
		System.out.println("Printing all walk-in tickets..." + "\n");
		for(int i = 0; i < ticketsList[0].length; i++) {
			System.out.print(ticketsList[0][i]+"\n");
		}
		System.out.println("Printing Done!" + "\n");
	}
	
	/**
	 * A method that prints out all RegularTicket objects.
	 */
	public void printRegularTickets() {
		System.out.println("Printing all regular tickets..." + "\n");
		for(int i = 0; i < ticketsList[1].length; i++) {
			System.out.print(ticketsList[1][i]+"\n");
		}
		System.out.println("Printing Done!" + "\n");
	}
	
	/**
	 * A method that prints out all StudentTicket objects.
	 */
	public void printStudentTickets() {
		System.out.println("Printing all student tickets..." + "\n");
		for(int i = 0; i < ticketsList[2].length; i++) {
			System.out.print(ticketsList[2][i]+"\n");
		}
		System.out.println("Printing Done!" + "\n");
	}
	
	/**
	 * A method that prints out all Ticket objects.
	 */
	public void printAllTickets() {
		System.out.println("Printing all tickets..." + "\n");
		for(int i = 0; i < ticketsList.length; i++) {
			for(int j = 0; j < ticketsList[i].length;j++) {
				System.out.print(ticketsList[i][j]+"\n");
			}
		}
		System.out.println("Printing Done!" + "\n");
	}
	
	/**
	 * A query method that checks if data has been loaded into the program.
	 * @return true if data is available to perform computations.
	 */
	private boolean dataAvailable() {
		if (ticketsList!=null)
			return true;
		else
			return false;
	}
}
