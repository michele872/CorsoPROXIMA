package servletusers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.db.UserDBManager;
import org.entities.User;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class UserModOk
 */
@WebServlet("/UserModOk")
public class UserModOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserModOk() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			
			
	    String idUser = request.getParameter("button2");
	    int id = Integer.parseInt(idUser);
	    System.out.println("sei su id " + id);
	    User user = UserDBManager.getUserById(id);
	    String email = request.getParameter("email");
		System.out.println(email);
		String password = request.getParameter("password");
		System.out.println(password);
		String firstName = request.getParameter("firstname");
		System.out.println(firstName);

		String lastName = request.getParameter("lastname");
		System.out.println(lastName);

		String bornDate = request.getParameter("borndate");
		System.out.println(bornDate);
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(bornDate);
		
		System.out.println(id+email+password+firstName+lastName+date);
		
		
        UserDBManager.updateUserById(id, email, password, firstName, lastName, date);
        Gson gson = new GsonBuilder().create();
        String usersJ = gson.toJson(user);
		response.getWriter().append(usersJ);
        System.out.println("modifiche effettuate");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
