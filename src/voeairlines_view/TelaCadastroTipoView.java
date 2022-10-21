package voeairlines_view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import voeairlines_dao.CadastrarTiposAeronavesDAO;
import voeairlines_dto.TiposAeronavesDTO;

@SuppressWarnings("serial")
public class TelaCadastroTipoView extends JFrame {

	public TelaCadastroTipoView() {
		setTitle("Cadastre o Tipo de Aeronave");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(500, 60);
		setResizable(false);
		setLocationRelativeTo(null);

		JLabel lbnDescricao = new JLabel("Descrição:");
		JTextField txtDescricao = new JTextField();
		JButton btnSalvar = new JButton("Salvar");

		lbnDescricao.setHorizontalAlignment(SwingConstants.CENTER);
		txtDescricao.setHorizontalAlignment(SwingConstants.CENTER);
		btnSalvar.setBounds(250, 200, 50, 40);
		setLayout(new GridLayout(1, 3));

		add(lbnDescricao);
		add(txtDescricao);
		add(btnSalvar);

		btnSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TiposAeronavesDTO chamada = new TiposAeronavesDTO();
				
				chamada.setDescricao(txtDescricao.getText());
				CadastrarTiposAeronavesDAO descricao = new CadastrarTiposAeronavesDAO();

				descricao.cadastraTipos(chamada);
				JOptionPane.showMessageDialog(null, " Cadastrado com Sucesso!");

			}
		});

	}

}
