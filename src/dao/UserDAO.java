package dao;

import java.util.List;

import beans.User;
/**
 * Interface with methods which have to communicate with table "user" in the database
 * @author Nikola
 *
 */
public interface UserDAO {

	User validate(String username, String password);
	
	void register(User u);
	
	List<String> getAllUsernames();
	
}
