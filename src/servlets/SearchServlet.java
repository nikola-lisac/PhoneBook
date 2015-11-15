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
 * Servlet implementation class SearchServlet
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		Validation valid = new Validation();
		if (valid.areLettersAndSpaces(keyword)) {
			// convert keyword to titlecase(first letter of the word is
			// uppercase)
			String formatKeyword = valid.toTitleCase(keyword);
			// String searchBy = request.getParameter("searchOption");
			DatabaseService service = new DatabaseService();
			// search database columns firstName, lastName and city by keyword
			List<Person> resultList = service.searchByNameLastNameOrCity(formatKeyword);

			request.getSession().setAttribute("listOfPeople", resultList);
			response.sendRedirect("results.jsp");
		} else {
			// if validation failed set message and redirect to homepage
			request.getSession().setAttribute("message", "Enter only letters and spaces in the search box.");
			response.sendRedirect("welcome.jsp");
		}
	}

}
