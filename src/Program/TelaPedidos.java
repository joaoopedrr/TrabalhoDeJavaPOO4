package Program;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TelaPedidos extends JFrame {

    private ArrayList<Pedido> pedidos;

    private JTextField campoCodigoCliente;
    private JTextField campoCodigoPedido;
    private JTextField campoDataCompra;
    private JTextField campoValorFinal;
    private JTextField campoNomeLoja;
    private JTextField campoNotaFiscal;
    private JButton botaoAdicionar;

    public TelaPedidos() {
        pedidos = new ArrayList<>();

        setTitle("Pedidos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel painelCampos = new JPanel(new GridLayout(6, 2));
        add(painelCampos, BorderLayout.CENTER);

        campoCodigoCliente = new JTextField();
        painelCampos.add(new JLabel("Código do Cliente:"));
        painelCampos.add(campoCodigoCliente);

        campoCodigoPedido = new JTextField();
        painelCampos.add(new JLabel("Código do Pedido:"));
        painelCampos.add(campoCodigoPedido);

        campoDataCompra = new JTextField();
        painelCampos.add(new JLabel("Data da Compra (dd/mm/aaaa):"));
        painelCampos.add(campoDataCompra);

        campoValorFinal = new JTextField();
        painelCampos.add(new JLabel("Valor Final:"));
        painelCampos.add(campoValorFinal);

        campoNomeLoja = new JTextField();
        painelCampos.add(new JLabel("Nome da Loja:"));
        painelCampos.add(campoNomeLoja);

        campoNotaFiscal = new JTextField();
        painelCampos.add(new JLabel("Nota Fiscal:"));
        painelCampos.add(campoNotaFiscal);

        botaoAdicionar = new JButton("Adicionar Pedido");
        botaoAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarPedido();
            }
        });
        add(botaoAdicionar, BorderLayout.SOUTH);
    }

    public TelaPedidos(MainFrame mainFrame) {
    }

    private void adicionarPedido() {
        String codigo_cliente = campoCodigoCliente.getText();
        String codigo_pedido = campoCodigoPedido.getText();
        String data_compraString = campoDataCompra.getText();
        float valor_final = Float.parseFloat(campoValorFinal.getText());
        String nome_loja = campoNomeLoja.getText();
        String nota_fiscal = campoNotaFiscal.getText();

        Date data_compra = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            data_compra = sdf.parse(data_compraString);
        } catch (ParseException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Formato de data inválido! Use o formato dd/mm/aaaa.");
            return;
        }

        Pedido pedido = new Pedido(codigo_cliente, codigo_pedido, data_compra, valor_final, nome_loja, nota_fiscal);
        pedidos.add(pedido);

        JOptionPane.showMessageDialog(this, "Pedido adicionado com sucesso!");

        limparCampos();
    }

    private void limparCampos() {
        campoCodigoCliente.setText("");
        campoCodigoPedido.setText("");
        campoDataCompra.setText("");
        campoValorFinal.setText("");
        campoNomeLoja.setText("");
        campoNotaFiscal.setText("");
    }

    public static void main(String[] args) {
        TelaPedidos tela = new TelaPedidos();
        tela.setVisible(true);
    }
}
