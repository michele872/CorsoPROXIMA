package dipendenti;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.proxima.spendtime.db.HibernateDBManager;
import org.proxima.spendtime.entities.SpendTimeTip;

import com.google.gson.Gson;

/**
 * Servlet implementation class SpendTimeTipsSelect
 */
@WebServlet("/SpendTimeTipsSelect")
public class SpendTimeTipsSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpendTimeTipsSelect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<SpendTimeTip> lista = HibernateDBManager.selectStt();

		if(lista!= null) {
			Gson g = new Gson();
			String spendTips= g.toJson(lista);
			System.out.println(spendTips);
			response.getWriter().append(spendTips);
		} else {
			System.out.println("null");
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
