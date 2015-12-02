package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	// connection username
	private static final String USERNAME = "root";
	// connection password
	private static final String PASSWORD = "nikola";

	private static final String CONN_STRING = "jdbc:mysql://localhost:3306/phonebook";

	/**
	 * Method for connecting to the specified database
	 * @return connection with the database
	 */
	public static Connection connectToDb() {
		Connection connection = null;
		try {
			// mySQl driverS
			Class.forName("com.mysql.jdbc.Driver");
			// connection with the database
			connection = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);

		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}

		return connection;
	}
}
