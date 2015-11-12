package servlets;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stuff.Person;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/editPerson")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// getting input from the form
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String personID = request.getParameter("personID");

		Validation val = new Validation();
		/**
		 * check if all inputs are valid if they are, make a Person instance and
		 * add it to the database then redirect to homepage
		 */
		if (val.areLetters(firstName) && val.areLetters(lastName) && val.areLetters(gender)
				&& val.areLettersDigitsAndSpaces(address) && val.areLettersAndSpaces(city) && val.areDigits(phone)
				&& val.isValidEmail(email)) {
			
			Person person = new Person();
			person.setFirstName(firstName);
			person.setLastName(lastName);
			person.setGender(gender);
			person.setAddress(address);
			person.setCity(city);
			person.setPhone(phone);
			person.setEmail(email);
			person.setId(personID);

			DatabaseService data = new DatabaseService();
			data.editPersonFromPhonebook(person);
			request.getSession().setAttribute("message", "Person has been edited.");
			List<Person> peopleList = data.getAllPeople();
			request.getSession().setAttribute("peopleList", peopleList);
			response.sendRedirect("welcome.jsp");
		} else { // if one or more input fields are invalid, go to welcome
					// again
			response.sendRedirect("edit.jsp");
		}
		
	}

}
