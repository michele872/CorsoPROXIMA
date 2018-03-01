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
import org.hibernate.HibernateException;
import org.proxima.spendtime.db.HibernateDBManager;
import org.proxima.spendtime.entities.SpendTime;
import org.proxima.spendtime.spendtime.utils.CurrentDate;

import com.google.gson.Gson;


/**
 * Servlet implementation class FormOrari
 */
@WebServlet("/FormOrari")
public class FormOrari extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(HibernateException.class);
       
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
		SpendTime sp = new SpendTime();
		List<SpendTime> lista = HibernateDBManager.getAllSpendTimes();
		int userID = 0;
		String giorno = " ";
		int ora = 0;
		int type = 0;
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
				HibernateDBManager.insertSt(userID, giorno, ora, type);
			}
			
			for (SpendTime x : lista) {
				System.out.println(x.getData().substring(3, 9));
				if (x.getData().substring(3, 9) != CurrentDate.dataCorrente()) {
								
					for(int i=0; i< max ; i++) {
						logger.debug("SONO NEL PRIMO IF");
						logger.debug("CAZZO NON VA??");
						
						userID = 0;
						giorno = (i+1)+"-"+CurrentDate.dataCorrente();
						logger.debug(giorno);
						ora = 0;
						
						sp.setUserID(userID);
						sp.setData(giorno);
						sp.setOra(ora);
						lista.add(sp);
						HibernateDBManager.insertSt(userID, giorno, ora, type);
					}
					
				}
			}
		} else {
			// vado a leggere la lista dalla jsp (AJAX)
			BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
			String json = "";
			if(br != null) {
				json = br.readLine();
			}
//			System.out.println(json);
			
			int sizeLista = lista.size();
			int giornoAttuale = Integer.parseInt(CurrentDate.giornoCorrente());
			
			if(sizeLista < giornoAttuale) {
				for(int i=sizeLista; i<=giornoAttuale ; i++) {
					HibernateDBManager.insertSt(0, i+"-"+CurrentDate.dataCorrente(), 0, 0);
				}
			}
			
			if(json != null && !json.isEmpty()) {
				Gson gson = new Gson();

				// PRENDO LA LISTA MODIFICATA DAL WEB.
				lista = Arrays.asList(gson.fromJson(json , SpendTime[].class));
//				System.out.println(Arrays.toString(lista.toArray()));
				for(SpendTime s : lista) {
					HibernateDBManager.updateOra(s.getUserID(), s.getData(), s.getOra());
				}
				
			}
		}
		
		lista = HibernateDBManager.getAllSpendTimes();
	

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
