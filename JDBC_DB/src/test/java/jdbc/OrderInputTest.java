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
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class OrderInputTest {

	public static Connection conn;
	public static Statement stmnt;

	@Mock
	Statement mockstatement;

	@Mock
	Connection connect;

	@Mock
	DB ordrInput = mock(DB.class);

	@BeforeClass
	public static void connect() throws SQLException {
		conn = DriverManager.getConnection(DBConfig.URL, DBConfig.USER, DBConfig.PASSWORD);
	}

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void ordrCreateTest() throws SQLException {

		when(connect.createStatement()).thenReturn(mockstatement);

		int OID = 30;
		int CID = 30;
		int quantity = 3;
		int PID = 2;

		ordrInput.ordrCreate(OID, CID, quantity, PID);

		String testSql = "INSERT INTO Orders (OID, CID, PID, quantity) VALUES (" + OID + ", \"" + CID + "\", \""
				+ quantity + "\", \"" + PID + "\")";
		verify(mockstatement).executeUpdate(testSql);

	}
}