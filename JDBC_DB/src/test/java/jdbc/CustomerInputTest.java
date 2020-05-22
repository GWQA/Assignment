package jdbc;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CustomerInputTest {

	public static Connection conn;
	public static Statement stmnt;

	@Mock
	Statement mockstatement;

	@Mock
	Connection connect;

	@InjectMocks
	DB custInput = mock(DB.class);

	@BeforeClass
	public static void connect() throws SQLException {
		conn = DriverManager.getConnection(DBConfig.URL, DBConfig.USER, DBConfig.PASSWORD);
	}

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void custCreateTest() throws SQLException {

		when(connect.createStatement()).thenReturn(mockstatement);

		int CID = 30;
		String first_name = "Billy";
		String last_name = "Bob";
		String email = "BB@test";
		int age = 20;

		custInput.custCreate(CID, first_name, last_name, email, age);

		String expectedSql = "INSERT INTO customer (CID, first_name, last_name, adresss, postcode, city) VALUES (\""
				+ CID + "\", \"" + first_name + "\", \"" + last_name + "\", \"" + email + "\", \"" + age + "\")";
		verify(mockstatement).executeUpdate(expectedSql);

	}

}