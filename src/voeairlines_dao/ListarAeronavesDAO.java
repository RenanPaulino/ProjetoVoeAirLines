package voeairlines_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class ListarAeronavesDAO {

	Connection conectar;
	PreparedStatement stm;
	ResultSet rs;

	public ResultSet listarAeronaves() {

		try {
			String buscar = "Select * from aeronaves";
			conectar = ConexaoDAO.conectarBd();

			stm = conectar.prepareStatement(buscar);

			return rs = stm.executeQuery();

		} catch (Exception e) {

			JOptionPane.showConfirmDialog(null, e);
			return null;
		}
	}

}
