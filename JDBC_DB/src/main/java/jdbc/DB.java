package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

	private Connection conn;
	private Statement stmt;

	public DB() throws SQLException {
		conn = DriverManager.getConnection(DBConfig.URL, DBConfig.USER, DBConfig.PASSWORD); // connects to the DB
		stmt = conn.createStatement();
	}

	public void quit() throws SQLException {
		conn.close(); // closes connection to DB
	}

	public void custCreate(int CID, String first_name, String last_name, String email, int age) throws SQLException {
		stmt = conn.createStatement();
		stmt.executeUpdate("INSERT INTO customer VALUES (\"" + CID + "\", \"" + first_name + "\", \"" + last_name
				+ "\", \"" + email + "\", \"" + age + "\")");
		// Asks user to input the required fields, inputs the new data into rows within
		// the customer table
	}

	public void custRead() throws SQLException {
		ResultSet rs = stmt.executeQuery("SELECT * FROM customer");
		while (rs.next()) {
			String customer = rs.getString("CID") + " - " + rs.getString("first_name") + " " + rs.getString("last_name")
					+ ", " + rs.getString("email") + ", " + rs.getString("age");
			System.out.println(customer);
			// prints out the fields from the customer DB
		}
	}

	public void prodCreate(int PID, String breed, String name, String gender, int age, float price)
			throws SQLException {
		stmt = conn.createStatement();
		stmt.executeUpdate("INSERT INTO pets VALUES (\"" + PID + "\", \"" + breed + "\", \"" + name + "\", \"" + gender
				+ "\", \"" + age + "\", \"" + price + "\")");
		// Asks user to input the required fields, inputs the new data into rows within
		// the customer table
	}

	public void prodRead() throws SQLException {
		ResultSet rs = stmt.executeQuery("SELECT * FROM pets");
		while (rs.next()) {
			String pets = rs.getString("PID") + " - " + rs.getString("breed") + ", " + rs.getString("name") + ", "
					+ rs.getString("gender") + ", " + rs.getString("age") + ", " + rs.getFloat("price");
			System.out.println(pets);
			// prints out the fields from the customer DB
		}
	}

	public void ordrCreate(int OID, int CID, int quantity, int PID) throws SQLException {
		stmt = conn.createStatement();
		stmt.executeUpdate(
				"INSERT INTO orders VALUES (\"" + OID + "\", \"" + CID + "\", \"" + quantity + "\", \"" + PID + "\")");
		// Asks user to input the required fields, inputs the new data into rows within
		// the customer table
	}

	public void ordrRead() throws SQLException {
		ResultSet rs = stmt.executeQuery("SELECT * FROM orders");
		while (rs.next()) {
			String orders = rs.getString("OID") + " - " + rs.getString("CID") + ", " + rs.getString("quantity") + ", "
					+ rs.getString("PID");
			System.out.println(orders);
			// prints out the fields from the customer DB
		}
	}

	public void ordrValue(int OID) throws SQLException {
		ResultSet rs = stmt.executeQuery(
				"SELECT (pets.price * orders.quantity) AS order_total FROM pets, orders WHERE pets.PID = orders.PID AND OID = "
						+ OID);
		while (rs.next()) {
			String value = rs.getString("order_total");
			System.out.println(value);
			// User enters OID, it then targets the pets price and order quantity and
			// multiplies them accordingly
		}
	}
}
