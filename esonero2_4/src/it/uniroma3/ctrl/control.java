package it.uniroma3.ctrl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.uniroma3.classi.nc;

@WebServlet("/processa")
public class control extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nextpage = "";
		HttpSession session = req.getSession();
		String nome = req.getParameter("nome");
		String codice = req.getParameter("cod");
		Validant v = new Validant();
		
		session.setAttribute("nome", nome);
		session.setAttribute("cod", codice);
		
		if(v.isvalid(req)) {
			nc nc = new nc();
			nc.setCodice(new Integer(codice.trim()));
			nc.setNome(nome);
			session.setAttribute("obj", nc);
			nextpage="check.jsp";
		}
		else 
			nextpage="form.jsp";
		
		ServletContext sc = getServletContext();
		RequestDispatcher rd =sc.getRequestDispatcher("/"+nextpage);
		rd.forward(req, resp);
	
	}

}
