package dipendenti;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		//int giorno = 0;
		String giorno = "";
		int orario = 0;
		
		ConnessDB day = new ConnessDB();
		
		for(int i=0; i<28; i++) {
//			String giorno = request.getParameter("giorno"+i);
//			String orario = request.getParameter("orario"+i);
			try {	
				giorno = request.getParameter("giorno"+i);
				orario = Integer.parseInt(request.getParameter("orario"+i));
				System.out.println(giorno + " " + orario);
			if(orario == 0) {
			//if((giorno == null) && (orario == 0)) {
				continue;
			} else {		
					day.insertDb(giorno, orario);
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
