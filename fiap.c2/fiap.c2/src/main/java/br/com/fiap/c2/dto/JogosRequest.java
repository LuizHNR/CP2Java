package br.com.fiap.c2.dto;

import br.com.fiap.c2.model.Genero;
import jakarta.validation.constraints.*;

import java.util.Date;

public class JogosRequest {
    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 150,
            message = "O nome deve ter entre 3 e 150 caracteres")
    private String nome;
    @NotNull(message = "A data de Lançamento é obrigatório")
    private Date dataLancamento;
    @NotNull(message = "O genero é obrigatório")
    private Genero genero;

    public JogosRequest() {
    }

    public JogosRequest(String nome, Date dataLancamento, Genero genero) {
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.genero = genero;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
