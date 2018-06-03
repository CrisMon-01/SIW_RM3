package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

@WebServlet("/azzione")
public class classe extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String address = (String)req.getRemoteAddr();
		String host = (String)req.getRemoteHost();
		String userAgent = (String)req.getHeader("User-Agent");
		
		String nome = req.getParameter("nome");
		String cognome = req.getParameter("cognome");
		resp.setContentType("text/html"); 	//la rispo è un file html
		PrintWriter out = resp.getWriter();
		
		// scrivo il corpo
				out.println("<!DOCTYPE html>"); out.println("<html>");
				out.println("<head>");
				out.println("<meta charset=\"ISO-8859-1\" />");
				out.println("<title>mostra parametri</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h1>Dati inseriti nella form</h1>");
				out.println("<ul>");
				out.println("<li>Cognome: <b>"+cognome+"</b></li>");
				out.println("<li>Nome: <b>"+nome+"</b></li>");
				out.println("</ul>");
				out.println("<h1>Altri dati relativi alla richiesta</h1>");
				out.println("<br />IP: <b>"+address+"</b>");
				out.println("<br />Host: <b>"+host+"</b>");
				out.println("<br />User Agent: <b>"+userAgent+"</b>");
				out.println("</body>\n</html> ");
	}
	
}
