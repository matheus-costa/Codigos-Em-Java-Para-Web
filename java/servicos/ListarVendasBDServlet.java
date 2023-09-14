package servicos;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.VendaDao;
import modelo.Venda;

@WebServlet(urlPatterns = "/listarVendasServlet")
public class ListarVendasBDServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Venda> listaVendas = new ArrayList<Venda>();
		VendaDao vendaDAO = new VendaDao();
		listaVendas = vendaDAO.listarTodas();//processamento de dados
		
		//entrada de dados
		response.setContentType("text/html");
		PrintWriter saida = response.getWriter();
		saida.print("<a href=\"index.html\">Inserir nova venda</a>");
		saida.print("<a href=\"index.html\">Alterar venda</a>");
		saida.print("<h2>Lista de Vendas</h2>");
		saida.print("<link rel='stylesheet' type='text/css' href='./css/tabelaListaVendas.css'>");
		
		//construão da resposta a ser enviada ao cliente
		for(int i=0; i<listaVendas.size(); i++) {
			Venda v = listaVendas.get(i);
			saida.print(" <tr>");
			saida.print(" <td style='padding: 15px;'>" + v.getId() + "</td><td>"+

			v.getItem() +"</td><td>"+ v.getValor() +"</td>");

			saida.print(" <td style='padding: 15px;'><a> |");

			saida.print("| <a   href='consultarVendaServlet?id="+v.getId()+"'>consultar</a></td>");
			saida.print(" <td style='padding: 15px;'><a href='removerVendaServlet?id="+v.getId()+"'>remover</a></td>");
			saida.print("| <a   href='inserirVendaServlet?id="+v.getId()+"'>inserir</a></td>");
			saida.print("| <a   href='alterarVendaServlet?id="+v.getId()+"'>alterar</a></td>");
			saida.print(" </tr>");
			
			saida.print("<br /><br  />");
	}
		saida.close();
	}
}