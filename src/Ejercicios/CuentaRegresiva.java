package Ejercicios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
public class CuentaRegresiva extends JFrame {
    private JLabel lblTiempo = new JLabel("5", JLabel.CENTER);
    private JButton btnIniciar = new JButton("Iniciar");
    public CuentaRegresiva() {
        super("Cierre de caja");
        lblTiempo.setFont(new Font("SansSerif", Font.BOLD, 40));
        lblTiempo.setForeground(new Color(0x0B3D6E));
        add(lblTiempo, BorderLayout.CENTER);
        add(btnIniciar, BorderLayout.SOUTH);
        btnIniciar.addActionListener(e -> iniciar());
        setSize(260, 170);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void iniciar() {
        btnIniciar.setEnabled(false);
        new Thread(() -> {
            for (int s = 5; s >= 0; s--) {
                int valor = s;
                SwingUtilities.invokeLater(() ->
                        lblTiempo.setText(String.valueOf(valor)));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    return;
                }
            }
            SwingUtilities.invokeLater(() -> {
                lblTiempo.setText("Caja cerrada");
                lblTiempo.setFont(new Font("SansSerif", Font.BOLD, 22));
                lblTiempo.setForeground(new Color(0xB23A2E));
                btnIniciar.setEnabled(true);
            });
        }).start();
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new
                CuentaRegresiva().setVisible(true));
    }
}