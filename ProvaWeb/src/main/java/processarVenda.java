

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class venda
 */
@WebServlet("/processarVenda")
public class  processarVenda extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String preco1Txt = request.getParameter("preco1");
		String preco2Txt = request.getParameter("preco2");
		String preco3Txt = request.getParameter("preco3");

		float preco1 = Integer.parseInt(preco1Txt);
		float preco2 = Integer.parseInt(preco2Txt);
		float preco3 = Integer.parseInt(preco3Txt);
	
		String botaoCalularTotal = request.getParameter("botaoCalularTotal");
		response.setContentType("text/html");
		PrintWriter saidaHTML = response.getWriter();
		
		float soma;
		
		soma = preco1+preco2+preco3;
		
		saidaHTML.println("Produto 1:"+" "+"R$"+" "+preco1+" "+"/"+" "+"Produto 2:"+" "+"R$"+" "+preco2+"  "+"/"+"  "+"Produto 3:"+" "+"R$"+" "+preco3 );
		saidaHTML.println("<br/>");
		saidaHTML.println("<br/>");
		saidaHTML.println("Total a  pagar:"+" "+ "R$"+" "+soma);
	}

}
