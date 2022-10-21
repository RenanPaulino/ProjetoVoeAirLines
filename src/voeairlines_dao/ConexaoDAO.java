package voeairlines_dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDAO {

	private static String endereco = "jdbc:mysql://localhost/usuario?useTimezone=true&serverTimezone=UTC";
	private static String user = "root";
	private static String password = "123";

	public static Connection conectarBd() throws SQLException {

		try {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			System.out.println("passou try");
			
			return DriverManager.getConnection(endereco, user, password);
		
		} catch (ClassNotFoundException e) {
			System.out.println(e);
			throw new SQLException(e.getException());
		}
	}
}
