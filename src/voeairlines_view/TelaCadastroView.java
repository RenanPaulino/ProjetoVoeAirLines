package voeairlines_view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import voeairlines_dao.CadastrarUsuarioDAO;
import voeairlines_dto.UsuarioDTO;

@SuppressWarnings("serial")
public class TelaCadastroView extends JFrame {

	public TelaCadastroView() {
		TelaLoginView tamanho = new TelaLoginView();

		JLabel lblNewUsario = new JLabel("Novo Usuário");
		JLabel lblNewSenha = new JLabel("Nova Senha");
		JButton btnCadastrar = new JButton("Salvar");
		JButton btnVoltar = new JButton("Voltar");
		JTextField txtNewUsuario = new JTextField();
		JPasswordField txtNewSenha = new JPasswordField();
		ImagensView fundo = new ImagensView();

		setTitle("NOVO CADASTRO");
		setSize(tamanho.alt, tamanho.lar);
		setResizable(false);
		setLocationRelativeTo(null);
		setContentPane(fundo);

		lblNewUsario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewSenha.setHorizontalAlignment(SwingConstants.CENTER);
		txtNewSenha.setHorizontalAlignment(SwingConstants.CENTER);
		txtNewUsuario.setHorizontalAlignment(SwingConstants.CENTER);

		fundo.add(lblNewUsario);
		fundo.add(txtNewUsuario);
		fundo.add(lblNewSenha);
		fundo.add(txtNewUsuario);
		fundo.add(btnCadastrar);

		fundo.setLayout(new GridLayout(8, 3));

		fundo.add(Box.createRigidArea(new Dimension()));
		fundo.add(Box.createRigidArea(new Dimension()));
		fundo.add(lblNewUsario);
		fundo.add(Box.createRigidArea(new Dimension()));
		fundo.add(txtNewUsuario);
		fundo.add(Box.createRigidArea(new Dimension()));
		fundo.add(lblNewSenha);
		fundo.add(Box.createRigidArea(new Dimension()));
		fundo.add(txtNewSenha);
		fundo.add(Box.createRigidArea(new Dimension()));
		fundo.add(Box.createRigidArea(new Dimension()));
		fundo.add(Box.createRigidArea(new Dimension()));
		fundo.add(btnCadastrar);
		fundo.add(btnVoltar);

		// Botão q salva novo cadstro
		btnCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				UsuarioDTO newCadastro = new UsuarioDTO();
				TelaLoginView telaLogin = new TelaLoginView();

				if (txtNewUsuario.getText().isEmpty() || txtNewSenha.getPassword().length == 0) {
					JOptionPane.showMessageDialog(null, "Usuário ou senha não podem ficar vazios", "ATENÇÃO!",
							JOptionPane.ERROR_MESSAGE);
				} else {
					newCadastro.setUsuario(txtNewUsuario.getText());
					newCadastro.setSenha(new String(txtNewSenha.getPassword()));
					
					CadastrarUsuarioDAO  inserirDados = new CadastrarUsuarioDAO();
					inserirDados.cadastroUser(newCadastro);

					JOptionPane.showMessageDialog(null, "Cadastro Salvo!");
					dispose();
					telaLogin.setVisible(true);

				}

			}
		});

		// botao para retorna a tela de login
		btnVoltar.addActionListener(new ActionListener() {
			TelaLoginView voltar = new TelaLoginView();

			@Override
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				voltar.setVisible(true);

			}
		});
	}

}
