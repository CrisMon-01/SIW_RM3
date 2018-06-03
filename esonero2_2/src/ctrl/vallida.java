package ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class vallida {

	public boolean isv(HttpServletRequest req) {
		boolean ret = true;		
		String c1 = req.getParameter("cu");
		String c2 = req.getParameter("cd");		
		
		if(c1==""||c1==null) {
			req.setAttribute("errc1", "errore campo uno");
			ret = false;
		}
		if(c2==""||c2==null) {
			req.setAttribute("errc2", "inesistente campo due");
			ret=false;
		}
		else {
		try {
			new Integer(c2.trim());
		}
		catch (Exception e) {
			req.setAttribute("errc2", "campo2 non numerico");
			ret = false;
		}	
		}
		return ret;
	}
	
}
