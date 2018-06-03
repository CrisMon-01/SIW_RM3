package it.uniroma3.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.uniroma3.model.Studente;
import it.uniroma3.services.StudenteServices;

@WebServlet("/conferma")
public class StudenteConfermaController extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	//se schiaccio link uso GET
		HttpSession sessione = req.getSession();
		Studente stud = (Studente) req.getAttribute("studente");
		
		StudenteServices service = new StudenteServices();
		service.save(stud);
		
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/affermativo.jsp");
		rd.forward(req, resp);
		return;
	}

}
