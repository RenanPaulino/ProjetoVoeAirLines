package voeairlines_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import voeairlines_dto.TiposAeronavesDTO;

public class CadastrarTiposAeronavesDAO {

	Connection conectar;
	PreparedStatement stm;
	ResultSet rs;
//	ArrayList<TiposAeronavesDAO> listaDesc = new ArrayList<>();
	
	public void cadastraTipos(TiposAeronavesDTO dados) {
		try {

			String cadastrar = "insert into tipoAeronaves (descricao) values(?)";
			conectar = ConexaoDAO.conectarBd();

			stm = conectar.prepareStatement(cadastrar);
			stm.setString(1, dados.getDescricao());

			stm.execute();
			stm.close();
			conectar.close();
			
		} catch (Exception e) {
			System.out.println("não passou o cadastro tipos" + e);
		}
	}
	
	public ResultSet listTipos(){
		
			try {
				String sql = "Select * from tipoAeronaves";
				conectar = ConexaoDAO.conectarBd();

				stm = conectar.prepareStatement(sql);
				
			    return	rs = stm.executeQuery();
				
					
			} catch (SQLException e) {
				System.out.println("Nao passou nas pesquisa de tipos"+e);
				return null;
			}
			
			
			
			
			
		
	}

}
