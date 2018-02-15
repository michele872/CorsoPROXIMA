package dipendenti;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.SpendTimeDBManager;

/**
 * Servlet implementation class AfterHome
 */
@WebServlet("/AfterHome")
public class AfterHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfterHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//int id = 0;
		String giorno = "";
		String orario = "";
		int id = 0;
		
		SpendTimeDBManager day = new SpendTimeDBManager();
		
		for(int i=0; i<28; i++) {
			try {	
				id = 1;
				giorno = request.getParameter("giorno"+i);
				orario = request.getParameter("orario"+i);
				//orario = Integer.parseInt(request.getParameter("orario"+i));
//				System.out.println(giorno + " " + orario);
			if(orario == null) {
				continue;
			} else if (orario != null) {
					int ora = Integer.parseInt(orario);
					day.updateDb(giorno, ora);
					day.insertDb(id, giorno, ora);
			}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} 	
		
		}
		
		if(day.check == true) {
			String destination = "/ok.html";
			RequestDispatcher rDispatcher = getServletContext().getRequestDispatcher(destination);
			rDispatcher.forward(request, response);
		} else {
			String destination = "/ko.html";
			RequestDispatcher rDispatcher = getServletContext().getRequestDispatcher(destination);
			rDispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
