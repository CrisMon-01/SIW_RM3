package it.uniroma3.ctrl;

import javax.servlet.http.HttpServletRequest;

public class Validant {

	boolean isvalid(HttpServletRequest req) {
		boolean ret=true;
		if(req.getParameter("nome")==""||req.getParameter("nome")==null) {
			ret = false;
			req.setAttribute("errnome", "errore sul nome");
		}
		if(req.getParameter("cod")==""||req.getParameter("cod")==null) {
			ret = false;
			req.setAttribute("errcod", "errore codice non esistente");
		}
		else {
			try {
				new Integer(req.getParameter("cod").trim());
			}
			catch (Exception e) {
				ret = false;
				req.setAttribute("errcod", "codice non numerico");
			}
		}
		
		return ret;
	}
}
