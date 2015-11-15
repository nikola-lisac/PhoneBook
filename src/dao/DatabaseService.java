package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Person;

/**
 * Class for searching the database It includes methods for searching with
 * certain keyword which is supposed to match values in certain fields
 * 
 * @author Nikola
 *
 */
public class DatabaseService implements PersonDAO {
	public List<Person> listOfPeople;

	public DatabaseService() {
		this.listOfPeople = new ArrayList<Person>();
	}

	/**
	 * Search database for fields where first name, lastName or city is keyword,
	 * create Person objects for matching criteria and add those objects to the
	 * list
	 * 
	 * @param name
	 *            keyword to search the fields in the database
	 * @return list of People objects whoose field firstName, lastName or city
	 *         is equal to the keyword
	 */
	@Override
	public List<Person> searchByNameLastNameOrCity(String keyword) {
		String sqlQuery = "SELECT * FROM person WHERE firstName=? OR lastName=? OR city=?";
		try (Connection connection = MyConnection.connectToDb();
				PreparedStatement stmnt = connection.prepareStatement(sqlQuery)) {

			stmnt.setString(1, keyword);
			stmnt.setString(2, keyword);
			stmnt.setString(3, keyword);
			try (ResultSet rs = stmnt.executeQuery()) {
				while (rs.next()) {
					Person person = new Person();
					person.setFirstName(rs.getString(1));
					person.setLastName(rs.getString(2));
					person.setGender(rs.getString(3));
					person.setAddress(rs.getString(4));
					person.setCity(rs.getString(5));
					person.setPhone(rs.getString(6));
					person.setEmail(rs.getString(7));
					person.setId(rs.getString(8));
					this.listOfPeople.add(person);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listOfPeople;
	}


	/**
	 * Adding a person to the database
	 */
	@Override
	public void addPersonToPhonebook(Person p) {
		String sqlQuery = "INSERT INTO person(firstName,lastName,gender,address,city,phone,email) VALUES (?,?,?,?,?,?,?)";
		try (Connection connection = MyConnection.connectToDb();
				PreparedStatement stmnt = connection.prepareStatement(sqlQuery)) {
			stmnt.setString(1, p.getFirstName());
			stmnt.setString(2, p.getLastName());
			stmnt.setString(3, p.getGender());
			stmnt.setString(4, p.getAddress());
			stmnt.setString(5, p.getCity());
			stmnt.setString(6, p.getPhone());
			stmnt.setString(7, p.getEmail());

			stmnt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gett all the people from db and put them as Person instances in the list
	 */
	@Override
	public List<Person> getAllPeople() {
		String sqlQuery = "SELECT * FROM person";
		try (Connection connection = MyConnection.connectToDb();
				PreparedStatement stmnt = connection.prepareStatement(sqlQuery);
				ResultSet rs = stmnt.executeQuery()) {

			while (rs.next()) {
				Person person = new Person();
				person.setFirstName(rs.getString(1));
				person.setLastName(rs.getString(2));
				person.setGender(rs.getString(3));
				person.setAddress(rs.getString(4));
				person.setCity(rs.getString(5));
				person.setPhone(rs.getString(6));
				person.setEmail(rs.getString(7));
				person.setId(rs.getString(8));

				this.listOfPeople.add(person);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listOfPeople;
	}

	@Override
	public void editPersonFromPhonebook(Person p) {
		String sqlQuery = "UPDATE person SET firstName=?,lastName=?,gender=?,address=?,city=?,phone=?,email=? WHERE id=?";
		try (Connection connection = MyConnection.connectToDb();
				PreparedStatement stmnt = connection.prepareStatement(sqlQuery)) {
			stmnt.setString(1, p.getFirstName());
			stmnt.setString(2, p.getLastName());
			stmnt.setString(3, p.getGender());
			stmnt.setString(4, p.getAddress());
			stmnt.setString(5, p.getCity());
			stmnt.setString(6, p.getPhone());
			stmnt.setString(7, p.getEmail());
			stmnt.setString(8, p.getId());

			stmnt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Delete person from the database
	 */
	@Override
	public void deletePersonFromDatabase(String userID) {
		String sqlQuery = "DELETE FROM person WHERE id=?";
		try (Connection connection = MyConnection.connectToDb();
				PreparedStatement stmnt = connection.prepareStatement(sqlQuery)) {

			stmnt.setString(1, userID);
			stmnt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Person getPerson(String userID) {
		String sqlQuery = "SELECT * FROM person WHERE id=?";
		Person person = null;
		try (Connection connection = MyConnection.connectToDb();
				PreparedStatement stmnt = connection.prepareStatement(sqlQuery)) {
			stmnt.setString(1, userID);
			try (ResultSet rs = stmnt.executeQuery()) {
				while (rs.next()) {
					person = new Person();
					person.setFirstName(rs.getString(1));
					person.setLastName(rs.getString(2));
					person.setGender(rs.getString(3));
					person.setAddress(rs.getString(4));
					person.setCity(rs.getString(5));
					person.setPhone(rs.getString(6));
					person.setEmail(rs.getString(7));
					person.setId(rs.getString(8));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return person;
	}

}
