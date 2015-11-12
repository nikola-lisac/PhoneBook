package stuff;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MyConnection {
	// connection username
	private static final String USERNAME = "root";
	// connection password
	private static final String PASSWORD = "nikola";
	// name of the database
	private static final String DB = "phonebook";

	/**
	 * Method for connecting to the specified database
	 * 
	 * @return connection with the database
	 * @author Nikola Lisièiæ
	 * @throws SQLException
	 * 
	 */
	public static Connection connectToDb() throws SQLException {
		Connection connection = null;
		try {
			// mySQl driver
			Class.forName("com.mysql.jdbc.Driver");
			// connection with the database
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/" + DB, USERNAME, PASSWORD);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
