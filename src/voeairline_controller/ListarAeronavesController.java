package voeairline_controller;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import voeairlines_dao.ListarAeronavesDAO;
import voeairlines_dto.AeronavesDTO;

public class ListarAeronavesController {

	public ArrayList<AeronavesDTO> listaAeronaves() {

		try {
			AeronavesDTO lista = new AeronavesDTO();
			ListarAeronavesDAO buscarLista = new ListarAeronavesDAO();
			ResultSet rs = buscarLista.listarAeronaves();

			ArrayList<AeronavesDTO> listas = new ArrayList<>();
			while (rs.next()) {

				lista.setFabricante(rs.getString(2));
				lista.setModelo(rs.getString(3));
				lista.setCodigo(rs.getString(4));

				listas.add(lista);

			}
			return listas;

		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e);
			return null;
		}

	}

}
