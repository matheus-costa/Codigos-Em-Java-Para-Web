package testes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteSelectDB_Ordenado {
	public static void main(String[] args) {

		try {
				    
		      String jdbcUrl = "jdbc:postgresql://localhost:5432/padilha";
		      String usuario = "postgres";
		      String senha = "postgres";

		      Connection connection = DriverManager.getConnection(jdbcUrl, 
                                                                    usuario, senha);

		      Statement statement = connection.createStatement();
		      ResultSet resultSet = statement.executeQuery("SELECT nome FROM alunos ORDER BY nome ASC");
	

		       while (resultSet.next()) {
				
                //pega o valor de cada coluna da linha corrente do cursor
   			    int id = resultSet.getInt("id");
			    String nome = resultSet.getString("nome");
			    int idade = resultSet.getInt("idade");
			    

			   
			    System.out.println("Id: " + id);
			    System.out.println("Nome: " + nome);
			    System.out.println("Idade: " + idade);
			  
			    System.out.println("------");
			}			

            //fecha a conexão com o SGBD e libera os objetos da memória
			resultSet.close();  
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
		    e.printStackTrace();  
		} 				
	}

}
