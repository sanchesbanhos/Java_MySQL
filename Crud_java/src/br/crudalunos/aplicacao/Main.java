package br.crudalunos.aplicacao;

import br.alunos.matriculas.Alunos;
import br.com.crudalunos.DAO.Crud_alunos_DAO;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Crud_alunos_DAO alunosDao = new Crud_alunos_DAO();
		Alunos aluno = new Alunos();
		
		aluno.setCpf(Long.parseLong("97521469100"));
		aluno.setNome("Francisco Sanches");
		aluno.setEndereco("Rua Uberlândia, 166");
		aluno.setTelefone(Long.parseLong("66999647469"));
		
		alunosDao.save(aluno);
		
	}

}
