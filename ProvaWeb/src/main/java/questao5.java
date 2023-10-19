

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.util.ArrayList;
import java.util.List;


@WebServlet("/listaAlunos")
public class questao5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Aluno Aluno1 = new Aluno("Ana",15);
		Aluno Aluno2 = new Aluno("Maria",20);
		Aluno Aluno3 = new Aluno("Ana Maria",25);
		List<Aluno> listaAlunos = new ArrayList<Aluno>(); // cria uma lista de objetos da classe Aluno
		listaAlunos.add(Aluno1); //adiciona o objeto Aluno1 na classe Aluno na lista
		listaAlunos.add(Aluno2); //adiciona o objeto Aluno2 na classe Aluno na lista	
		listaAlunos.add(Aluno3); //adiciona o objeto Aluno3 na classe Aluno na lista
		
		request.setAttribute("lista", listaAlunos);
		
		RequestDispatcher dispacher = request.getRequestDispatcher("lista-de-alunos.jsp");
		dispacher.forward(request,response);
		
		
	}
}