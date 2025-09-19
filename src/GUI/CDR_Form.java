package GUI;

import enums.Colors;
import utils.IconButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CDR_Form extends JFrame {

    private JPanel pnl_menu;
    private JPanel pnl_view;
    private CardLayout cardLayout;

    public CDR_Form() {
        this.initComponents();
    }

    private void initComponents() {
        this.setSize(1024, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("CDR");
        this.setLocationRelativeTo(null);
        //this.setUndecorated(true);
        this.setVisible(true);

        ImageIcon icon = new ImageIcon("/assets/icon.png");
        this.setIconImage(icon.getImage());

        pnl_menu = new JPanel();
        pnl_menu.setLayout(new BoxLayout(pnl_menu, BoxLayout.Y_AXIS));
        pnl_menu.setBackground(Color.decode("#4E73DF")); // Hacer el panel transparente

        JLabel lbl_titulo = new JLabel("CDR");
        lbl_titulo.setForeground(Color.WHITE);
        lbl_titulo.setHorizontalAlignment(JLabel.CENTER);
        lbl_titulo.setVerticalAlignment(JLabel.CENTER);
        lbl_titulo.setMaximumSize(new Dimension(Integer.MAX_VALUE,  lbl_titulo.getPreferredSize().height));
        lbl_titulo.setPreferredSize(new Dimension(230,40));

        lbl_titulo.setFont(new Font("Arial", Font.BOLD, 30));

        JButton btn_Home = new JButton("Inicio");
        //configurarBoton(btn_Home, "ic_home.svg");

        JButton btn_Archivo = new JButton("Por Archivo");
        //configurarBoton(btn_Archivo, "ic_file.svg");

        /*JButton btn_Lote = new JButton("Por Carpeta");
        configurarBoton(btn_Lote, "ic_batch.svg");*/

        JButton btn_Reporte_Cuenta = new JButton("Reporte de Cuenta");
        //configurarBoton(btn_Reporte_Cuenta, "ic_report.svg");

        JButton btn_Salir = new JButton("Salir");
        //configurarBoton(btn_Salir, "ic_power.svg");

        pnl_menu.add(Box.createRigidArea(new Dimension(0, 10)));
        pnl_menu.add(lbl_titulo);
        pnl_menu.add(Box.createRigidArea(new Dimension(0, 25)));
        pnl_menu.add(btn_Home);
        pnl_menu.add(btn_Archivo);
        //pnl_menu.add(btn_Lote);
        pnl_menu.add(btn_Reporte_Cuenta);
        pnl_menu.add(Box.createVerticalGlue());
        pnl_menu.add(btn_Salir);
        pnl_menu.add(Box.createRigidArea(new Dimension(0, 50)));

        pnl_view = new JPanel();
        cardLayout = new CardLayout();
        pnl_view.setLayout(cardLayout);

        pnl_view.add(new CDRMain_Pnl(), "1");
        //pnl_view.add(new PnlFile(), "2");
        //pnl_view.add(new PnlBatch(), "3");
        //pnl_view.add(new PnlReporte(), "3");

        // Acciones de los botones para cambiar de panel
        btn_Home.addActionListener(e -> cardLayout.show(pnl_view, "1"));
        btn_Archivo.addActionListener(e -> cardLayout.show(pnl_view, "2"));
        //btn_Lote.addActionListener(e -> cardLayout.show(pnl_view, "3"));
        btn_Reporte_Cuenta.addActionListener(e -> cardLayout.show(pnl_view, "3"));
        btn_Salir.addActionListener(e -> System.exit(0));

        setLayout(new BorderLayout());
        add(pnl_menu, BorderLayout.WEST);
        add(pnl_view, BorderLayout.CENTER);
    }

    private void configurarBoton(JButton btn, String icon) {
        btn.setMargin(new Insets(10, 20, 10, 20));
        btn.setMaximumSize(new Dimension(Integer.MAX_VALUE,  btn.getPreferredSize().height));
        btn.setPreferredSize(new Dimension(230,40));
        btn.setFont(new Font("Arial", Font.PLAIN, 16));
        btn.setBorderPainted(false);
        btn.setHorizontalAlignment(JButton.LEFT);
        btn.setBackground(Color.decode(Colors.FONDO.getColor().toString()));
        btn.setForeground(Color.WHITE);

        ImageIcon defaultIcon = null;
        ImageIcon hoverIcon = null;

        try {
            defaultIcon = new ImageIcon(new IconButton().showIcon(icon,
                    Colors.FONDO.getColor().toString(), Colors.BLANCO.getColor().toString()));
            hoverIcon = new ImageIcon(new IconButton().showIcon(icon,
                    Colors.FONDO_HOVER.getColor().toString(), Colors.NEGRO.getColor().toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (defaultIcon != null) {
            btn.setIcon(defaultIcon);
        }

        ImageIcon finalDefaultIcon = defaultIcon;
        ImageIcon finalHoverIcon = hoverIcon;

        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btn.setBackground(Color.decode(Colors.FONDO_HOVER.getColor().toString()));
                btn.setForeground(Color.BLACK); // Cambia el color del texto en hover
                if (finalHoverIcon != null) {
                    btn.setIcon(finalHoverIcon);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn.setBackground(Color.decode(Colors.FONDO.getColor().toString()));
                btn.setForeground(Color.WHITE); // Vuelve al color original cuando sale del hover
                if (finalDefaultIcon != null) {
                    btn.setIcon(finalDefaultIcon);
                }
            }
        });
    }
}
