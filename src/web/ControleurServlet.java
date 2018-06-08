package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.CreditMetier;

/**
 * Servlet implementation class ControlerServlet
 */
@WebServlet(name="cs", 
			urlPatterns= {"/controleur","*.php"})
public class ControleurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private CreditMetier metier;
	
	@Override
	public void init() throws ServletException {
		metier = new CreditMetier();	// Controleur instancié et la methode init s'execute
	}
	
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("mod", new CreditModel());
		request.getRequestDispatcher("VueCredit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		double montant=Double.parseDouble(request.getParameter("montant"));
		double taux=Double.parseDouble(request.getParameter("taux"));
		int duree=Integer.parseInt(request.getParameter("duree"));
		
		CreditModel model = new CreditModel();
		model.setMontant(montant);
		model.setTaux(taux);
		model.setDuree(duree);
		
		double res = metier.calculMensualite(montant, duree, taux);
		
		model.setMensualite(res);
		
		request.setAttribute("mod", model);
		request.getRequestDispatcher("VueCredit.jsp").forward(request, response);
		
	}

}
