package it.uniroma3.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.uniroma3.model.Studente;

@WebServlet("/invia")
public class studenteController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		String nome = req.getParameter("nome");
		String cognome = req.getParameter("cognome");
		String matricola = req.getParameter("matricola");
		Studente s = new Studente();
		String nextpage;
		HttpSession session = req.getSession();
		
		studenteValidator validator = new studenteValidator();
		
		session.setAttribute("nome", nome);
		session.setAttribute("cognome", cognome);
		session.setAttribute("matricola", matricola);
		
		if(!validator.validator(req)) {
			s.setNome(nome.trim().toUpperCase());
			s.setCognome(cognome.trim().toUpperCase());	
			s.setMatricola(new Integer(matricola));
			session.setAttribute("studente",s);
			nextpage = "/affermativo.jsp";
		}
		else {			
			nextpage="/newstudente.jsp";
		}

		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(nextpage);
		rd.forward(req, resp);
		return;
	}

}
