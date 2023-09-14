package teste;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listar")
public class listar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		
		try{

		String jdbcUrl = "jdbc:postgresql://localhost:5432/padilha";
		String usuario = "postgres";
		String senha = "postgres";
		
		Class.forName("org.postgresql.Driver");
		
		Connection connection = DriverManager.getConnection(jdbcUrl, usuario, senha); 
		//Connection connection = new FabricaDeConexoesBD().obterConexao();
		
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT id, nome,idade FROM alunos ORDER BY nome ASC");

		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		while (resultSet.next()) {

		//pega o valor de cada coluna da linha corrente do cursor
		int id = resultSet.getInt("id");
		String nome = resultSet.getString("nome");
		int idade = resultSet.getInt("idade");
		
		out.print("<br />ID: "+ id +" - Nome: " + nome);
		
		}

		//fecha a conexão com o SGBD e libera os objetos da memória

		resultSet.close();
		statement.close();
		connection.close();
		} catch (SQLException e) {
		e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}