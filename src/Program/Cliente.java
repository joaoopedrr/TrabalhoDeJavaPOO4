package Program;

public class Cliente {
    String cpf;
    String estado;
    String cidade;
    String bairro;
    String rua;
    String codigo_pedido;
    String nome;
    String codigo_cliente;

    public Cliente(String cpf, String estado, String cidade, String bairro, String rua, String codigo_pedido, String nome, String codigo_cliente) {
        this.cpf = cpf;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.codigo_pedido = codigo_pedido;
        this.nome = nome;
        this.codigo_cliente = codigo_cliente;
    }

    // Getters e Setters
}
