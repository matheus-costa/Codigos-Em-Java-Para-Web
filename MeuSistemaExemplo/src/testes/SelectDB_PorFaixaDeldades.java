package testes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Scanner;

import auxiliares.FabricaDeConexoesBD;

public class SelectDB_PorFaixaDeldades {
	public static void main(String[] args) {
	try {
		Connection connection = new FabricaDeConexoesBD().obterConexao();
           Scanner scanner = new Scanner(System.in);
	      
	      System.out.print("Digite a idade mínima: ");
	      int idadeMinima = scanner.nextInt();
	      System.out.print("Digite a idade máxima: ");
	      int idadeMaxima = scanner.nextInt();
	      scanner.close();

	      PreparedStatement pstatement = connection.prepareStatement(" SELECT id,nome, idade FROM alunos WHERE idade BETWEEN  ? AND ?");
	      pstatement.setInt(1, idadeMinima); //no parâmetro 2 da query entrará a idade 32
	      pstatement.setInt(2, idadeMaxima); //no parâmetro 2 da query entrará a idade 32
			
	      ResultSet resultSet = pstatement.executeQuery();
	      
	  
	    

	      while (resultSet.next()) {

	    	//pega o valor de cada coluna da linha corrente do cursor
	    	int id = resultSet.getInt("id");
	    	String nome = resultSet.getString("nome");
	    	int idade = resultSet.getInt("idade");
	    	System.out.println("ID: " + id);
	    	System.out.println("Nome: " + nome);
	    	System.out.println("Idade: " + idade);
	    	System.out.println("------");
	    	}
        //fecha a conexão com o SGBD e libera os objetos da memória
		resultSet.close();  
		pstatement.close();
		connection.close();
		
	} catch (SQLException e) {
	    e.printStackTrace();  
	} 				
}



}
