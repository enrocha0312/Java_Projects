package Entities;

/**
 * @author Eduardo
 * Classe Pessoa baseada no Excel
 * Idade, nome, cidade, escolaridade, sexo
 */
public class Pessoa {

    private Integer idade;

    private String nome;

    private String cidade;

    private String escolaridade;

    private Character sexo;

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public Pessoa() {
    }

    public Pessoa(Integer idade, String nome, String cidade, String escolaridade, Character sexo) {
        this.idade = idade;
        this.nome = nome;
        this.cidade = cidade;
        this.escolaridade = escolaridade;
        this.sexo = sexo;
    }
}
