package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;
import dao.UserDatabaseService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get values from the form
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("passwordConfirm");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String role = "user";
		Validation valid = new Validation();
		UserDatabaseService udbs = new UserDatabaseService();
		// if all data is valid
		if (udbs.isUsernameAvailable(username) && password.equals(confirmPassword) && valid.areLettersAndDigits(password)
				&& valid.areLettersAndDigits(username) && valid.areLetters(firstName) && valid.areLetters(lastName)
				&& valid.isValidEmail(email)) {
			// create new user instance
			User user = new User(username,password,firstName,lastName,email,role);
			// register user in the database
			udbs.register(user);
			// set message
			request.getSession().setAttribute("message", "You have successfully registered on PhoneBook!");
			response.sendRedirect("login.jsp");
		} 
		// if input is invalid or username is taken, set message and redirect 
		else {
			request.getSession().setAttribute("message", "Username is unavailable or input isn't valid, try again!");
			response.sendRedirect("register.jsp");
		}
	}

}
