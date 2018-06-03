package ctrl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classi.classe1;
@WebServlet("/send")
public class ctrler extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nextpage;
		HttpSession s = req.getSession();
		String c1 = req.getParameter("cu");
		String c2 = req.getParameter("cd");
		vallida v = new vallida();

		s.setAttribute("campou", c1);
		s.setAttribute("campod", c2);
		if(v.isv(req)) {
			classe1 c = new classe1();
			c.setC1(c1);
			c.setC2(new Integer(c2));
			s.setAttribute("c", c);
			nextpage="scelta.jsp";
		}
		else {
			nextpage="form.jsp";
		}
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/"+nextpage);
		rd.forward(req, resp);
	}
}
