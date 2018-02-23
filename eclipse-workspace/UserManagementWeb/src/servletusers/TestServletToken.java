package servletusers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.db.UserLoginTokenDBManager;

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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        response.setContentType("text/html;charset=UTF-8");
		
		String email = request.getParameter("nomeutente");
        
        if(ValidateToken.checkUser(email))
        {
            
            try {
				UserLoginTokenDBManager.setTokenDataUser(email);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            RequestDispatcher rs = request.getRequestDispatcher("token.jsp");
            rs.forward(request, response);
        }
        else
        {
            RequestDispatcher rs = request.getRequestDispatcher("ko.html");
            rs.forward(request, response);
        }
        
	}

}
