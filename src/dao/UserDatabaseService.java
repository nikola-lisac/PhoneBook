package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.User;

public class UserDatabaseService implements UserDAO{

	@Override
	public User validate(String username, String password) {
		User user = null;
		String sqlQuery = "SELECT * FROM user WHERE username=? && password=?";
		try (Connection connection = MyConnection.connectToDb();
				PreparedStatement stmnt = connection.prepareStatement(sqlQuery)) {

			stmnt.setString(1, username);
			stmnt.setString(2, password);
			try (ResultSet rs = stmnt.executeQuery()) {
				while (rs.next()) {
					user = new User();
					user.setUsername(rs.getString(1));
					user.setPassword(rs.getString(2));
					user.setFirstName(rs.getString(3));
					user.setLastName(rs.getString(4));
					user.setEmail(rs.getString(5));
					user.setRole(rs.getString(6));
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}
	
	@Override
	public void register(User u) {
		String sqlQuery = "INSERT INTO user(username,password,firstName,lastName,email) VALUES(?,?,?,?,?)";
		try (Connection connection = MyConnection.connectToDb();
				PreparedStatement stmnt = connection.prepareStatement(sqlQuery)) {

			stmnt.setString(1, u.getUsername());
			stmnt.setString(2, u.getPassword());
			stmnt.setString(3, u.getFirstName());
			stmnt.setString(4, u.getLastName());
			stmnt.setString(5, u.getEmail());
			
			stmnt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	
	}
	
	/**
	 * Get all usernames from the database
	 */
	@Override
	public List<String> getAllUsernames() {
		List<String> list = new ArrayList<>();
		String sqlQuery = "SELECT username FROM user";
		try (Connection connection = MyConnection.connectToDb();
				PreparedStatement stmnt = connection.prepareStatement(sqlQuery)) {

			try (ResultSet rs = stmnt.executeQuery()) {
				while (rs.next()) {
					String username = rs.getString(1);
					list.add(username);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * Check if username is available in the database or it's already taken
	 * @param username  username to check availability in the db
	 * @return  true if it is avalable, false if it's taken
	 */
	public boolean isUsernameAvailable(String username){
		List<String> list = this.getAllUsernames();
		boolean isAvailable = true;
		for(String usernameDB : list){
			if(username.equals(usernameDB)){
				isAvailable = false;
				break;
			}
		}
		return isAvailable;
	}

}
