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
	
	@WebServlet("/inserirVendaServlet")
	public class InserirVendaBDServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {
		
	//entrada de dados
	String item = request.getParameter("nome");
	String valorTxt = request.getParameter("valor");
	
	double valor = Double.parseDouble(valorTxt);
	Venda v = new Venda();// aqui eu chamo minha conexão
	v.setItem(item);
	v.setValor(valor);
	
	//processamento de dados
	VendaDao vendaDAO = new VendaDao();
	int status = vendaDAO.inserir(v);
	
	//construção da resposta a ser enviada ao cliente
	response.setContentType("text/html");
	PrintWriter htmlSaida = response.getWriter();
	htmlSaida.print("resultado: " + status);
	
	if(status>0){
		htmlSaida.print("<p style='color: red'>Venda inserida com sucesso!</p>");
		request.getRequestDispatcher("index.html").include(request, response);
		} else {
		htmlSaida.println("Desculpe! Não foi possível inserir a venda.");
		}
	htmlSaida.close();
	}
	}

