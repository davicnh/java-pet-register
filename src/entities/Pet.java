package entities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pet {
    private String nome;
    private String sobrenome;
    private Tipo tipo;
    private Sexo sexo;
    private Integer numCasa;
    private String cidade;
    private String rua;
    private Double idade;
    private Double peso;
    private String raca;

    public Pet(String nome, String sobrenome, Tipo tipo, Sexo sexo, Integer numCasa, String cidade, String rua, Double idade, Double peso, String raca) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.tipo = tipo;
        this.sexo = sexo;
        this.numCasa = numCasa;
        this.cidade = cidade;
        this.rua = rua;
        this.idade = idade;
        this.peso = peso;
        this.raca = raca;
    }

    public Double getIdade() {
        return idade;
    }

    public void setIdade(Double idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Integer getNumCasa() {
        return numCasa;
    }

    public void setNumCasa(Integer numCasa) {
        this.numCasa = numCasa;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void salvarPet() {
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm");
        String dataHora = agora.format(formato);
        String nomeArquivo = getNome().toUpperCase() + getSobrenome().toUpperCase();
        nomeArquivo = dataHora + "-" + nomeArquivo + ".TXT";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("petsCadastrados/" + nomeArquivo))) {
            bw.write("1 - " + getNome() + " " + getSobrenome());
            bw.newLine();
            bw.write("2 - " + getTipo());
            bw.newLine();
            bw.write("3 - " + getSexo());
            bw.newLine();
            bw.write("4 - " + getRua() + ", " + getNumCasa() + ", " + getCidade());
            bw.newLine();
            bw.write("5 - " + getIdade() + " anos");
            bw.newLine();
            bw.write("6 - " + getPeso() + "kg");
            bw.newLine();
            bw.write("7 - " + getRaca());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
