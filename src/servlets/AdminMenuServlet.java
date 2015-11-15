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
		
		// if selected option is "delete" delete person with id personID from database
		if(action.equals("delete")){
			ds.deletePersonFromDatabase(personID); // deleting the person
			List<Person> peopleList = ds.getAllPeople(); // getting new list of people after deleting
			request.getSession().setAttribute("peopleList", peopleList); // setting new list of people as personList
			request.getSession().setAttribute("message", "Person has been deleted."); // setting a message to be displayed
			response.sendRedirect("welcome.jsp");
		}
		else { // if "edit" is selected, redirect to edit.jsp and show all current data for that user
			Person person = ds.getPerson(personID);
			request.getSession().setAttribute("personToEdit",person);
			response.sendRedirect("edit.jsp");
		}
	}
}
