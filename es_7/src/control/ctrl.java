package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classi.classe;

@WebServlet("/processadati")
public class ctrl extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	classe c = new classe();
	String s = req.getParameter("stringa");
	String nextpage;
	
	if(s==""||s==null||s.length()<3) {
		req.setAttribute("errore", "commesso errore");
		nextpage="/ind.jsp";
	}
	else {
		c.setStr("okey");
		nextpage="/ok.jsp";
		req.setAttribute("classes", c);
	}
	
	ServletContext sc = getServletContext();
	RequestDispatcher rd = sc.getRequestDispatcher(nextpage);
	rd.forward(req, resp);	
	return;
	
	}
	
}
