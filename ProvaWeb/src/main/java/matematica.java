

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/matematica")
public class matematica extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String numero1Txt = request.getParameter("numero1");
		String numero2Txt = request.getParameter("numero2");
		
		int numero1 = Integer.parseInt(numero1Txt);
		int numero2 = Integer.parseInt(numero2Txt);
		
		int soma = numero1 + numero2;
		int subtracao = numero1 - numero2;

		response.setContentType("text/html");
		PrintWriter saidaHTML = response.getWriter();
		
		saidaHTML.println("Soma:"+" "+soma);
		saidaHTML.println("<br/>");
		saidaHTML.println("<br/>");
		saidaHTML.println("Subtração:"+" "+subtracao);
		saidaHTML.println("<br/>");
		saidaHTML.println("<br/>");
		
		if(numero1 == numero2) {
			response.setContentType("text/html");
			PrintWriter saidaHTMLResposta = response.getWriter();
			saidaHTMLResposta.println("<i>Os valores informados"+" "+numero1+ " "+ "e"+" "+numero2+" ,"+"são números iguais!</i>");
		}else if (numero1 != numero2  ) {
			response.setContentType("text/html");
			PrintWriter saidaHTMLResposta = response.getWriter();
			saidaHTMLResposta.println("<u>Os valores informados"+" "+numero1+ " "+ "e" +" "+numero2+" ,"+ "são números diferentes!</u>");
		}
	}

}
