package voeairlines_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import voeairlines_dto.UsuarioDTO;

public class CadastrarUsuarioDAO {

	Connection conectar;
	PreparedStatement stm;

	public void cadastroUser(UsuarioDTO dados) {
		try {

			String cadastrar = "insert into login (usuario, senha) values(?,?)";
			conectar = ConexaoDAO.conectarBd();

			stm = conectar.prepareStatement(cadastrar);
			stm.setString(1, dados.getUsuario());
			stm.setString(2, dados.getSenha());

			stm.execute();
			stm.close();
			conectar.close();

		} catch (Exception e) {
			System.out.println("não passou o cadastro de usuario" + e);
		}
	}

}
