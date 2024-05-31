package Program;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TelaLivros extends JFrame {
    private ArrayList<Livro> livros;

    public TelaLivros(JFrame telaAnterior) {
        livros = new ArrayList<>();

        setTitle("CRUD Livros");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 4));

        JButton btnAdicionar = new JButton("Adicionar");
        btnAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adicionarLivro();
            }
        });

        JButton btnAtualizar = new JButton("Atualizar");
        btnAtualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                atualizarLivro();
            }
        });

        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                excluirLivro();
            }
        });

        JButton btnListar = new JButton("Listar");
        btnListar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listarLivros();
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

    private void adicionarLivro() {
        String titulo = JOptionPane.showInputDialog(this, "Título:");
        String autor = JOptionPane.showInputDialog(this, "Autor:");
        String editora = JOptionPane.showInputDialog(this, "Editora:");
        String anoPublicacao = JOptionPane.showInputDialog(this, "Ano de Publicação:");
        String codigoLivro = JOptionPane.showInputDialog(this, "Código do Livro:");
        String genero = JOptionPane.showInputDialog(this, "Gênero:");

        Livro livro = new Livro(titulo, autor, editora, anoPublicacao, codigoLivro, genero);
        livros.add(livro);

        JOptionPane.showMessageDialog(this, "Livro adicionado com sucesso!");
    }

    private void atualizarLivro() {
        String codigoLivro = JOptionPane.showInputDialog(this, "Informe o Código do livro a ser atualizado:");
        for (Livro livro : livros) {
            if (livro.getCodigoLivro().equals(codigoLivro)) {
                livro.setTitulo(JOptionPane.showInputDialog(this, "Título:", livro.getTitulo()));
                livro.setAutor(JOptionPane.showInputDialog(this, "Autor:", livro.getAutor()));
                livro.setEditora(JOptionPane.showInputDialog(this, "Editora:", livro.getEditora()));
                livro.setAnoPublicacao(JOptionPane.showInputDialog(this, "Ano de Publicação:", livro.getAnoPublicacao()));
                livro.setGenero(JOptionPane.showInputDialog(this, "Gênero:", livro.getGenero()));

                JOptionPane.showMessageDialog(this, "Livro atualizado com sucesso!");
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Livro não encontrado!");
    }

    private void excluirLivro() {
        String codigoLivro = JOptionPane.showInputDialog(this, "Informe o Código do livro a ser excluído:");
        for (Livro livro : livros) {
            if (livro.getCodigoLivro().equals(codigoLivro)) {
                livros.remove(livro);
                JOptionPane.showMessageDialog(this, "Livro excluído com sucesso!");
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Livro não encontrado!");
    }

    private void listarLivros() {
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        StringBuilder sb = new StringBuilder();
        for (Livro livro : livros) {
            sb.append("Título: ").append(livro.getTitulo()).append("\n");
            sb.append("Autor: ").append(livro.getAutor()).append("\n");
            sb.append("Editora: ").append(livro.getEditora()).append("\n");
            sb.append("Ano de Publicação: ").append(livro.getAnoPublicacao()).append("\n");
            sb.append("Código do Livro: ").append(livro.getCodigoLivro()).append("\n");
            sb.append("Gênero: ").append(livro.getGenero()).append("\n\n");
        }
        textArea.setText(sb.toString());
        JOptionPane.showMessageDialog(this, new JScrollPane(textArea), "Lista de Livros", JOptionPane.INFORMATION_MESSAGE);
    }
}

