package servlets;

import java.io.IOException;

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
public class AjaxUsernameCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// username to check
		String username = request.getParameter("username");
		UserDatabaseService uds = new UserDatabaseService();
		String resp = "";
		// if username is available, set response to true
		if(uds.isUsernameAvailable(username)){
			resp = "true";
		}
		else {
			resp = "false";
		}

		response.setContentType("text/html");
		response.getWriter().write(resp);

	}

}
