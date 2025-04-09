package br.com.fiap.c2.dto;

import jakarta.validation.constraints.*;

public class UsuarioRequest {
    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 150,
            message = "O nome deve ter entre 3 e 150 caracteres")
    private String nome;
    @Min(value = 18,
            message = "O cliente deve ter no mínimo 18 anos")
    private int idade;
    @Email(message = "Email fora do formato correto")
    private String email;
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@!,#])[A-Za-z\\d\\W]{8,}$",
            message = "A senha deve conter no mínimo 8 caracteres, letras maiúsculas e minúsculas, números e caracteres especiais (@!,#)")
    private String senha;

    public UsuarioRequest() {
    }

    public UsuarioRequest(String nome, int idade, String email, String senha) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.senha = senha;

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
}
