package servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.db.UserDBManager;
import org.entities.User;
import org.proxima.rest.bean.JSONResponseMessage;

import com.google.gson.Gson;

/**
 * Servlet implementation class CheckEmail
 */
@WebServlet("/CheckEmail")
public class CheckEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckEmail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = request.getParameter("email");
		
		User u = UserDBManager.getUserByEmail(email);
		
		Gson gson = new Gson();
		JSONResponseMessage jrm = new JSONResponseMessage();
		HashMap < String, String > properties = new HashMap < String, String > ();
		String jsonInString = "";
		
		try {
						
			if(u==null) {
				
				jrm.setCode(JSONResponseMessage.OK);
				jrm.setMessage("Email inserita correttamente!");
				properties.put("cssColor", "green");
				jrm.setProperties(properties);
				jsonInString  = gson.toJson(jrm);
				
			}else {
				// email presente
				jrm.setCode(JSONResponseMessage.KO);
				jrm.setMessage("Email gia presente!");			
				properties.put("cssColor", "red");
				jrm.setProperties(properties);
				jsonInString = gson.toJson(jrm);
				
			}
			
			
		}
		
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();;
		}
		
		response.getWriter().append(jsonInString);
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
