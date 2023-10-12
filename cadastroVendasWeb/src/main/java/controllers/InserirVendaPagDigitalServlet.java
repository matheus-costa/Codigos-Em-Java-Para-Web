package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.VendaPagDigital;
import models.VendaPagDigitalDAO;

@WebServlet(urlPatterns = {"/InserirVendaPagDigitalServlet"})
public class InserirVendaPagDigitalServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public InserirVendaPagDigitalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//to-do esta controller:

			//1o pegar dados vindos do form
			String nomeCliente = request.getParameter("nomeCLiente");
			System.out.println("nome do cliente:"+nomeCliente);
			String emailCLiente = request.getParameter("emailCLiente");
			System.out.println("e-mail:"+emailCLiente);
			String formaPagamento = request.getParameter("formaPagamento");
			System.out.println("forma de pagemento:"+formaPagamento);
			String nomeProduto = request.getParameter("nomeProduto");
			System.out.println("nome do produto:"+nomeProduto);
			String valorProduto = request.getParameter("valorProduto");
			System.out.println("valor do produto:"+valorProduto);
            String tipoDeEntrega = request.getParameter("tipoDeEntrega");

            String registrarPagamento = request.getParameter("registrarPagamento");

			//2o criar objeto vendaPagDigital
			VendaPagDigital venda = new VendaPagDigital();
			venda.setCliente(nomeCliente);
			venda.setClienteEmail(emailCLiente);
			venda.setProduto(nomeProduto);
			venda.setTipoPagamento(formaPagamento);
            venda.setClienteEmail(valorProduto);
            venda.setTipoEntrega(tipoDeEntrega);

            double valorApagar = Double.parseDouble(valorProduto);
           
            
			/*double desconto =0;
			desconto = Double.parseDouble(valorProduto);
			if (formaPagamento.equals("Pix")) {
				 valorProduto = valorProduto + 0.10;

			}else if (formaPagamento.equals("CartaodeCredito")) {
				valorProduto = valorProduto;
			}else if (formaPagamento.equals("Boleto")) {
				valorProduto = valorProduto + 0.05;

			}
			double taxa =0;
			if(tipoDeEntrega.equals("transportadora")) {
				taxa = 40;

			}else if(tipoDeEntrega.equals("sedex")) {
				taxa = 60;
			}
			*/
			venda.setValorPago(valorApagar);
			venda.setStatusPagamento("Teste");
			

			//3o dao.inserir
			VendaPagDigitalDAO vendaPagDigitalDAO = new VendaPagDigitalDAO();
			int status = VendaPagDigitalDAO.inserir(venda);

			response.setContentType("text/html");
			PrintWriter htmlSaida = response.getWriter();


			if(status>0){
				htmlSaida.print("<p style='color: red'>Venda inserida com sucesso!</p>");
	            RequestDispatcher dispatcher = request.getRequestDispatcher("confirmacao-venda-pag-digital.jsp");
	            dispatcher.forward(request, response);

	        }else{
	        	htmlSaida.println("Desculpe! Não foi possivel inserir a venda.");
	        }

			//4o redirecionar para a view a ser criadas

			//RequestDispatcher rd = request.getDispatcherType("confirmacao-venda-pag-digital.html");
			//rd.forward(request, response);
			// Redirecionamento para a segunda página

	        //String segundaPagina = "/confirmacao-venda-pag-digital.jsp"; // Substitua com o caminho da sua segunda página
	        //response.sendRedirect(segundaPagina);
	        // Use o método sendRedirect para redirecionar o navegado
	    }
	}