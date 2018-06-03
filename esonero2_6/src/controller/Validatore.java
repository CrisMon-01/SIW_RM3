package controller;

import javax.servlet.http.HttpServletRequest;

public class Validatore {

	public boolean isvalid(HttpServletRequest req) {
		boolean returned = true;
		String n = req.getParameter("nome");
		if(n==""||n==null) {
			req.setAttribute("errnome", "errore nel nome");
			returned=false;
		}
		String cod = req.getParameter("codice");
		if(cod==""||cod==null) {
			returned=false;
			req.setAttribute("errcod", "errore NO CODICE");
		}
		else {
			try {
				new Integer(cod.trim());
			}
			catch (Exception e) {
				req.setAttribute("errcod", "codice NON NUMERICO");
				returned=false;
			}
		}				
		return returned;
	}
	
}
