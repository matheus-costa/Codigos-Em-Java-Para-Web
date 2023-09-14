package servicos;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.VendaDao;

@WebServlet(urlPatterns = "/removerVendaServlet")
public class RemoverVendaBDServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idTxt = request.getParameter("id");
		int id = Integer.parseInt(idTxt);
		
		VendaDao vendaDAO = new VendaDao();
		int status = vendaDAO.remover(id);
		
		response.setContentType("text/html");
		PrintWriter saida = response.getWriter();
		
		saida.print("status: "+status);
		if (status > 0) {
			saida.print("<p style='color: red'>Venda removida com sucesso!</p>");
			request.getRequestDispatcher("/listarVendasServlet").include(request, response);
			response.sendRedirect("listarVendasServlet");
		} else {
			saida.println("Desculpe! Não foi possível remover a venda.");
		}
		saida.close();
	}
}