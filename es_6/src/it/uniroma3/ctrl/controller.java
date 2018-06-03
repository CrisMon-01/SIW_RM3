package it.uniroma3.ctrl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.uniroma3.classi.libro;

@WebServlet("/processa")
public class controller extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Valida v = new Valida();
		HttpSession session = req.getSession();
		String nextpage;
		String matricola = req.getParameter("codice");
		String nome = req.getParameter("nome");
		String autore = req.getParameter("autore");
		
		if(v.isvalido(req)) {
			nextpage="check.jsp";
			libro l = new libro();
			l.setAutore(autore);
			l.setCodice(new Integer(matricola.trim()));
			l.setNome(nome);
			session.setAttribute("lib", l);
		}
		else {
			nextpage="form.jsp";
			session.setAttribute("nome", nome);
			session.setAttribute("autore", autore);
			session.setAttribute("codice", matricola);
		}
		
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/"+nextpage);
		rd.forward(req, resp);
	}
	
		
}
