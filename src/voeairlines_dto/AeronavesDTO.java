package voeairlines_dto;

import java.util.ArrayList;

public class AeronavesDTO {

	private String fabricante;
	private String modelo;
	private String codigo;
	private int idAeronave;
/*	private ArrayList<AeronavesDTO>listar = new ArrayList<>();
	
	
	public ArrayList<AeronavesDTO> getListar() {
		return listar;
	}

	public void setListar(ArrayList<AeronavesDTO> listar) {
		this.listar = listar;
	}
*/
	public int getIdAeronave() {
		return idAeronave;
	}

	public void setIdAeronave(int idAeronave) {
		this.idAeronave = idAeronave;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
