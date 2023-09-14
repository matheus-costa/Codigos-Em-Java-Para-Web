package servicos;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.VendaDao;
import modelo.Venda;

@WebServlet("/consultarVendaServlet")
public class ConsultarVendaBDServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//entrada de dados
		String idTxt = request.getParameter("id");//aqui eu pego o id enviado pela URL
		int id = Integer.parseInt(idTxt);//conversão do id de texto para número
		
		//processamento de dados
		VendaDao vendaDAO = new VendaDao();// aqui chamo a minha classe dao.Ou seja minha conexão com o banco de dados
		Venda v = vendaDAO.consultarPorId(id);//aqui procuro os valores que estão nas variáveis de acordo com o ID
		
		
		//construão da resposta a ser enviada ao cliente
		response.setContentType("text/html");// tipo de conteúdo que vai ser enviado ao usuário
		//obtem um objeto tipo printWiter do java, para escrever a resposta a ser enviada ao cliente
		PrintWriter saida = response.getWriter();
		
		saida.print("<h2>Consultar Venda</h2>");//
		saida.print("<br /><b>id</b>: " + v.getId());
		saida.print("<br /><b>item</b>: " + v.getItem());
		saida.print("<br /><b>quantidade</b>: " + v.getValor());
		saida.close();//close envia a resposta construida ao cliente.
	}
}