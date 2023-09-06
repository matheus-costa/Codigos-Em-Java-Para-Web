package testes;

import modelo.Aluno;
import DAO.AlunoDAO;

public class TestesInserirDB_comDAO {
	public static void main(String[] args) {
		 
		Aluno umAluno = new Aluno();
		umAluno.setNome("Carlos");
		umAluno.setIdade(35);
		
		AlunoDAO alunoDAO = new AlunoDAO();
		alunoDAO.adiciona(umAluno);
		
		System.out.println("aluno(a) insirido(a) no banco de dados");
	}

}
