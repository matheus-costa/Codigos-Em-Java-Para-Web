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
@WebServlet("/calcularDobro")
public class TesteRedirecionamentoServet  extends HttpServlet {
	
			protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
				String numeroTxt = request.getParameter("numero");							
				int numero = Integer.parseInt(numeroTxt);
					
				response.setContentType("text/html");
				PrintWriter saida = response.getWriter();
				
			     saida.print("O dobro do número informado é o:"+(2*numero));		
					

	           if(numero > 10 ) {
		        response.sendRedirect("tabuada?numero=11");
	            }
	             saida.close();
		     	}
}
