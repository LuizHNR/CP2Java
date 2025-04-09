package br.com.fiap.c2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/usuarios", produces = {"application/json"})
@Tag(name = "api-steamVerde")
public class UsuarioController {
}
