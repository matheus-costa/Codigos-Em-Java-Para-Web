package testes;

import DAO.AlunoDAO;
import modelo.Aluno;

public class TestesExcluirBD_comDAO {
	public static void main(String[] args) {
		
		AlunoDAO alunoDAO = new AlunoDAO();
		
		Aluno umAluno = alunoDAO.consultarPorID(8);
		
		alunoDAO.excluir(umAluno);
		System.out.println("Alun0(a) exludo(a)");
		
	

	}

}
