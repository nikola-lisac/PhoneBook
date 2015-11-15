package dao;

import java.util.List;

import beans.User;

public interface UserDAO {

	User validate(String username, String password);
	
	void register(User u);
	
	List<String> getAllUsernames();
	
}
