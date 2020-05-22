package jdbc;

import java.sql.SQLException;
import java.util.Scanner;

public class ProductInput {

	private static Scanner scan = new Scanner(System.in); // sets the scanner

	private static String getInput() {
		System.out.println("Please select an option - 1 to Add, 2 to View, 3 to Update, 4 to Delete or 5 Quit");
		return scan.nextLine(); // gives initial instructions to user
	}

	public void getProductInput() throws SQLException {

		DB db = new DB();

		try {
			String Input = "";
			Input = getInput();

			do {

				switch (Input) {

				case "1": // describes the fields needed from the user to create a new customer

					System.out.println("Please enter the PID:");
					int PID = scan.nextInt();
					scan.nextLine();

					System.out.println("Please enter the breed: ");
					String breed = scan.nextLine();

					System.out.println("Please enter the name: ");
					String name = scan.nextLine();

					System.out.println("Please enter the gender: ");
					String gender = scan.nextLine();

					System.out.println("Please enter the age: ");
					int age = scan.nextInt();
					scan.nextLine();

					System.out.println("Please enter the price: ");
					float price = scan.nextFloat();
					scan.nextLine();

					db.prodCreate(PID, breed, name, gender, age, price);
					System.out.println("Pet added successfully");
					break;

				case "2": // Upon users request - prints the rows displayed in the customer DB
					db.prodRead();
					System.out.println("Pet viewed successfully");
					break;

				case "4":
					System.out.println("Enter the PID:");
					int P_ID = Integer.parseInt(scan.nextLine());
					db.prodDel(P_ID);
					System.out.println("Pet deleted");
					break;

				default:
					System.out.println("Input not recognised"); // If user inputs the wrong fields required, this
					// message is displayed

				}

				Input = getInput();

			} while (!Input.equals("5"));
			System.out.println("Goodbye!"); // if user quits, this message is displayed

		} finally {

			scan.close();
			db.quit(); // closes the connection to the DB
		}
	}
}