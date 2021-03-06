package servletusers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.db.UserDBManager;
import org.entities.User;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private final static Logger logger = Logger.getLogger(TestServlet.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
		
		response.setContentType("text/html;charset=UTF-8");

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		logger.warn("EMAIL " + email);

		logger.warn("PASSWORD" + password);

		User u = UserDBManager.getUserByEmail(email);

		String em = u.getEmail();

		logger.warn("UTENTE" + em);

		String pw = u.getPassword();

		logger.warn("PASSWORD" + pw);

			if (em.equals(null)) {
		
		    throw new NullPointerException();
			
		}

			if (pw.equals(password)) {

				HttpSession session = request.getSession();
				session.setAttribute("loggedUser", u);

				response.sendRedirect("home.jsp");

			} else {

				response.sendRedirect("nopassword.jsp");

			}
			
		} catch (NullPointerException e) {

			response.sendRedirect("ko.html");

		}

	}
		
		

}
