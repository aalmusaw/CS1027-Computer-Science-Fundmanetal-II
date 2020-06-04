/**
 * 
 * @author Ali Al-Musawi
 * @version 1.0
 * Assignment 2; CS-1027B; Spring 2019
 * This class implements the attached .txt algorithm and simulates
 * a candy-eating situation using LinkedStack.
 *
 */
import java.util.Scanner;
public class CandyTest {
	static long simulationSpeed;
	public static void main(String[] args) {
		// Declaring the counts of interest to report on.
		int bananaCounter = 0;
		int leftoverCounter = 0;
		
		// This block simulates creating the candies and organizing them in the desired order.
		Candy[] initialCandyOrder = new Candy[10];
		initialCandyOrder[0] = new Candy("red", "strawberry");
		initialCandyOrder[1] = new Candy("purple", "blackberry");
		initialCandyOrder[2] = new Candy("green", "green apple");
		initialCandyOrder[3] = new Candy("pink", "watermelon");
		initialCandyOrder[4] = new Candy("yellow", "banana");
		initialCandyOrder[5] = new Candy("pink", "watermelon");
		initialCandyOrder[6] = new Candy("red", "strawberry");
		initialCandyOrder[7] = new Candy("yellow", "banana");
		initialCandyOrder[8] = new Candy("green", "green apple");
		initialCandyOrder[9] = new Candy("yellow", "banana");
		
		System.out.println("In the following demonstrations, the left end represents the stack bottom.\n\n");
		
		// This blocks asks for user input to set the simulation to the desired speed.
	        try {   	
	        	Scanner scanner = new Scanner(System.in);
	        	System.out.println("Please enter the desired simulation integer speed (milliseconds per event). ");
	        	System.out.println("It is recommended that you enter a value within [500, 1500] milliseconds: ");
	        	float userInputSpeed = scanner.nextFloat();
	        	scanner.close();
	        	simulationSpeed = (long) userInputSpeed;
	        	if (simulationSpeed <= 0) throw new Exception();
	        	System.out.println("Simulation speed has been set to " + simulationSpeed + " milliseconds per event.");
	        }
	        catch (Exception e){
	           System.out.println("Invalid input; simulation speed has been set to default: 0.5 second per event.");
	           simulationSpeed = 500;
	        }

		
		// This block simulates adding the candies into the plastic container in the desired order.
		LinkedStack<Candy> candyStack = new LinkedStack<Candy>();
		String demo1 = "|";
		System.out.println("Preparing the candy stack...\n");
		for(int i = initialCandyOrder.length-1; i >= 0; i--) {
			candyStack.push(initialCandyOrder[i]);
			demo1 += String.format("-%s", candyStack.peek().getColour());
			System.out.println(demo1);
			try {
			Thread.sleep(simulationSpeed);
			}
			catch (InterruptedException e)
			{
			continue;
			}
			
		}
		System.out.println("\nCandy stack prepared.");
		
		// This block simulates eating the yellow candies one at a time and removing the other candies.
		// The leftover candies are pushed onto a temporary stack.
		LinkedStack<Candy> tempStack = new LinkedStack<Candy>();
		String demo2 = "Candy Stack: " + demo1;
		String demo3 = "Temporary Stack: |";
		Candy popped;
		System.out.println("Dave is about to eat the banana candies...\n");
		while(!candyStack.isEmpty()) {
			if (candyStack.peek().getColour()=="yellow") {
				popped = candyStack.pop();
				popped.eat();
				System.out.println("Dave ate a banana candy!");
				bananaCounter++;
				}
			else {
				popped = candyStack.pop();
				tempStack.push(popped);
				demo3 += String.format("-%s", popped.getColour());
				System.out.println(demo3);
				leftoverCounter++;
				}
			String hyphenPopped = "-" + popped.getColour();
			demo2 = demo2.substring(0, demo2.length() - hyphenPopped.length());
			System.out.println(demo2 + "\n");	
			try {
			Thread.sleep(simulationSpeed);
			}
			catch (InterruptedException e)
			{
			continue;
			}
		}
		
		
		// This block simulates returning the leftover candies back to the original container to
		// ensure the initial order is preserved without the yellow candies.
		System.out.println("\nDave is returning the leftover candies to the original container...\n");
		String demo4 = demo3;
		String demo5 = demo2;
		while(!tempStack.isEmpty()) {
				popped = tempStack.pop();
				String hyphenPopped = "-" + popped.getColour(); 
				demo4 = demo4.substring(0, demo4.length() - hyphenPopped.length());
				System.out.println(demo4);
				candyStack.push(popped);
				demo5 += String.format("-%s", popped.getColour());
				System.out.println(demo5 + "\n");
				try {
					Thread.sleep(simulationSpeed);
					}
					catch (InterruptedException e)
					{
					continue;
					}
				}
		System.out.println("\nThe demonstration is over!");
		System.out.println("Dave ate a total of " + bananaCounter + " banana candies!");
		System.out.println("There is only " + leftoverCounter + " candies left.");
	}
	
	

}
