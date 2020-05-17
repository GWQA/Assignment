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
		conn = DriverManager.getConnection(DBConfig.URL, DBConfig.USER, DBConfig.PASSWORD);
		stmt = conn.createStatement();
	}

	public void quit() throws SQLException {
		conn.close();
	}

	public void create(int CID, String first_name, String last_name, int age, String address, String email, String city,
			String postcode) throws SQLException {
		stmt = conn.createStatement();
		String sql = "INSERT INTO customer (CID, first_name, last_name, age, address, email, city, postcode) VALUES ("
				+ CID + ", " + first_name + ", " + last_name + ", " + age + ", " + address + ", " + email + ", " + city
				+ ", " + postcode + ")";
		stmt.executeUpdate(sql);
	}

	public void read() throws SQLException {
		ResultSet rs = stmt.executeQuery("SELECT * FROM customer");
		while (rs.next()) {
			String customer = rs.getString("CID") + " - " + rs.getString("first_name") + " " + rs.getString("last_name")
					+ ", " + rs.getString("email") + ", " + rs.getString("age");
			System.out.println(customer);
		}
	}

	public void update(int C_ID, String f_name, String l_name, int a_ge, String a_ddress, String e_mail, String c_ity,
			String p_ostcode) throws SQLException {
		stmt.executeUpdate("UPDATE customer SET first_name = '" + f_name + "', last_name = '" + l_name + "', age = '"
				+ a_ge + "', address = '" + a_ddress + "', email = '" + e_mail + "', city = '" + c_ity
				+ "' WHERE CID = " + C_ID);
	}

	public void delete(int C_I_D) throws SQLException {
		stmt.executeUpdate("DELETE FROM game WHERE CID = " + C_I_D);
	}

}
