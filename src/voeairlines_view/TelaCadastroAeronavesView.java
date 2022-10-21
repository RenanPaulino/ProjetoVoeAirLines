package voeairlines_view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import voeairlines_dao.CadastrarAeronavesDAO;
import voeairlines_dao.CadastrarTiposAeronavesDAO;
import voeairlines_dto.AeronavesDTO;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class TelaCadastroAeronavesView extends JFrame {

	private JPanel contentPane;
	private JTextField txtFabricante;
	private JLabel lblModelo;
	private JLabel lblCodigo;
	private JTextField txtModelo;
	private JTextField txtCodigo;
	@SuppressWarnings("rawtypes")
	JComboBox comboBox = new JComboBox();

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { TelaCadastroAeronavesView frame = new
	 * TelaCadastroAeronavesView(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 * 
	 * /** Create the frame.
	 */
	
	public TelaCadastroAeronavesView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("VoeAirLines");
		setResizable(false);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblFabricante = new JLabel("Fabricate:");
		lblFabricante.setHorizontalAlignment(SwingConstants.LEFT);
		lblFabricante.setBounds(32, 95, 71, 21);
		contentPane.add(lblFabricante);

		txtFabricante = new JTextField();
		txtFabricante.setHorizontalAlignment(SwingConstants.CENTER);
		txtFabricante.setBackground(Color.WHITE);
		;
		txtFabricante.setBounds(134, 95, 136, 20);
		contentPane.add(txtFabricante);
		txtFabricante.setColumns(10);

		lblModelo = new JLabel("Modelo:");
		lblModelo.setHorizontalAlignment(SwingConstants.LEFT);
		lblModelo.setBounds(32, 127, 46, 14);
		contentPane.add(lblModelo);

		lblCodigo = new JLabel("Código:");
		lblCodigo.setHorizontalAlignment(SwingConstants.LEFT);
		lblCodigo.setBounds(32, 159, 46, 14);
		contentPane.add(lblCodigo);

		txtModelo = new JTextField();
		txtModelo.setHorizontalAlignment(SwingConstants.CENTER);
		txtModelo.setBounds(134, 126, 136, 20);
		contentPane.add(txtModelo);
		txtModelo.setColumns(10);

		txtCodigo = new JTextField();
		txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigo.setBounds(134, 156, 136, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
	
		comboBox.   addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listaTiposAeronaves();
			}
		});
	
		
		
		
		comboBox.setMaximumRowCount(3);
		comboBox.setBounds(134, 187, 136, 22);
		contentPane.add(comboBox);
	//	listaTiposAeronaves();
		

		JLabel lblTipo = new JLabel("Selec. Tipo:");
		lblTipo.setBounds(32, 191, 89, 14);
		contentPane.add(lblTipo);

		JLabel lblCadastro = new JLabel("Cadastro de Aeronaves");
		lblCadastro.setFont(new Font("Tahoma", Font.BOLD, 31));
		lblCadastro.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastro.setBounds(32, 11, 392, 45);
		contentPane.add(lblCadastro);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalvar.setBounds(307, 187, 89, 23);
		contentPane.add(btnSalvar);
		
		
		
		btnSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AeronavesDTO salvaDados = new AeronavesDTO();
				if (txtFabricante.getText().isEmpty() || txtModelo.getText().isEmpty() || txtCodigo.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Nenhum dos campos podem ser vazio!", "ATENÇÃO",
							JOptionPane.OK_OPTION);

				else {

					salvaDados.setFabricante(txtFabricante.getText());
					salvaDados.setCodigo(txtCodigo.getText());
					salvaDados.setModelo(txtModelo.getText());
					salvaDados.setIdAeronave(idDescricao.get(comboBox.getSelectedIndex()));
					
					CadastrarAeronavesDAO dados = new CadastrarAeronavesDAO();
					dados.cadastroAeronaves(salvaDados);
					System.out.println(idDescricao.get(comboBox.getSelectedIndex()));
					

					JOptionPane.showMessageDialog(null, "Salvo com Sucesso!", "", JOptionPane.NO_OPTION);
				}
			}
		});

	}
	

	ArrayList<Integer> idDescricao = new ArrayList<Integer>();

	@SuppressWarnings("unchecked")
	public void listaTiposAeronaves() {

		try {
			CadastrarTiposAeronavesDAO objTipoAir = new CadastrarTiposAeronavesDAO();
			ResultSet rs = objTipoAir.listTipos();

			while (rs.next()) {

				idDescricao.add(rs.getInt(1));
				comboBox.addItem(rs.getString(2));
			}

		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e);
		}

	}
}
