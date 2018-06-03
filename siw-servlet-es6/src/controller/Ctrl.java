package controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class Ctrl {

	public boolean valida(HttpServletRequest req) {
		boolean ret = true;
		try{Integer i = new Integer(req.getParameter("codice").trim());
		}
		catch (Exception e) {
			// TODO: handle exception
			req.setAttribute("errcod", "codice non numerico");
			ret = false;
		}
		if(req.getParameter("nome")=="") {
			req.setAttribute("errnome", "errore sul nome");
			ret = false;
		}
		if(req.getParameter("codice")=="") {
			req.setAttribute("errcod", "non inserito codice id");
			ret = false;
		}
		return ret;
	}
}
