package models;
import java.time.LocalDate;

public class Pessoa {
    private String nome;
    private LocalDate dataNascimento;

    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public void setNome(String nome) {this.nome = nome;}
    public String getNome() { return nome; }

    public void setdataNascimento(LocalDate dataNascimento) {this.dataNascimento = dataNascimento;}
    public LocalDate getDataNascimento() { return dataNascimento; }
}
