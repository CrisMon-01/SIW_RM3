package roma3.ctrl;

import javax.servlet.http.HttpServletRequest;

public class valid {

	public boolean isvalid(HttpServletRequest req) {
		boolean ret = true;
		String c1 = req.getParameter("c1").trim();
		String c2 = req.getParameter("c2");
		if(c1==""||c1==null) {
			req.setAttribute("errc1", "campo inesistente o vuoto");
			ret=false;
		}
		else {
			try {
				new Integer(c1);
			}
			catch (Exception e) {
				req.setAttribute("errc1", "non numero");
				ret = false;
			}
		}
		if(c2==""||c2==null) {
			req.setAttribute("errc2", "campo non valido");
			ret = false;
		}
		
		
		return ret;
	}
	
}
