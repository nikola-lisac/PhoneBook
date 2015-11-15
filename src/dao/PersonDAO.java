package dao;
import java.util.List;

import beans.Person;

/**
 * Dao inteface
 * @author Nikola
 *
 */
public interface PersonDAO {
	
	// search database by firstName, lastName or city
	List<Person> searchByNameLastNameOrCity(String keyword);
	
	// get the whole list of people in the database
	List<Person> getAllPeople();
			
	// adding person to the phonebook database
	void addPersonToPhonebook(Person p);
	
	// editting the person in the database
	void editPersonFromPhonebook(Person p);
	
	// deleting the person from the database
	void deletePersonFromDatabase(String userID);
	
	// getting a person from database
	Person getPerson(String userID);
	
}
