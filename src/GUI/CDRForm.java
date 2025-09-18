package GUI;

import javax.swing.*;

public class CDRForm extends JFrame {

    public CDRForm() {
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
    }
}
