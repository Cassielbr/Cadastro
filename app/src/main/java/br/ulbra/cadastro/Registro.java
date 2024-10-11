package br.ulbra.cadastro;

public class Registro {
    private String nome;
    private String telefone;
    private String endereco;

    public Registro(String nome, String telefone, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }
}
