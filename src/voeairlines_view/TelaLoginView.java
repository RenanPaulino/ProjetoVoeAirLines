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

import voeairlines_dao.CheckLoginDAO;


@SuppressWarnings("serial")
public class TelaLoginView extends JFrame {

	// tamnho da janela e imagem
	int alt = 500;
	int lar = 300;

	JButton btnLogar;
	JTextField txtLogin;
	JPasswordField senha;
	JLabel lblUsuario;
	JLabel lblSenha;

	ImagensView fundo;

	public TelaLoginView() {

		// configuração da Janela
		setTitle("Login VoeAirLines");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(alt, lar);
		setResizable(false);
		setLocationRelativeTo(null);

		// Start dos Objetos
		btnLogar = new JButton("Logar");
		txtLogin = new JTextField();
		senha = new JPasswordField();
		lblUsuario = new JLabel("Usuário");
		lblSenha = new JLabel("Senha");
		fundo = new ImagensView();

		// add layout
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		txtLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		senha.setHorizontalAlignment(SwingConstants.CENTER);

		setContentPane(fundo);
		fundo.setLayout(new GridLayout(8, 3));
	
		fundo.add(Box.createRigidArea(new Dimension()));
		fundo.add(Box.createRigidArea(new Dimension()));
		fundo.add(lblUsuario);
		fundo.add(Box.createRigidArea(new Dimension()));
		fundo.add(txtLogin);
		fundo.add(Box.createRigidArea(new Dimension()));
		fundo.add(lblSenha);
		fundo.add(Box.createRigidArea(new Dimension()));
		fundo.add(senha);
		fundo.add(Box.createRigidArea(new Dimension()));
		fundo.add(Box.createRigidArea(new Dimension()));
		fundo.add(Box.createRigidArea(new Dimension()));
		fundo.add(btnLogar);
		fundo.add(Box.createRigidArea(new Dimension()));

//////////////////////////////////////////////////////////////////////////

		btnLogar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				CheckLoginDAO loginUser = new CheckLoginDAO();
				TelaCadastroView telaCadastro = new TelaCadastroView();
				TelaSistemaView telaSistema = new TelaSistemaView();

				try {

					if (loginUser.primeiroAcesso(txtLogin.getText(), new String(senha.getPassword()))) {

						JOptionPane.showMessageDialog(null, "Cadestre um Novo Usuário", "ATENÇÃO",
								JOptionPane.WARNING_MESSAGE);

						dispose();
						telaCadastro.setVisible(true);

					} else if (loginUser.loginSistema(txtLogin.getText(), new String(senha.getPassword())).next()) {

						dispose();
						telaSistema.setVisible(true);

					} else {
						JOptionPane.showMessageDialog(null, "Usuário ou senha inválida", "ATENÇÃO!",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception mens) {
					
					System.out.println("nao deu" + mens);
				}
			}

		});

	}

}
