package br.com.fiap.c2.model;

import jakarta.persistence.*;

import java.util.List;

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;
    private String email;
    private String senha;
    @ManyToMany
    @JoinTable(name = "jogos_usuario",
            joinColumns = @JoinColumn(name = "id_jogos", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "id"))
    private List<Jogos> carrinho;


    public Usuario() {
    }

    public Usuario(Long id, String nome, int idade, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.senha = senha;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Jogos> getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(List<Jogos> carrinho) {
        this.carrinho = carrinho;
    }
}
