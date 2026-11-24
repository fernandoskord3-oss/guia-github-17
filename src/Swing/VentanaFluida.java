package swing;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class VentanaFluida extends JFrame {
    private JLabel lblEstado = new JLabel("Esperando...");
    private JButton btnReporte = new JButton("Generar reporte");
    private JProgressBar barra = new JProgressBar(0, 10);

    public VentanaFluida() {
        super("Reporte - version con hilo");
        setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
        lblEstado.setFont(new Font("SansSerif", Font.BOLD, 15));
        barra.setStringPainted(true);
        barra.setForeground(new Color(0x1E7A46));

        add(btnReporte);
        add(barra);
        add(lblEstado);

        btnReporte.addActionListener(e -> generar());
        setSize(380, 170);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void generar() {
        btnReporte.setEnabled(false);
        lblEstado.setText("Procesando...");

        Thread trabajador = new Thread(() -> {
            for (int paso = 1; paso <= 10; paso++) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException ex) {
                    return;
                }
                int avance = paso;
                SwingUtilities.invokeLater(() -> barra.setValue(avance));
            }
            SwingUtilities.invokeLater(() -> {
                lblEstado.setText("Reporte listo");
                btnReporte.setEnabled(true);
            });
        });

        trabajador.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaFluida().setVisible(true));
    }
}