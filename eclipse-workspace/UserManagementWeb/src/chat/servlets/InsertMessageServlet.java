package chat.servlets;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.proxima.chat.persistence.ChatMessagesDBManager;
//import org.proxima.chat.persistence.entities.ChatMessages;

/**
 * Servlet implementation class InsertMessageServlet
 */
@WebServlet("/InsertMessageServlet")
public class InsertMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
//		String textMessage = (String)request.getParameter("textMessage");
//		System.out.println("textMessage: " + textMessage);
//		ChatMessages mex = new ChatMessages () ;
//		mex.setTextMessage(textMessage);
//		mex.setUsername("maurizio");
//		mex.setSendTime(new Timestamp(System.currentTimeMillis()));
//		String returnValue = "" ;
//		try {
////		    ChatMessagesDBManager.insertChatMessagesHibernate(mex);
//		    ChatMessagesDBManager.insertChatMessages(mex);
//		    returnValue = "{\"code\":\"OK\"}" ;
//		
//		} catch (Exception e) {
//			e.printStackTrace();
//			returnValue = "{\"code\":\"KO\"}" ;
//		}
//		response.getWriter().append(returnValue);
	}

//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}