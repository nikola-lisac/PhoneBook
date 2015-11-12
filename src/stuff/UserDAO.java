package stuff;

import java.util.List;

public interface UserDAO {

	User validate(String username, String password);
	
	void register(User u);
	
	List<String> getAllUsernames();
	
}
