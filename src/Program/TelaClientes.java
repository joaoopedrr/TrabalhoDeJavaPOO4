package Program;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TelaClientes extends JFrame {
    private ArrayList<Cliente> clientes;

    public TelaClientes(JFrame telaAnterior) {
        clientes = new ArrayList<>();

        setTitle("CRUD Clientes");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 4));

        JButton btnAdicionar = new JButton("Adicionar");
        btnAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adicionarCliente();
            }
        });

        JButton btnAtualizar = new JButton("Atualizar");
        btnAtualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                atualizarCliente();
            }
        });

        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                excluirCliente();
            }
        });

        JButton btnListar = new JButton("Listar");
        btnListar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listarClientes();
            }
        });

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                telaAnterior.setVisible(true);
                dispose();
            }
        });

        panel.add(btnAdicionar);
        panel.add(btnAtualizar);
        panel.add(btnExcluir);
        panel.add(btnListar);
        add(panel, BorderLayout.NORTH);

        add(btnVoltar, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
    }

    private void adicionarCliente() {
        // Código para adicionar cliente
        String cpf = JOptionPane.showInputDialog(this, "CPF:");
        String estado = JOptionPane.showInputDialog(this, "Estado:");
        String cidade = JOptionPane.showInputDialog(this, "Cidade:");
        String bairro = JOptionPane.showInputDialog(this, "Bairro:");
        String rua = JOptionPane.showInputDialog(this, "Rua:");
        String codigoPedido = JOptionPane.showInputDialog(this, "Código do Pedido:");
        String nome = JOptionPane.showInputDialog(this, "Nome:");
        String codigoCliente = JOptionPane.showInputDialog(this, "Código do Cliente:");

        Cliente cliente = new Cliente(cpf, estado, cidade, bairro, rua, codigoPedido, nome, codigoCliente);
        clientes.add(cliente);

        JOptionPane.showMessageDialog(this, "Cliente adicionado com sucesso!");
    }

    private void atualizarCliente() {
        // Código para atualizar cliente
        String cpf = JOptionPane.showInputDialog(this, "Informe o CPF do cliente a ser atualizado:");
        for (Cliente cliente : clientes) {
            if (cliente.cpf.equals(cpf)) {
                cliente.estado = JOptionPane.showInputDialog(this, "Estado:", cliente.estado);
                cliente.cidade = JOptionPane.showInputDialog(this, "Cidade:", cliente.cidade);
                cliente.bairro = JOptionPane.showInputDialog(this, "Bairro:", cliente.bairro);
                cliente.rua = JOptionPane.showInputDialog(this, "Rua:", cliente.rua);
                cliente.codigo_pedido = JOptionPane.showInputDialog(this, "Código do Pedido:", cliente.codigo_pedido);
                cliente.nome = JOptionPane.showInputDialog(this, "Nome:", cliente.nome);
                cliente.codigo_cliente = JOptionPane.showInputDialog(this, "Código do Cliente:", cliente.codigo_cliente);

                JOptionPane.showMessageDialog(this, "Cliente atualizado com sucesso!");
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Cliente não encontrado!");
    }

    private void excluirCliente() {
        // Código para excluir cliente
        String cpf = JOptionPane.showInputDialog(this, "Informe o CPF do cliente a ser excluído:");
        for (Cliente cliente : clientes) {
            if (cliente.cpf.equals(cpf)) {
                clientes.remove(cliente);
                JOptionPane.showMessageDialog(this, "Cliente excluído com sucesso!");
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Cliente não encontrado!");
    }

    private void listarClientes() {
        // Código para listar clientes
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        StringBuilder sb = new StringBuilder();
        for (Cliente cliente : clientes) {
            sb.append("CPF: ").append(cliente.cpf).append("\n");
            sb.append("Estado: ").append(cliente.estado).append("\n");
            sb.append("Cidade: ").append(cliente.cidade).append("\n");
            sb.append("Bairro: ").append(cliente.bairro).append("\n");
            sb.append("Rua: ").append(cliente.rua).append("\n");
            sb.append("Código do Pedido: ").append(cliente.codigo_pedido).append("\n");
            sb.append("Nome: ").append(cliente.nome).append("\n");
            sb.append("Código do Cliente: ").append(cliente.codigo_cliente).append("\n\n");
        }
        textArea.setText(sb.toString());
        JOptionPane.showMessageDialog(this, new JScrollPane(textArea), "Lista de Clientes", JOptionPane.INFORMATION_MESSAGE);
    }
}
