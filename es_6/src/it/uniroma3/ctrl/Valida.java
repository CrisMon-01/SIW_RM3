package it.uniroma3.ctrl;

import javax.servlet.http.HttpServletRequest;

public class Valida {

	public boolean isvalido(HttpServletRequest req) {
		boolean ret = true;
		String s1 = req.getParameter("nome");
		String s2 = req.getParameter("autore");
		if(s1 == "" || s1 == null) {
			req.setAttribute("errnome", "errore sul nome");
			ret = false;
		}
		if(s2==""||s2==null) {
			req.setAttribute("erraut", "errore sull' autore");
			ret=false;
		}
		try {
			Integer i = new Integer(req.getParameter("codice").trim());
		}
		catch (Exception e) {
			req.setAttribute("errcod", "errore sul codice");
			ret = false;
		}
		return ret;
	}
}
