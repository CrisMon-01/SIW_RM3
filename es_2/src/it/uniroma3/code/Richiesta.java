package it.uniroma3.code;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/processa")
public class Richiesta extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nome = req.getParameter("nome");
		String cognome = req.getParameter("cognome");
		String matricola = req.getParameter("matricola");
		
		nome = nome.toUpperCase().trim();
		cognome=cognome.toUpperCase().trim();
		matricola = matricola.trim();
		
		req.setAttribute("nome", nome);
		req.setAttribute("cognome", cognome);
		req.setAttribute("matricola", matricola);
		
		ServletContext context = this.getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/mostra");
		rd.forward(req, resp);
		
		return;
	}

}
