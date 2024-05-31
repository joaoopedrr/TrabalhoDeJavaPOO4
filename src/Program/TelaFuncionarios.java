package Program;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TelaFuncionarios extends JFrame {
    private ArrayList<Funcionario> funcionarios;

    public TelaFuncionarios(JFrame telaAnterior) {
        funcionarios = new ArrayList<>();

        setTitle("CRUD Funcionarios");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 4));

        JButton btnAdicionar = new JButton("Adicionar");
        btnAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adicionarFuncionario();
            }
        });

        JButton btnAtualizar = new JButton("Atualizar");
        btnAtualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                atualizarFuncionario();
            }
        });

        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                excluirFuncionario();
            }
        });

        JButton btnListar = new JButton("Listar");
        btnListar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listarFuncionarios();
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

    private void adicionarFuncionario() {
        // Código para adicionar funcionario
        String cpf = JOptionPane.showInputDialog(this, "CPF:");
        String nome = JOptionPane.showInputDialog(this, "Nome:");
        float salario = Float.parseFloat(JOptionPane.showInputDialog(this, "Salário:"));
        String funcao = JOptionPane.showInputDialog(this, "Função:");

        Funcionario funcionario = new Funcionario(cpf, nome, salario, funcao);
        funcionarios.add(funcionario);

        JOptionPane.showMessageDialog(this, "Funcionario adicionado com sucesso!");
    }

    private void atualizarFuncionario() {
        // Código para atualizar funcionario
        String cpf = JOptionPane.showInputDialog(this, "Informe o CPF do funcionario a ser atualizado:");
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCpf().equals(cpf)) {
                funcionario.setNome(JOptionPane.showInputDialog(this, "Nome:", funcionario.getNome()));
                funcionario.setSalario(Float.parseFloat(JOptionPane.showInputDialog(this, "Salário:", funcionario.getSalario())));
                funcionario.setFuncao(JOptionPane.showInputDialog(this, "Função:", funcionario.getFuncao()));

                JOptionPane.showMessageDialog(this, "Funcionario atualizado com sucesso!");
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Funcionario não encontrado!");
    }

    private void excluirFuncionario() {
        // Código para excluir funcionario
        String cpf = JOptionPane.showInputDialog(this, "Informe o CPF do funcionario a ser excluído:");
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCpf().equals(cpf)) {
                funcionarios.remove(funcionario);
                JOptionPane.showMessageDialog(this, "Funcionario excluído com sucesso!");
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Funcionario não encontrado!");
    }

    private void listarFuncionarios() {
        // Código para listar funcionarios
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        StringBuilder sb = new StringBuilder();
        for (Funcionario funcionario : funcionarios) {
            sb.append("CPF: ").append(funcionario.getCpf()).append("\n");
            sb.append("Nome: ").append(funcionario.getNome()).append("\n");
            sb.append("Salário: ").append(funcionario.getSalario()).append("\n");
            sb.append("Função: ").append(funcionario.getFuncao()).append("\n\n");
        }
        textArea.setText(sb.toString());
        JOptionPane.showMessageDialog(this, new JScrollPane(textArea), "Lista de Funcionarios", JOptionPane.INFORMATION_MESSAGE);
    }
}
