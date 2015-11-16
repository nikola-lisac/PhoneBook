package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Person;
import beans.User;
import dao.DatabaseService;
import dao.UserDatabaseService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserDatabaseService uds = new UserDatabaseService();
		User u = uds.validate(username, password); // find user in the database
													// with passed username and
													// password
		// if there isnt a user with that username/password
		if (u == null) {
			// set currentUser to null
			request.getSession().setAttribute("currentUser", null);
			// set the message to be displayed
			request.getSession().setAttribute("message", "Wrong username or password, try again!");
			response.sendRedirect("login.jsp");
		}
		// if there is a user in the database with that username and password
		else {
			// set user as current
			request.getSession().setAttribute("currentUser", u);

			if (u.getRole().equals("admin")) {
				DatabaseService ds = new DatabaseService();
				List<Person> peopleList = ds.getAllPeople(); // get list of people for the admin menu
				request.getSession().setAttribute("peopleList", peopleList);
			}
			response.sendRedirect("welcome.jsp");

		}

	}

}
