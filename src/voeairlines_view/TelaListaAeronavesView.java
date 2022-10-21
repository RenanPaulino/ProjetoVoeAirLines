package voeairlines_view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import voeairline_controller.ListarAeronavesController;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;

@SuppressWarnings("serial")
public class TelaListaAeronavesView extends JFrame {

	private JPanel contentPane;
	private JTable tblListaAeronaves;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListaAeronavesView frame = new TelaListaAeronavesView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaListaAeronavesView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		tblListaAeronaves = new JTable( );
		tblListaAeronaves.setBounds(403, 241, -227, -229);
		contentPane.add(tblListaAeronaves);
		
		
		JButton btnBuscar = new JButton("Exibir");
		btnBuscar.setBounds(10, 227, 89, 23);
		contentPane.add(btnBuscar);
	}
}
