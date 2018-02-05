package chat;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.MessagesRequest;

@WebServlet("/read")
public class read extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public read() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		new ThreadClientRead(new MessagesRequest()).start();
		
		
	}


}
