package Program;

public class Funcionario {
    private String cpf;
    private String nome;
    private float salario;
    private String funcao;

    public Funcionario(String cpf, String nome, float salario, String funcao) {
        this.cpf = cpf;
        this.nome = nome;
        this.salario = salario;
        this.funcao = funcao;
    }

    // Getters e Setters

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}
