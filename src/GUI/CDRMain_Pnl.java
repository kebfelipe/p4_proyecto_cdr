package GUI;

import enums.Colors;

import javax.swing.*;
import java.awt.*;

public class CDRMain_Pnl extends JPanel {

	public CDRMain_Pnl() {
		this.initComponents();
	}

	private void initComponents() {
		setBackground(Color.getColor(Colors.BLANCO.getColor().toString()));
		JPanel pnl_encabezado = new JPanel();
		pnl_encabezado.setBackground(Color.getColor(Colors.BLANCO.getColor().toString()));
		pnl_encabezado.setLayout(new BoxLayout(pnl_encabezado, BoxLayout.Y_AXIS));

		JLabel lbl_encabezado = new JLabel("Proyecto CDR");
		lbl_encabezado.setFont(new java.awt.Font("Tahoma", 1, 24));

		JLabel lbl_subtitulo = new JLabel("Procesamiento de archivos CDR");
		lbl_subtitulo.setFont(new java.awt.Font("Tahoma", 0, 18));

		JLabel lbl_descripcion = new JLabel(
				"El sistema permite cargar archivos CDR, procesarlos y almacenarlos en una base de datos.");
		lbl_descripcion.setFont(new java.awt.Font("Tahoma", 0, 14));

		JLabel lbl_descripcion2 = new JLabel("Kebyn Hern�n Felipe Co.");
		lbl_descripcion2.setFont(new java.awt.Font("Tahoma", 0, 14));

		JLabel lbl_descripcion3 = new JLabel("Carne: 000091601");
		lbl_descripcion3.setFont(new java.awt.Font("Tahoma", 0, 14));

		pnl_encabezado.add(Box.createRigidArea(new Dimension(0, 50)));
		pnl_encabezado.add(lbl_encabezado);
		pnl_encabezado.add(lbl_subtitulo);
		pnl_encabezado.add(lbl_descripcion);
		pnl_encabezado.add(Box.createRigidArea(new Dimension(0, 50)));
		pnl_encabezado.add(lbl_descripcion2);
		pnl_encabezado.add(lbl_descripcion3);

		add(pnl_encabezado);
	}
}