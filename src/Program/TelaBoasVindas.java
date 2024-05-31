package Program;

import javax.swing.*;
import java.awt.*;

public class TelaBoasVindas extends JFrame {

    public TelaBoasVindas() {
        setTitle("Bem-vindo à Loja de Livros");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Bem-vindo à nossa Loja de Livros!");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        add(label, BorderLayout.CENTER);

        JButton btnContinuar = new JButton("Continuar");
        btnContinuar.addActionListener(e -> {
            new MainFrame().setVisible(true);
            dispose();
        });
        add(btnContinuar, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new TelaBoasVindas().setVisible(true);
    }
}
