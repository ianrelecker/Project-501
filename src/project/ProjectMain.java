package project;

import java.util.Scanner;

public class ProjectMain {

	public static void main(String[] args) {
		String adds = "Receipt\n";
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
		Scanner scanner = new Scanner(System.in);
		System.out.print("\n"
				+ "Select Coffee [1-6]: ");
		boolean run = true;
		int inputdrink = 4264;
		int inputadd = 4264;
		double subtotal = 42.64;
		//type checking and forcing value to be between 1 and 6
		while(run) {
			try {
				boolean correct = false;
				while(!correct) {
					inputdrink = scanner.nextInt();
					if(inputdrink==1||inputdrink==2||inputdrink==3||inputdrink==4||inputdrink==5||inputdrink==6) {
						//System.out.println("You entered: " + inputdrink);
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
		adds += Drinks[inputdrink] + "\n";
		System.out.println("You selected: " + Drinks[inputdrink]);
		System.out.println("Subtotal: " + "$"+pricesDrink[inputdrink]+"0\n");
		subtotal = pricesDrink[inputdrink];
		System.out.println("=== Select Additional: === \n"
				+ "\n"
				+ "1.     Cream     $0.0\n"
				+ "2.     Sugar     $0.0\n"
				+ "3.     Almond    $0.50\n"
				+ "4.     Banana    $0.50\n"
				+ "5.     Cinnamon  $1.00\n"
				+ "6.     Cherry    $1.50\n"
				+ "7.     No More flavors!\n");
		
		run = true;
			while(run) {
				try {
					boolean correct = false;
					while(!correct) {
						inputadd = scanner.nextInt();
						if(inputadd==1||inputadd==2||inputadd==3||inputadd==4||inputadd==5||inputadd==6) {
							//System.out.println("You entered: " + inputadd);
							inputadd--;
							adds += Adds[inputadd] + "\n";
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
		adds += "Final Total: " + subtotal;
		System.out.println(adds);
		scanner.close();
		

	}

}
