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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("passwordConfirm");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String role = "user";
		Validation valid = new Validation();
		UserDatabaseService udbs = new UserDatabaseService();
	
		if (udbs.isUsernameAvailable(username) && password.equals(confirmPassword) && valid.areLettersAndDigits(password)
				&& valid.areLettersAndDigits(username) && valid.areLetters(firstName) && valid.areLetters(lastName)
				&& valid.isValidEmail(email)) {
			User user = new User(username,password,firstName,lastName,email,role);
			udbs.register(user);
			request.getSession().setAttribute("message", "You have successfully registered on PhoneBook!");
			response.sendRedirect("login.jsp");
		} else {
			request.getSession().setAttribute("message", "Username is unavailable or input isn't valid, try again!");
			response.sendRedirect("register.jsp");
		}
	}

}
