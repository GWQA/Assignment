package jdbc;

import java.sql.SQLException;
import java.util.Scanner;

public class OrderInput {

	private static Scanner scan = new Scanner(System.in); // sets the scanner

	private static String getInput() {
		System.out.println(
				"\"Please select an option - 1 to Create, 2 to View, 3 to Update, 4 to Delete, 5 to Calculate or 6 to Quit");
		return scan.nextLine(); // gives initial instructions to user
	}

	public void getOrderInput() throws SQLException {

		DB db = new DB();

		try {
			String Input = "";
			Input = getInput();

			do {

				switch (Input) {

				case "1": // describes the fields needed from the user to create a new customer

					System.out.println("Please enter the OID:");
					int OID = scan.nextInt();
					scan.nextLine();

					System.out.println("Please enter the CID:");
					int CID = scan.nextInt();
					scan.nextLine();

					System.out.println("Please enter the quantity:");
					int quantity = scan.nextInt();
					scan.nextLine();

					System.out.println("Please enter the PID:");
					int PID = scan.nextInt();
					scan.nextLine();

					db.ordrCreate(OID, CID, quantity, PID);
					System.out.println("Order created successfully");
					break;

				case "2": // Upon users request - prints the rows displayed in the customer DB
					db.ordrRead();
					System.out.println("Order viewed successfully");
					break;

				case "5": // requests the user to enter the OID of the product they want to calculate
					System.out.println("Please enter the OID of the order you wish to calculate the totol for: ");
					int O_ID = scan.nextInt();
					scan.nextLine();
					db.ordrValue(O_ID);
					System.out.println("Order calculated successfully");
					break;

				default:
					System.out.println("Input not recognised");
					// If user inputs the wrong fields required, this
					// message is displayed

				}

				Input = getInput(); // dont remove this ever again -- nearly blew my laptop up...

			} while (!Input.equals("6"));
			System.out.println("Goodbye!"); // if user quits, this message is displayed

		} finally {

			scan.close();
			db.quit(); // closes the connection to the DB
		}
	}
}