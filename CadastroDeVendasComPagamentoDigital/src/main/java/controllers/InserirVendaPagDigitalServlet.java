package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.VendaPagDigital;
import models.VendaPagDigitalDAO;

@WebServlet("/inserirVendaPagDigitalServlet")
public class InserirVendaPagDigitalServlet extends HttpServlet {

	public InserirVendaPagDigitalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//to-do esta controller:
		
			//1o pegar dados vindos do form
			String cliente_nome = request.getParameter("nomeCLiente");
			//...
			String formaPagamento = request.getParameter("formaPagamento");
			
		
			//2o criar objeto vendaPagDigital
			VendaPagDigital venda = new VendaPagDigital(); 
			venda.setCliente(cliente_nome);
			//...
			venda.setTipoPagamento(formaPagamento);
			
			double desconto =0;
			if (formaPagamento.equals("Pix")) {
				//desconto..
			}
			
			
			
			//3o dao.inserir
			VendaPagDigitalDAO vendaPagDigitalDAO = new VendaPagDigitalDAO();
			vendaPagDigitalDAO.inserir(venda);	
		
			//4o redirecionar para a view a ser criadas
		
			//RequestDispatcher rd = request.getDispatcherType("tela a ser criada.jsp")
			//rd.forward(request, response);
		
	}

}
