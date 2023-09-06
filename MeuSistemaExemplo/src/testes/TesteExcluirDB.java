package testes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import auxiliares.FabricaDeConexoesDB;

public class TesteExcluirDB {

	public static void main(String[] args) {

		try {
			Connection connection = new FabricaDeConexoesDB().obterConexao();
			
			String sql = "DELETE FROM alunos WHERE id = ?";
			//cada ? da query é um parâmetro, então esta query tem 2 parâmetros
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, 7); //no parâmetro 2 da query entrará a idade 32
		
			//executa a query
			int saida = preparedStatement.executeUpdate();
			System.out.println("dado removido no banco");
			System.out.println("retorno do SGBD: " + saida);
			
			preparedStatement.close();
			connection.close();

		} catch (Exception e) {

			System.out.println("Erro: " + e);
		}

	}
}
