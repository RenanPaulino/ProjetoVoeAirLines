package voeairlines_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import voeairlines_dto.AeronavesDTO;

public class CadastrarAeronavesDAO {
	
	Connection conectar;
	PreparedStatement stm;

	public void cadastroAeronaves(AeronavesDTO dados) {
		try {

			String cadastrar = "insert into aeronaves (fabricante, modelo, codigo,tipoaeronaves_id) values(?,?,?,?)";
			conectar = ConexaoDAO.conectarBd();

			stm = conectar.prepareStatement(cadastrar);
			stm.setString(1, dados.getFabricante());
			stm.setString(2, dados.getModelo());
			stm.setString(3, dados.getCodigo());
			stm.setInt(4, dados.getIdAeronave() );

			stm.execute();
			stm.close();
			conectar.close();

		} catch (Exception e) {
			System.out.println("não passou o cadastro de aeronaves" + e);
		}
	}

}
