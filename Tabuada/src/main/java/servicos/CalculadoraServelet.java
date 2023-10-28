package servicos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculadoraServelet
 */
@WebServlet("/calculadora")
public class CalculadoraServelet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String numero1Txt = request.getParameter("numero1");
		String numero2Txt = request.getParameter("numero2");
		
		int numero1 = Integer.parseInt(numero1Txt);
		int numero2 = Integer.parseInt(numero2Txt);
		
		int soma = numero1 + numero2;

		response.setContentType("text/html");
		PrintWriter saidaHTML = response.getWriter();
		
		saidaHTML.println("Soma:");
		saidaHTML.println("<br/>");
		saidaHTML.println(soma);
			
		
	
	}
}