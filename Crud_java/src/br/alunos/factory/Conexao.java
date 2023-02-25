package br.alunos.factory;

import java.sql.Connection;
import java.sql.DriverManager;



public class Conexao {
	private static final String USERNAME = "root";
	private static final String PASSWORD = "123123";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/crud-cliente?useTimezone=true&serverTimezone=UTC";
	
	public static Connection createConnectiontoMySQL() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = (Connection) DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		return connection;
	}
	
	public static void main(String[] args) throws Exception {
		// recuperar conexão com o bd
		Connection con = createConnectiontoMySQL();
		
		//testar se a conexao está ativa
		
		if (con != null) {
			System.out.println("Conexao SUCESSO");
			con.close();
		}
	}
}
