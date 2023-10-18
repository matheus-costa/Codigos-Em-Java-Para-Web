package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServeletNomeSobrenome
 */
@WebServlet("/ServeletNomeSobrenome")
public class ServeletNomeSobrenome extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		System.out.println("nome do cliente:"+nome);
		String sobrenome = request.getParameter("sobrenome");
		System.out.println("sobrenome:"+sobrenome);
		
		response.setContentType("text/html");
		PrintWriter htmlSaida = response.getWriter();
		htmlSaida.print(nome+" "+ sobrenome);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Index.jsp");
		dispatcher.forward(request, response);
	
	}
}