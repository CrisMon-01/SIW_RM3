package roma3.ctrl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import roma3.classe.classe;

@WebServlet("/elabora")
public class servlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nextpage="";
		HttpSession session = req.getSession();
		valid v = new valid();
		session.setAttribute("c1", req.getParameter("c1"));
		session.setAttribute("c2", req.getParameter("c2"));
		if(v.isvalid(req)) {
			nextpage="scegli.jsp";
			classe c = new classe();
			c.setC1(new Integer(req.getParameter("c1").trim()));
			c.setC2(req.getParameter("c2"));
			session.setAttribute("c", c);
		}
		else nextpage="form.jsp";
		
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/"+nextpage);
		rd.forward(req, resp);
	}
}
