import java.util.Scanner;
/**
*
*@author s3401350 bo chi
*/


	public class Minnet {
		public static String MENU = "\nMinnet Menu\n ===================================\n"

				+ "1. Add a person into the network\n"
				+ "2. Select a person \n"
				+ "3. List everyone \n"
				+ "4. Connect two persons\n"
				+ "5. Are these two direct friend? \n"
				+ "6. Exit";
		
		public static String ENTER = "\n(enter two numbers separated by space)";
		
		static String input = "";
		
		static Scanner scanner = new Scanner(System.in);
		
		static Driver driver = new Driver();
		
		public void addPerson() {
			
			System.out.println("Enter in the following format: name, age");
			input = scanner.nextLine().trim();

			String name = input.split(",")[0];
			int age = Integer.parseInt(input.split(",")[1]);
			if (age >= 16) {
				Adult ad = new Adult(name, age);
				System.out.println("anyother information?");
				String status = scanner.nextLine();
				ad.setStatus(status);
				
				driver.addPersonToNetwork(ad);
				driver.addAdultToNetwork(ad);
				
			} else {
				System.out.println("\nChoose two adults as parents" + ENTER);
				for (int i = 0; i < driver.getAllAdults().size(); i++) {
					System.out.println(i+1 + ". " + driver.getAllAdults().get(i).getName());
				}
				input = scanner.nextLine().trim();
			
				int num1 = Integer.parseInt(input.split(" ")[0]);
				int num2 = Integer.parseInt(input.split(" ")[1]);
				if (num1 < 0 || num1-1 > driver.getAllAdults().size()-1) {
					System.out.println("Invalid input!");
				} else if (num2 < 0 || num2-1 > driver.getAllAdults().size()-1) {
					System.out.println("Invalid input!");
				} else {
					Dependent de = new Dependent(name, age , driver.getAllAdults().get(num1-1),driver.getAllAdults().get(num2-1));
					de.setparent1(driver.getAllAdults().get(num1-1));
					de.setparent2(driver.getAllAdults().get(num2-1));
					
					driver.getAllAdults().get(num1-1).setSpouse(driver.getAllAdults().get(num2-1));
					driver.getAllAdults().get(num2-1).setSpouse(driver.getAllAdults().get(num1-1));
					
					driver.addPersonToNetwork(de);
					driver.addChildToNetwork(de);
				}
			}
			
		}
		
		public void selectPerson() {
			System.out.println("Enter name:");
			input = scanner.nextLine().trim();
			Person person = driver.selectPersonByName(input);
			if (person != null) {
				if (person instanceof Adult) {
					System.out.println(person);
				} else {
					System.out.println(person);
				}
			} else {
				System.err.println("Cannot find " + input);
			}
			
		}
		
		public void connPerson() {
			
			for (int i = 0; i < driver.getAllPeople().size(); i++) {
				System.out.println(i+1 + ". " + driver.getAllPeople().get(i).getName());
			}

			System.out.println("\nChoose two people to see if they are friends " + ENTER);
			input = scanner.nextLine().trim();
			int num1 = Integer.parseInt(input.split(" ")[0]);
			int num2 = Integer.parseInt(input.split(" ")[1]);

			if (num1 < 0 || num1-1 > driver.getAllPeople().size()-1) {

				System.out.println("Invalid input!");

			} else if (num2 < 0 || num2-1 > driver.getAllPeople().size()-1) {

				System.out.println("Invalid input!");

			} else {

				driver.makeFriends(driver.getAllPeople().get(num1-1), driver.getAllPeople().get(num2-1));
			}

		}
		
		public void choice() {
			for (int i = 0; i < driver.getAllPeople().size(); i++) {
				System.out.println(i+1 + ". " + driver.getAllPeople().get(i).getName());
			}

			System.out.println("\nChoose two people to see if they are friends " + ENTER);
			input = scanner.nextLine().trim();
			int num1 = Integer.parseInt(input.split(" ")[0]);
			int num2 = Integer.parseInt(input.split(" ")[1]);
			if (num1 < 0 || num1-1 > driver.getAllPeople().size()-1) {

				System.out.println("Invalid input!");

			} else if (num2 < 0 || num2-1 > driver.getAllPeople().size()-1) {
				System.out.println("Invalid input!");
			} else {
				if(driver.checkFriendship(driver.getAllPeople().get(num1-1), driver.getAllPeople().get(num2-1))) {
					System.out.println(driver.getAllPeople().get(num1-1).getName() + " and " + driver.getAllPeople().get(num2-1).getName() + " are friends");
				} else {
					System.out.println("they are not friends!");
				}
			}
		} 
		
		public static void main(String[] args) {

			Minnet net = new Minnet();
			while (true) {
				
				try {
					System.out.println(MENU);
					input = scanner.nextLine().trim();
					switch (input) {
					
					case "1":
						net.addPerson();
						break;
	
					case "2":
	
						net.selectPerson();
						break;
	
					case "3":
	
						for (int i = 0; i < driver.getAllPeople().size(); i++) {
							System.out.println(i+1 + ". " + driver.getAllPeople().get(i).toString());
						}
						break;
	
					case "4":
	
						net.connPerson();
						break;
	
					case "5":
	
						net.choice();
						break;
						
					case "6":
						System.exit(0);
						
					default:
						System.err.println("Invalid input, please enter 1-7.");
					}
					
				}catch (Exception e) {
//					e.printStackTrace();
				}
			}
		}
	}


