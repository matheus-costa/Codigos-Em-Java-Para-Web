package testes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import auxiliares.FabricaDeConexoesBD;

public class TesteAlterarDB {

	public static void main(String[] args) {

		try {
			Connection connection = new FabricaDeConexoesBD().obterConexao();
			String sql = "UPDATE  alunos SET nome = ? WHERE id = ?";
			//cada ? da query é um parâmetro, então esta query tem 2 parâmetros
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "João");
			preparedStatement.setInt(2, 8); //no parâmetro 2 da query entrará a idade 32
		
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
