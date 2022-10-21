
package voeairlines_view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class TelaSistemaView extends JFrame {

	JMenuBar barraMenu = new JMenuBar();
	JMenu opcoes = new JMenu("Menur");
	JMenuItem tipoAir = new JMenuItem("Novo tipo Aeronave");
	JMenuItem newAir = new JMenuItem("Nova Aeronave");
	JMenuItem listarAir = new JMenuItem("Cadastrados");

	public TelaSistemaView() {
		setJMenuBar(barraMenu);
		barraMenu.add(opcoes);
		opcoes.add(tipoAir);
		opcoes.add(newAir);
		opcoes.add(listarAir);

		// CheckLogin dados = new CheckLogin();
		// setTitle("Bem vindo ao sistema " + dados.getLogin() + " VoerAirLines");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 500);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.DARK_GRAY);

		tipoAir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				TelaCadastroTipoView telaTipo = new TelaCadastroTipoView();

				telaTipo.setVisible(true);

			}
		});

		newAir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TelaCadastroAeronavesView telaCadastro = new TelaCadastroAeronavesView();

				telaCadastro.setVisible(true);

			}
		});

		listarAir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TelaListaAeronavesView telaListaAeronavesView = new TelaListaAeronavesView();

				telaListaAeronavesView.setVisible(true);

			}
		});

	}

}
