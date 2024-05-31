package Program;

import java.util.Date;

public class Pedido {
    private String codigo_cliente;
    private String codigo_pedido;
    private Date data_compra;
    private float valor_final;
    private String nome_loja;
    private String nota_fiscal;

    // Construtor com parâmetros
    public Pedido(String codigo_cliente, String codigo_pedido, Date data_compra, float valor_final, String nome_loja, String nota_fiscal) {
        this.codigo_cliente = codigo_cliente;
        this.codigo_pedido = codigo_pedido;
        this.data_compra = data_compra;
        this.valor_final = valor_final;
        this.nome_loja = nome_loja;
        this.nota_fiscal = nota_fiscal;
    }

    // Getters e Setters (opcional, mas recomendado)
    // ...

    public String getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(String codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    public String getCodigo_pedido() {
        return codigo_pedido;
    }

    public void setCodigo_pedido(String codigo_pedido) {
        this.codigo_pedido = codigo_pedido;
    }

    public Date getData_compra() {
        return data_compra;
    }

    public void setData_compra(Date data_compra) {
        this.data_compra = data_compra;
    }

    public float getValor_final() {
        return valor_final;
    }

    public void setValor_final(float valor_final) {
        this.valor_final = valor_final;
    }

    public String getNome_loja() {
        return nome_loja;
    }

    public void setNome_loja(String nome_loja) {
        this.nome_loja = nome_loja;
    }

    public String getNota_fiscal() {
        return nota_fiscal;
    }

    public void setNota_fiscal(String nota_fiscal) {
        this.nota_fiscal = nota_fiscal;
    }
}
