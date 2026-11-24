package swing;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaCongelada extends JFrame {
    private JLabel lblEstado = new JLabel("Esperando...");
    private JButton btnReporte = new JButton("Generar reporte");

    public VentanaCongelada() {
        super("Reporte - version congelada");
        setLayout(new FlowLayout(FlowLayout.CENTER, 15, 20));
        lblEstado.setFont(new Font("SansSerif", Font.BOLD, 15));
        add(btnReporte);
        add(lblEstado);
        btnReporte.addActionListener(e -> generar());
        setSize(380, 120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void generar() {
        lblEstado.setText("Procesando...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            return;
        }
        lblEstado.setText("Reporte listo");
    }

    public static void main(String[] args) {
        new VentanaCongelada().setVisible(true);
    }
}
