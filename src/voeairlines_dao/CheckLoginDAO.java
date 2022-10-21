package voeairlines_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckLoginDAO {
	
	private boolean autorizacaoCadastro;
	

	public CheckLoginDAO() {

	}

	public boolean primeiroAcesso(String login, String senha) {

		if (login.equals("senai") && senha.equals("123"))
			this.autorizacaoCadastro = true;
		else
			this.autorizacaoCadastro = false;

		return autorizacaoCadastro;

	}
	


	public ResultSet loginSistema(String login, String senha) {

		try {

			Connection conectar = ConexaoDAO.conectarBd();

			String conferirLogin = "select *from login where usuario=? and senha=?";

			PreparedStatement stmt = conectar.prepareStatement(conferirLogin);

			stmt.setString(1, login);
			stmt.setString(2, senha);

			ResultSet autorizarSistema = stmt.executeQuery();

			return autorizarSistema;

			

		} catch (SQLException e) {
			System.out.println("passou login catch" + e);
			e.printStackTrace();
			return null;
		}

	}

}
