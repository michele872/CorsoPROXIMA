package dipendenti;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.entities.Spendtime;

import com.google.gson.Gson;

import db.HibernateConnection;
import db.HibernateDBManager;
import utility.CurrentDate;

/**
 * Servlet implementation class FormOrari
 */
@WebServlet("/FormOrari")
public class FormOrari extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(HibernateConnection.class);
       
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
		Spendtime sp = new Spendtime();
		List<Spendtime> lista = HibernateDBManager.selectSp();
		int userID = 0;
		String giorno = " ";
		int ora = 0;
		int max = Integer.parseInt(CurrentDate.giornoCorrente());
		
		if(lista.isEmpty()) {
			for(int i=0; i< max ; i++) {
				System.out.println("SONO NEL PRIMO IF");
				logger.debug("CAZZO NON VA??");
				
				userID = 0;
				giorno = (i+1)+"-"+CurrentDate.dataCorrente();
				logger.debug(giorno);
				ora = 0;
				
				sp.setUserID(userID);
				sp.setData(giorno);
				sp.setOra(ora);
				lista.add(sp);
				HibernateDBManager.insertSt(userID, giorno, ora);
			}
		} else {
			// vado a leggere la lista dalla jsp (AJAX)
			BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
			String json = "";
			if(br != null) {
				json = br.readLine();
			}
//			System.out.println(json);

			if(json != null && !json.isEmpty()) {
				Gson gson = new Gson();

				// PRENDO LA LISTA MODIFICATA DAL WEB.
				lista = Arrays.asList(gson.fromJson(json , Spendtime[].class));
//				System.out.println(Arrays.toString(lista.toArray()));
				for(Spendtime s : lista) {
					HibernateDBManager.updateOra(s.getUserID(), s.getData(), s.getOra());
				}
				
			}
		}
		
		lista = HibernateDBManager.selectSp();
	

				Gson gson = new Gson();
				gson.toJson(lista);
				//System.out.println(gson.toJson(lista));
				response.getWriter().append(gson.toJson(lista));
				
//			} catch(Exception e) {
//				e.printStackTrace();
//			}
			
			
		}

		
		
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
