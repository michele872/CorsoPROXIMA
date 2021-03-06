package servletusers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.db.UserDBManager;
import org.entities.User;
import org.proxima.login.LoginManager;
import org.proxima.rest.bean.JSONResponseMessage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private final static Logger logger = Logger.getLogger(LoginServlet.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		logger.debug("email: " + email + " - password: " + password);
		int validationResult = LoginManager.validateUser(email, password);
		JSONResponseMessage jrm = new JSONResponseMessage () ;
		if (validationResult==LoginManager.USER_OK) {
			request.getSession().setAttribute("loggedUser", UserDBManager.getUserByEmail(email));
			jrm.setCode(JSONResponseMessage.OK);
			jrm.setMessage("Login effettuata con successo");
		} else if (validationResult==LoginManager.EMAIL_NOT_EXISTS) {
			jrm.setCode(JSONResponseMessage.KO);
			jrm.setMessage("L'utente non esiste");
		} else /*if (validationResult==LoginManager.PASSWORD_NOT_VALID)*/ {
			jrm.setCode(JSONResponseMessage.KO);
			jrm.setMessage("Password non corretta");
		}
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String loginServletResponse = gson.toJson(jrm);
		response.getWriter().append(loginServletResponse);
		System.out.println(loginServletResponse);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
