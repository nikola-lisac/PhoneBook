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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserDatabaseService uds = new UserDatabaseService();
		User u = uds.validate(username, password);
		if(u == null){
			request.getSession().setAttribute("currentUser", null);
			request.getSession().setAttribute("message","Wrong username or password, try again!");
			response.sendRedirect("login.jsp");
		} else {
			request.getSession().setAttribute("currentUser", u);
			DatabaseService ds = new DatabaseService();
			List<Person> peopleList = ds.getAllPeople();
			request.getSession().setAttribute("peopleList", peopleList);
			response.sendRedirect("welcome.jsp");
			
		}
		
	}

}
