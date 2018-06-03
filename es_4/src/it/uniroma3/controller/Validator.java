package it.uniroma3.controller;

import javax.servlet.http.HttpServletRequest;

public class Validator {

	boolean isvalido(HttpServletRequest req) {
		boolean ret = true;
		if(req.getParameter("nome")==null || req.getParameter("nome")== "") {
			req.setAttribute("errnome", "errore sul nome");
			ret = false;
		}
		if(req.getParameter("cognome")==null || req.getParameter("cognome")==""){
			req.setAttribute("errcognome", "errore sul cognome");
			ret = false;
	}
			return ret;
	}
	
}
