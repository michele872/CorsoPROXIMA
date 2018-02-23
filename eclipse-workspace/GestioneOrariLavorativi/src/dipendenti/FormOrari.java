package dipendenti;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.util.Arrays;
import org.entities.Spendtime;

import com.google.gson.Gson;

import db.HibernateDBManager;

/**
 * Servlet implementation class FormOrari
 */
@WebServlet("/FormOrari")
public class FormOrari extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormOrari() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		List<Spendtime> lista = HibernateDBManager.selectSp();
		for (Spendtime s : lista) {
			System.out.println(s.getId());
		}
		Gson gson = new Gson();
		
		gson.toJson(lista);
		System.out.println(gson.toJson(lista));
		response.getWriter().append(gson.toJson(lista));
		System.out.println("ciaoooo");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
