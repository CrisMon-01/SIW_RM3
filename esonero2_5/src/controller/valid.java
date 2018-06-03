package controller;

import javax.servlet.http.HttpServletRequest;

public class valid {

	public boolean isv(HttpServletRequest req) {
		boolean returned=true;
		String n = req.getParameter("nome");
		String c = req.getParameter("cod");
		if(n==""||n==null) {
			req.setAttribute("errnome", "errore sul nome");
			returned=false;
		}
		if(c==null||c=="") {
			returned=false;
			req.setAttribute("errcod", "codice non eisstente");
		}
		else {
			try {
				new Integer(c.trim());
			}
			catch (Exception e) {
				returned=false;
				req.setAttribute("errcod", "codice non numerico");
			}
		}
		
		
		return returned;
	}
	
}
