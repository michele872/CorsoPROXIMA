package servletusers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bean.UserLoginToken;
import org.db.UserDBManager;
import org.db.UserLoginTokenDBManager;
import org.entities.User;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/ServletGeneratedToken")
public class ServletGeneratedToken extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGeneratedToken() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        response.setContentType("text/html;charset=UTF-8");
		
		String token = request.getParameter("token");
        
        if(ValidateGenerationTK.checkToken(token))
        {
        	
				UserLoginToken u = null;
				
				try {
					u = UserLoginTokenDBManager.getUserByToken(token);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

     		

        	HttpSession session = request.getSession();
        	session.setAttribute("loggedUser", u);
            
            RequestDispatcher rs = request.getRequestDispatcher("ok.html");
            rs.forward(request, response);
        }
        else
        {
            RequestDispatcher rs = request.getRequestDispatcher("expiredtoken.jsp");
            rs.forward(request, response);
        }
        
	}

}
