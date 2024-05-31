package Program;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("Loja de Livros");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1));

        JButton btnClientes = new JButton("Clientes");
        btnClientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TelaClientes(MainFrame.this).setVisible(true);
                setVisible(false);
            }
        });

        JButton btnFuncionarios = new JButton("Funcionarios");
        btnFuncionarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TelaFuncionarios(MainFrame.this).setVisible(true);
                setVisible(false);
            }
        });

        JButton btnLivros = new JButton("Livros");
        btnLivros.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TelaLivros(MainFrame.this).setVisible(true);
                setVisible(false);
            }
        });

        JButton btnPedidos = new JButton("Pedidos");
        btnPedidos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TelaPedidos(MainFrame.this).setVisible(true);
                setVisible(false);
            }
        });

        add(btnClientes);
        add(btnFuncionarios);
        add(btnLivros);
        add(btnPedidos);

        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new MainFrame().setVisible(true);
    }
}
