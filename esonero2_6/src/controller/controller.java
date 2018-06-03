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

import model.libro;

@WebServlet("/processa")
public class controller extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String codice = req.getParameter("codice");
		HttpSession s = req.getSession();
		Validatore v = new Validatore();
		s.setAttribute("nome", nome);
		s.setAttribute("codice", codice);
		String nextpage;
		if(v.isvalid(req)) {
			libro l = new libro();
			l.setNome(nome.trim().toUpperCase());
			l.setCodice(new Integer(codice.trim()));
			s.setAttribute("libro", l);
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
