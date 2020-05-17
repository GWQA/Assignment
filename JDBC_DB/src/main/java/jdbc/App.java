package jdbc;

import java.sql.SQLException;
import java.util.Scanner;

public class App {

	private static Scanner scan = new Scanner(System.in);

	private static String getInput() {
		System.out.println("Please select an option - Create, Read, Update, Delete or Quit");
		return scan.nextLine();
	}

	public static void main(String[] args) throws SQLException {

		DB db = new DB();

		try {
			String Input = "";
			Input = getInput();

			do {

				switch (Input) {

				case "create":

					System.out.println("Please enter the CID:");
					int CID = scan.nextInt();
					scan.nextLine();

					System.out.println("Please enter your first name: ");
					String first_name = scan.nextLine();

					System.out.println("Please enter your last name: ");
					String last_name = scan.nextLine();

					System.out.println("Please enter your age:");
					int age = scan.nextInt();
					scan.nextLine();

					System.out.println("Please enter your address: ");
					String address = scan.nextLine();

					System.out.println("Please enter your email: ");
					String email = scan.nextLine();

					System.out.println("Please enter your city: ");
					String city = scan.nextLine();

					System.out.println("Please enter your postcode: ");
					String postcode = scan.nextLine();

					db.create(CID, first_name, last_name, age, address, email, city, postcode);
					break;

				case "read":
					db.read();
					break;

				case "update":
					System.out.println("Please enter your first name: ");
					String f_name = scan.nextLine();

					System.out.println("Please enter your last name: ");
					String l_name = scan.nextLine();

					System.out.println("Please enter the CID:");
					int C_ID = scan.nextInt();
					scan.nextLine();

					System.out.println("Please enter your age:");
					int a_ge = scan.nextInt();
					scan.nextLine();
					System.out.println("Please enter your address: ");
					String a_ddress = scan.nextLine();

					System.out.println("Please enter your email: ");
					String e_mail = scan.nextLine();

					System.out.println("Please enter your city: ");
					String c_ity = scan.nextLine();

					System.out.println("Please enter your postcode: ");
					String p_ostcode = scan.nextLine();

					db.update(C_ID, f_name, l_name, a_ge, a_ddress, e_mail, c_ity, p_ostcode);
					break;

				case "delete":
					System.out.println("Please enter the CID");
					int C_I_D = Integer.parseInt(scan.nextLine());
					db.delete(C_I_D);
					break;

				default:
					System.out.println("Input not recognised");

				}

				Input = getInput();

			} while (!Input.equals("quit"));
			System.out.println("Goodbye!");

		} finally {

			scan.close();
			db.quit();
		}
	}
}
