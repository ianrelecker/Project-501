package project;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.time.*;

//Using CoffeeOrder Class to construct receipt
class CoffeeOrder{
	public static String CoffeeName = "";
	public static String FlavorNames = "";
	public static double price = 0.0;
	public static String name= "";
	public static String datetime="";
	public static int drinkNumber=1;
	public static double subtotal=0.0;
	private static String newadds="";
	
	//happens on first launch to construct the top of the receipt
	public static void register() {
		newadds += "_____________Receipt______________\n";
		newadds += "Date: " + datetime;
		newadds += "Name: " + name + "\n";
	}
	//happens after each drink to save it to the receipt
	public static void save() {
		
		newadds += "Drink #: "+ drinkNumber+ "\n";
		drinkNumber++;
		newadds += "Coffee: " + CoffeeName+ "\n";
		CoffeeName = "";
		newadds += "Flavors: " + FlavorNames+ "\n";
		FlavorNames = "";
		newadds += "Subtotal: " + subtotal+ "\n";
	}
	
	//writes to file
	public static void Print() {
		try {
			File file = new File("receipt.txt");
			file.createNewFile();
		}catch(IOException e) {
			//
		}
		newadds += "Final Total: " + subtotal;
		System.out.println(newadds);

		String input = "";
		input += newadds;
		
		try {
			FileWriter write = new FileWriter("receipt.txt", true);
			write.write(input);
			write.close();
		} catch (IOException e) {
			//
		}
	}
	
}

public class CafeApp {

	public static void main(String[] args) {
		
		//gets datetime for receipt
		LocalDateTime da = java.time.LocalDateTime.now();
		
		CoffeeOrder.datetime = "Date: " + da.getMonthValue()+"/"+ da.getDayOfMonth()+"/"+ da.getYear()+" - " + da.getHour()+":"+ da.getMinute() +":"+ da.getSecond()+ "\n";
		//using the arrays for gui presentation
		String Drinks[] = {"1.     Iced Coffee   Single	 $3.00\n",
							"2.     Iced Coffee   Double	 $3.50",
							"3.     Cappuccino	Single     $3.50",
							"4.     Cappuccino	Double     $4.00",
							"5.     Latte	     Single     $3.50",
							"6.     Latte	     Double     $4.00"};
		String Adds[] = {"1.     Cream     $0.00",
						"2.     Sugar     $0.00",
						"3.     Almond    $0.50",
						"4.     Banana    $0.50",
						"5.     Cinnamon  $1.00",
						"6.     Cherry    $1.50",
						"7.     No More flavors!"};
		//using these arrays for total construction
		double pricesDrink[] = {3.00, 3.50, 3.50, 4.00, 3.50, 4.00};
		double pricesadd[] = {0.0, 0.0, 0.5, 0.5, 1.0, 1.5};
		System.out.println("=== Need Energy Cafe === \n"
				+ "\n"
				+ "1.     Iced Coffee   Single	 $3.00\n"
				+ "2.     Iced Coffee   Double	 $3.50\n"
				+ "3.     Cappuccino	Single     $3.50\n"
				+ "4.     Cappuccino	Double     $4.00\n"
				+ "5.     Latte	     Single     $3.50\n"
				+ "6.     Latte	     Double     $4.00\n");
		//setups while repeat
		boolean repeat = true;
		Scanner scanner = new Scanner(System.in);
		double subtotal = 0.0;

		//name capture and register
		System.out.println("What is your name?");
		CoffeeOrder.name = scanner.next();
		CoffeeOrder.register();
		
		//repeats for multiple drinks
		while (repeat) {
		
		System.out.print("\n"
				+ "Select Coffee [1-6]: ");
		boolean run = true;
		int inputdrink = 4264;
		int inputadd = 4264;
		
		//type checking and forcing value to be between 1 and 6
		while(run) {
			try {
				boolean correct = false;
				while(!correct) {
					inputdrink = scanner.nextInt();
					if(inputdrink==1||inputdrink==2||inputdrink==3||inputdrink==4||inputdrink==5||inputdrink==6) {
						inputdrink--;
						run = false;
						correct = true;
					}else {
						System.out.println("Incorrect input try again.");
					}
				}
			}catch(java.util.InputMismatchException e){
				System.out.println("Incorrect input try again.");
				scanner.next();
			}
		}
		//saving drinks and displaying them to screen and calculating total
		CoffeeOrder.CoffeeName += Drinks[inputdrink] + "\n";
		System.out.println("You selected: " + Drinks[inputdrink]);
		System.out.println("Subtotal: " + "$"+pricesDrink[inputdrink]+"0\n");
		subtotal += pricesDrink[inputdrink];
		System.out.println("=== Select Additional: === \n"
				+ "\n"
				+ "1.     Cream     $0.0\n"
				+ "2.     Sugar     $0.0\n"
				+ "3.     Almond    $0.50\n"
				+ "4.     Banana    $0.50\n"
				+ "5.     Cinnamon  $1.00\n"
				+ "6.     Cherry    $1.50\n"
				+ "7.     No More flavors!\n");
		//type checking to make sure input is sanitized
		run = true;
			while(run) {
				try {
					boolean correct = false;
					while(!correct) {
						inputadd = scanner.nextInt();
						if(inputadd==1||inputadd==2||inputadd==3||inputadd==4||inputadd==5||inputadd==6) {
							inputadd--;
							CoffeeOrder.FlavorNames += Adds[inputadd] + "\n";
							System.out.println("You selected: " + Adds[inputadd]);
							subtotal += pricesadd[inputadd];
							System.out.println("Subtotal: " + "$"+subtotal+"0\n");
						}else if(inputadd==7){
							System.out.println("Subtotal: " + "$"+subtotal+"0\n");
							run = false;
							correct = true;
						}else {
							System.out.println("Incorrect input try again.");
						}
					}
				}catch(java.util.InputMismatchException e){
					System.out.println("Incorrect input try again.");
					scanner.next();
				}
			}
		//getting total
		CoffeeOrder.subtotal = subtotal;
		System.out.println("Order Total: " + subtotal+ "\n");
		boolean repeatlook = true;
		CoffeeOrder.save();
		//checking for more drinks
		System.out.println("Would you like to order another drink? \nType \"y\" for yes and \"n\" for no.");
		while (repeatlook) {
			String hold = scanner.next();
			if (hold.equals("y")) {
				repeat = true;
				repeatlook = false;
			}else if (hold.equals("n")) {
				repeat = false;
				repeatlook = false;
			}else {
				System.out.println("incorrect input");
			}
			
		}
		
		
		}
		//final compose and write to file
		CoffeeOrder.Print();
		System.out.println("Done!");
		scanner.close();
	}

}
