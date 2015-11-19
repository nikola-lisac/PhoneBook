package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDatabaseService;

/**
 * Servlet implementation class ajaxUsernameCheck
 */
@WebServlet("/usernameCheck")
public class ajaxUsernameCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("pozvalo je servlet");
		String username = request.getParameter("username");
		UserDatabaseService uds = new UserDatabaseService();
		List<String> listOfUsernames = uds.getAllUsernames();
		boolean isAvailable = true;
		for (String uname : listOfUsernames) {
			System.out.println(uname);
		}
		for (String uname : listOfUsernames) {
			if (uname.equals(username)) {
				isAvailable = false;
				break;
			}
		}
		String resp = "";
		if (isAvailable) {
			resp="true";
			//resp = "Username is available.";
		} else {
			//resp = "Username is not available.";
			resp="false";
		}
		response.setContentType("text/html");
		response.getWriter().write(resp);

	}

}
