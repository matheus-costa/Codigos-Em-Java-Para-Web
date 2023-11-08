package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.VendaPagDigitalDAO;
import models.VendaPagDigital;

@SuppressWarnings("serial")
@WebServlet(urlPatterns="/listarVendasServlet")
public class ListarVendaPagDigitalServlet extends HttpServlet {

	 protected void doGet(HttpServletRequest request, HttpServletResponse response)   
             throws ServletException, IOException {
		 
		 List<VendaPagDigital> listaVendas = new ArrayList<VendaPagDigital>();
		 
		 VendaPagDigitalDAO vendaDAO = new VendaPagDigitalDAO();
		 listaVendas = vendaDAO.listarTodas();
		 
		 response.setContentType("text/html");
		 PrintWriter saida = response.getWriter();
		 
		 saida.print("<html>");
		 saida.print("<head>");
		 saida.print("    <meta charset=\"UTF-8\">");
		 saida.print("    <title>Lista de Vendas</title>");
		 saida.print("    <link rel='stylesheet' type='text/css' href='./css/tabelaListaVendas.css'>");
		 saida.print("</head>");
		 saida.print("<body>");
		 
		 
		 saida.print("<a href=\"cadastro-venda-pag-digital.html\">Inserir nova venda</a>");

		 saida.print("<h2>Lista de Vendas</h2>");
		 
		 saida.print("<table border='1' class='styled-table'>");
		 saida.print("	<tr>");
		 saida.print("		<th>id</th><th>item</th><th>Valor</th><th>Consultar</th><th>Remover</th>");
		 saida.print("	</tr>");
			 
			 
		 for(int i=0; i<listaVendas.size(); i++) {

			 VendaPagDigital venda = listaVendas.get(i);
				 
			 saida.print("	<tr>");
			 saida.print("	  <td style='padding: 15px;'>" + venda.getId() + "</td><td>"+ 
	                                                  venda.getProduto() +"</td><td>"+ venda.getValorPago() +"</td>");
			 saida.print("	  <td style='padding: 15px;'><a href='consultarVendaServlet?id="+venda.getId()+"'>consultar</a></td>");
			 saida.print("	  <td style='padding: 15px;'><a href='removerVendaServlet?id="+venda.getId()+"'>remover</a></td>");                
	               saida.print("	</tr>");
				 			 			 
		 }		 
		 saida.print("<table>");
		 
		 saida.print("</body>");
		 saida.print("</html>");		 
 
		 saida.close();		 
	 }	
}
