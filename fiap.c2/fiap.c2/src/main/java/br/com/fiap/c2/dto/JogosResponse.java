package br.com.fiap.c2.dto;

import org.springframework.hateoas.Link;

public record JogosResponse(Long id, String nome, Link link) {
}
