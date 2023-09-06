package auxiliares;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TesteInserirBD {

		public static void main(String[] args) {
			try {
			Connection connection = new FabricaDeConexoesDB().obterConexao();
			System.out.println("Conexão realizada com sucesso");
			String sql = "INSERT INTO alunos (nome, idade) VALUES (?,?)";
			//cada ? da query é um parâmetro, então esta query tem 2 parâmetros
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, "yJoão");
			//no parâmetro 1 da query entrará o nome João

			preparedStatement.setInt(2, 32);

			//no parâmetro 2 da query entrará a idade 32

			//executa a query
			int saida = preparedStatement.executeUpdate();
			System.out.println("dado inserido no banco");
			System.out.println("retorno do SGBD: " + saida);
			//fecha a instrução preparada e a conexão após a conclusão
			preparedStatement.close();
			connection.close();
			} catch (Exception e) {
			System.out.println("Erro: " + e);
			}
			}
}
