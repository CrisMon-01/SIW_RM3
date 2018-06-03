package it.uniroma3.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import it.uniroma3.model.Studente;

public class studenteValidator extends HttpServlet{

	public boolean validator(HttpServletRequest req) {
		String nome = req.getParameter("nome");
		String cognome = req.getParameter("cognome");
		String matricola = req.getParameter("matricola");
		Studente s = new Studente();
		boolean errore = false;		
		
		if(matricola==""||matricola==null) {
			errore=true;
			req.setAttribute("errmat", "errore sulla matricola");
		}
		else {
			try{
				Integer mat = new Integer( req.getParameter("matricola").trim());
				s.setMatricola(mat);
			}
			catch(Exception e) {
				errore=true;
				req.setAttribute("errmat", "errore deve essere un numero");
			}
		}
		String nextpage;

		if(nome == "" || nome == null) {
			errore=true;
			req.setAttribute("errnome", "errore sul nome");			
		}
		if(cognome == "" || cognome == null) {
			errore=true;
			req.setAttribute("errcognome", "errore sul cognome");			
		}
		return errore;
	}
	
}
