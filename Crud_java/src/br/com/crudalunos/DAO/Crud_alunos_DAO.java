package br.com.crudalunos.DAO;

import java.sql.Connection;

import com.mysql.cj.jdbc.JdbcPreparedStatement;

import br.alunos.factory.Conexao;
import br.alunos.matriculas.Alunos;

public class Crud_alunos_DAO {
	//CRUD - Create, Read, Update, Delete
	//DAO Data Acess Object

	public void save(Alunos aluno) {
		String sql = "INSERT INTO alunos(cpf, nome, endereco, telefone) VALUES (?,?,?,?)";
		Connection conn = null;
		JdbcPreparedStatement pstm = null;
		try {
			//criar conexão com o bd
			conn = (Connection) Conexao.createConnectiontoMySQL();
			//criamos uma preparestatement para executar uma query
			pstm = (JdbcPreparedStatement) conn.prepareCall(sql);
			//adiciona no banco
			pstm.setLong(1, aluno.getCpf());
			pstm.setString(2, aluno.getNome());
			pstm.setString(3,  aluno.getEndereco());
			pstm.setLong(4, aluno.getTelefone());
			//executar a query;
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			//fechar as conexoes
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
