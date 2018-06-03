package roma3.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import roma3.classi.nomecodice;

@WebServlet("/invia")
public class controller extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nextpage;
		valid v = new valid();
		HttpSession s = req.getSession();
		String codice= req.getParameter("codice");
		
		s.setAttribute("nome", req.getParameter("nome"));
		s.setAttribute("codice", codice);

		if(v.idValid(req)) {
			nomecodice nc = new nomecodice();
			nc.setCodice(new Double(codice.trim()));
			nc.setNome(req.getParameter("nome"));
			s.setAttribute("nc", nc);
			nextpage="confirm.jsp";
		}
		else {
			nextpage="form.jsp";
		}
		
		
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/"+nextpage);
		rd.forward(req, resp);
	
	}
}
