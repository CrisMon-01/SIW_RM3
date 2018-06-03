package it.uniroma3.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma3.model.Studente;
import it.uniroma3.services.StudenteServices;

@WebServlet("/lista")
public class ListaStudentiController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nextpage="/mostraLista.jsp";		//scelta vista
		StudenteServices service=new StudenteServices();
		Collection<Studente> list =(Collection<Studente>)service.listaStudenti();
		req.setAttribute("listastudenti", list);
		
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(nextpage);
		rd.forward(req, resp);
		return;
	}
}
