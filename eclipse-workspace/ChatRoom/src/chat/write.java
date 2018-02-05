package chat;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/write")
public class write extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public write() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			new ThreadClientWrite(request.getParameter("username"), request.getParameter("message")).start();
			
			String destination = "/write.jsp";
			RequestDispatcher rDispatcher = getServletContext().getRequestDispatcher(destination);
			rDispatcher.forward(request, response);

		}
	}
