package jdbc;

import java.sql.SQLException;
import java.util.Scanner;

public class CustomerInput {

	private static Scanner scan = new Scanner(System.in); // sets the scanner

	private static String getInput() {
		System.out.println("Please select an option - 1 to Create, 2 to Read, 3 to Update, 4 to Delete or 5 to Quit");
		return scan.nextLine(); // gives initial instructions to user
	}

	public void getCustomerInput() throws SQLException {

		DB db = new DB();

		try {
			String Input = "";
			Input = getInput();

			do {

				switch (Input) {

				case "1": // describes the fields needed from the user to create a new customer

					System.out.println("Please enter the CID:");
					int CID = scan.nextInt();
					scan.nextLine();

					System.out.println("Please enter your first name: ");
					String first_name = scan.nextLine();

					System.out.println("Please enter your last name: ");
					String last_name = scan.nextLine();

					System.out.println("Please enter your email: ");
					String email = scan.nextLine();

					System.out.println("Please enter your age: ");
					int age = scan.nextInt();
					scan.nextLine();

					db.custCreate(CID, first_name, last_name, email, age);
					System.out.println("Customer created successfully");
					break;

				case "2": // Upon users request - prints the rows displayed in the customer DB

					db.custRead();
					System.out.println("Customer read successfully");
					break;

				case "4":

					System.out.println("Enter the CID:");
					int C_ID = Integer.parseInt(scan.nextLine());
					db.custDel(C_ID);
					System.out.println("Customer deleted");
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
