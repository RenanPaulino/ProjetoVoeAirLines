package voeairlines_view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class ImagensView extends JPanel {

	ImageIcon fotoFundo = new ImageIcon(getClass().getResource("foto.png"));

	// tratamento imagem de fundo
	public void paintComponent(Graphics g) {

		TelaLoginView tamanho = new TelaLoginView();

		super.paintComponent(g);
		fotoFundo.setImage(fotoFundo.getImage().getScaledInstance(tamanho.alt, tamanho.lar, 1));
		Image img = fotoFundo.getImage();
		g.drawImage(img, 0, 0, null);

	}

}
