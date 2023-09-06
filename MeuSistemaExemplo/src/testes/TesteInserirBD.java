package testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import auxiliares.FabricaDeConexoesBD;
import java.sql.SQLException;

public class TesteInserirBD {
	public static void main(String[] args) {
	
		try {
			
			Connection connection = new FabricaDeConexoesBD().obterConexao();
			System.out.println("Conexão realizada com sucesso" );
			
			String sql = "INSERT INTO alunos (nome,idade) VALUES (?,?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			 preparedStatement.setString(1, "yJoão");
			 preparedStatement.setInt(2, 32);
			 
			 int saida = preparedStatement.executeUpdate();
			 System.out.println("Conexão realizada com sucesso" );
			 System.out.println("Conexão realizada com sucesso" );
			 
			 
			 preparedStatement .close();
			 connection.close();
			 
		}catch(Exception e) {
			System.out.println("Erro"+ e);
		}
		

	}

}
