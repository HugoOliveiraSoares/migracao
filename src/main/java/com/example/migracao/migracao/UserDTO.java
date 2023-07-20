package com.example.migracao.migracao;

public class UserDTO {

    private String nome;
    private String cpf;

    public UserDTO() {
    }

    public UserData convert(){
        return new UserData(this.nome, this.cpf);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
