package auxiliares;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexoesBD {

		
		public Connection obterConexao() {
		try {

		String jdbcUrl = "jdbc:postgresql://localhost:5432/padilha";
		String usuario = "postgres";
		String senha = "postgres";

		Connection connection = DriverManager.getConnection(jdbcUrl, usuario, senha);
		return connection;
		} catch (SQLException e) {
		throw new RuntimeException(e);
		}
	}
	}
