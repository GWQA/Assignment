package jdbc;

import java.sql.SQLException;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		CustomerInput ci = new CustomerInput();
		ProductInput pi = new ProductInput();
		OrderInput oi = new OrderInput();

		Scanner scan = new Scanner(System.in);
		System.out.println("Press - 1 for Customer info, 2 for Product info, 3 for Order info");

		String select = scan.nextLine();

		switch (select) {

		case "1":

			ci.getCustomerInput();
			break;

		case "2":

			pi.getProductInput();
			break;

		case "3":

			oi.getOrderInput();
			break;

		default:

			System.out.println("Please try again...");
		}
	}

}
