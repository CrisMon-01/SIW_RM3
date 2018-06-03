package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classe.persona;

@WebServlet("/inserisci")
public class personctrl extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nome = req.getParameter("nome");
		String matricola = req.getParameter("codice");
		String nextpage;
		Ctrl controller = new Ctrl();
		if(controller.valida(req)) {
			nextpage="/okey.jsp";
			persona p = new persona();
			p.setCodice(new Integer(matricola.trim()));
			p.setNome(nome.toUpperCase().trim());
			req.setAttribute("persona", p);
		}
		else 
			nextpage="/inseriscistud.jsp";
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(nextpage);
		rd.forward(req, resp);
	}
}
