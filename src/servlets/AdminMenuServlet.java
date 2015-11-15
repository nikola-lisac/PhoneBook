package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Person;
import dao.DatabaseService;

/**
 * Servlet implementation class DeleteUserServlet
 */
@WebServlet("/editdelete")
public class AdminMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String personID = request.getParameter("personID");
		String action = request.getParameter("action");
		DatabaseService ds = new DatabaseService();
		if(action.equals("delete")){
			ds.deletePersonFromDatabase(personID);
			List<Person> peopleList = ds.getAllPeople();
			request.getSession().setAttribute("peopleList", peopleList);
			request.getSession().setAttribute("message", "Person has been deleted.");
			response.sendRedirect("welcome.jsp");
	}
		else {
			Person person = ds.getPerson(personID);
			request.getSession().setAttribute("personToEdit",person);
			response.sendRedirect("edit.jsp");
		}
	}
}
