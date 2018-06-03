package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import esonero2_5.classi.libro;

@WebServlet("/proc")
public class controller extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nextpage="";
		HttpSession session = req.getSession();
		String nome= req.getParameter("nome");
		String codice = req.getParameter("cod");
		session.setAttribute("nome", nome);
		session.setAttribute("cod", codice);
		valid v = new valid();
		if(v.isv(req)) {
			libro l = new libro();
			l.setCodice(new Integer(codice.trim()));
			l.setNome(nome.trim());
			session.setAttribute("lib", l);
			nextpage="check.jsp";
		}
		else {
			nextpage="form.jsp";
		}
		
		
		
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/"+nextpage);
		rd.forward(req, resp);
	}
}
