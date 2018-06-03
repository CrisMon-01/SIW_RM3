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

import it.uniroma3.classi.Persona;

@WebServlet("/invia")
public class controller extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String cognome = req.getParameter("cognome");
		HttpSession session = req.getSession();
		session.setAttribute("nome", nome);
		session.setAttribute("cognome", cognome);
		String nextpage;
		
		Validator v = new Validator();
		if(v.isvalido(req)) {
			nextpage = "affermativo.jsp";
			Persona p = new Persona();
			p.setCognome(cognome.trim().toLowerCase());
			p.setNome(nome.trim().toLowerCase());
			session.setAttribute("persona", p);
		}
		else {
			nextpage="form.jsp";
//			session.setAttribute("nome", nome);
//			session.setAttribute("cognome", cognome);
		}
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/"+nextpage);
		rd.forward(req, resp);
	}
}
