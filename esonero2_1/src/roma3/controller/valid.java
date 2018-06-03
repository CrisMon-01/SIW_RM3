package roma3.controller;

import javax.servlet.http.HttpServletRequest;

public class valid {

	public boolean idValid(HttpServletRequest req) {
		String nome = req.getParameter("nome");
		String codice = req.getParameter("codice");
		boolean ret = true;
		if(nome=="" || nome==null) {
			req.setAttribute("errnome", "errore sul nome");
			ret = false;
		}
		if(codice==""||codice==null) {
			req.setAttribute("errcodice", "codice non inserito");
			ret = false;
		}
		else {
			try {
				Double cod = new Double(codice.trim());				
			}
			catch (Exception e) {
				req.setAttribute("errcodice", "codice non numerico");
				ret = false;
			}
		}
		return ret;
	}
	
}
