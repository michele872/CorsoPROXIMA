package Utenti;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DBConnection
 */
@WebServlet("/DBConnection")
public class DBConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBConnection() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
//		DBConnectionClass db = new DBConnectionClass(request.getParameter("username"), request.getParameter("password"));
//		
//		try {
//			db.login();
//		} catch (ClassNotFoundException e1) {
//			e1.printStackTrace();
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		}
		
		String controllaMail = request.getParameter("username");
		String controllaPssw = request.getParameter("password");
		
		ConnessDB cdb = new ConnessDB();
		
		try {
			for(EmailPassword e : cdb.emailPassword()) {
				if (controllaMail.equals(e.mail) && controllaPssw.equals(e.password)) {
					String destination = "/ok.html";
					RequestDispatcher rDispatcher = getServletContext().getRequestDispatcher(destination);
					rDispatcher.forward(request, response);
					break;
				} 
			}
			
				String destination = "/ko.html";
				RequestDispatcher rDispatcher = getServletContext().getRequestDispatcher(destination);
				rDispatcher.forward(request, response);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
//		try {
//			for(String s : cdb.getEmail()) {				// Creo un for per scorrermi i singoli elementi dell'arraylist
//				if (controllaMail.equals(s)) {
//					
//					String destination = "/ok.html";
//					RequestDispatcher rDispatcher = getServletContext().getRequestDispatcher(destination);
//					rDispatcher.forward(request, response);
//				} else {
//					String destination = "/ko.html";
//					RequestDispatcher rDispatcher = getServletContext().getRequestDispatcher(destination);
//					rDispatcher.forward(request, response);
//				}
//			}
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
		
//		try {
//			if(db.login()) {
//				String destination = "/ok.html";
//				RequestDispatcher rDispatcher = getServletContext().getRequestDispatcher(destination);
//				rDispatcher.forward(request, response);
//			} else {
//				String destination = "/ko.html";
//				RequestDispatcher rDispatcher = getServletContext().getRequestDispatcher(destination);
//				rDispatcher.forward(request, response);
//			}
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
