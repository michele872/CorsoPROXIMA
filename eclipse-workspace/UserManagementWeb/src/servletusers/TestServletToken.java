package servletusers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.db.UserDBManager;
import org.db.UserLoginTokenDBManager;
import org.entities.User;
import org.entities.UserLoginToken;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServletToken")
public class TestServletToken extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServletToken() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private final static Logger logger = Logger.getLogger(TestServletToken.class);
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			logger.warn("DEBUG 1");
		
        response.setContentType("text/html;charset=UTF-8");
		
		String email = request.getParameter("nomeutente");
		
		logger.warn("EMAIL = " + email);
		
		User u = UserDBManager.getUserByEmail(email);
		
		logger.warn("UTENTE = " + u);

		String em = u.getEmail();
		
		logger.warn("VARIABILE em = " + em);
		
		
		if (em.equals(null)) {
			
		    throw new NullPointerException();
			
		} else {
			logger.warn("SEI NELL'ELSE");
//			UserLoginTokenDBManager.setTokenDataUser(email);
			
            response.sendRedirect("token.jsp");
        }
		
		} catch (NullPointerException e) {
			
			response.sendRedirect("ko.html");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

}
