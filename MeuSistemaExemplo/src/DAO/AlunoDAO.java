package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import auxiliares.FabricaDeConexoesDB;
import modelo.Aluno;

public class AlunoDAO {
	
	private Connection connection;
	
	public AlunoDAO() {
		this.connection = new FabricaDeConexoesDB().obterConexao();
	}
      public void adiciona(Aluno aluno) {
    	  String sql = "INSERT INTO alunos (nome,idade) VELUES (?,?)";
    	  try {
    		  PreparedStatement stmt = connection.prepareStatement(sql);
    		  
    	  stmt.execute();
    	  stmt.close();
    		  
    	  }catch (SQLException e ) {
    		  throw new RuntimeException(e);
    	  }
      }
      
      public Aluno consultarPorID (int idAlunoBuscado) {
    	  String sql = "SELECT id,nome FROM  alunos WHERE id = ?";
    	  try {
    		  PreparedStatement prepStmt = connection.prepareStatement(sql);
    		  
    	       ResultSet resultSet = prepStmt.executeQuery();
    	       
    	       Aluno alunoDB = new Aluno();
    	       
    	       while(resultSet.next()) {
    	    	   int idDB = resultSet.getInt("id");
    	    	   String nomeDB = resultSet.getString("nome");
    	    	   int idadeDB = resultSet.getInt("idade");
    	    	   
    	       }
    	       prepStmt.close();
    	       resultSet.close();
    	       
    	       return alunoDB;
    		  
    	  }catch (SQLException e ) {
    		  throw new RuntimeException(e);
    	  }
      }   	  
    	  public Aluno excluir (Aluno aluno) {
      
      try {
			Connection connection = new FabricaDeConexoesDB().obterConexao();
			
			String sql = "DELETE FROM alunos WHERE id = ?";
			//cada ? da query é um parâmetro, então esta query tem 2 parâmetros
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, 7); //no parâmetro 2 da query entrará a idade 32
			
			
			//executa a query
		    preparedStatement.executeUpdate();
			System.out.println("dado removido no banco");
		
			
			preparedStatement.close();
			connection.close();
			
		} catch (Exception e) {

			System.out.println("Erro: " + e);
		}
              return aluno;
      
    	  }
}