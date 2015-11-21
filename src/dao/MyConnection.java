package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MyConnection {
	// connection username
	private static final String USERNAME = "root";
	// connection password
	private static final String PASSWORD = "nikola";

	/**
	 * Method for connecting to the specified database
	 * 
	 * @return connection with the database
	 * @author Nikola Lisièiæ
	 * @throws SQLException
	 * 
	 */
	public static Connection connectToDb() {
		Connection connection = null;
		try {
			// mySQl driver
			Class.forName("com.mysql.jdbc.Driver");
			// connection with the database
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/phonebook", USERNAME, PASSWORD);

		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		
		return connection;
	}
}
