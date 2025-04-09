package br.com.fiap.c2.service;



import br.com.fiap.c2.controller.UsuarioController;
import br.com.fiap.c2.dto.UsuarioRequest;
import br.com.fiap.c2.dto.UsuarioResponse;
import br.com.fiap.c2.model.Usuario;
import br.com.fiap.c2.repository.UsuarioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
//    @Autowired
//    ClienteRepository clienteRepository;

    public Usuario requestToCliente(UsuarioRequest clienteRequest) {
        return new Usuario(null,
                clienteRequest.getNome(),
                clienteRequest.getIdade(),
                clienteRequest.getEmail(),
                clienteRequest.getSenha());
    }

    public UsuarioRequest usuarioToResponse(Usuario usuario, boolean self) {
        Link link;
        if (self) {
            link = linkTo(
                    methodOn(
                            UsuarioController.class
                    ).readCliente(usuario.getId())
            ).withSelfRel();
        } else {
            link = linkTo(
                    methodOn(
                            UsuarioController.class
                    ).readClientes(0)
            ).withRel("Lista de Usuarios");
        }
        return new UsuarioResponse(usuario.getId(), usuario.getNome(), link);
    }

    public List<ClienteResponse> clientesToResponse(List<Cliente> clientes) {
        List<ClienteResponse> clientesResponse = new ArrayList<>();
        for (Cliente cliente : clientes) {
            clientesResponse.add(clienteToResponse(cliente, true));
        }
        return clientesResponse;
        // return clientes.stream().map(this::clienteToResponse).collect(Collectors.toList());
    }

    public Page<ClienteResponse> findAll(Pageable pageable) {
        // busca os clientes de acordo com a configuração do pageable,
        // converte para response e retorna como um Page<ClienteResponse>
        return clienteRepository.findAll(pageable)
                .map(cliente -> clienteToResponse(cliente, true));
        //return clienteRepository.findAll(pageable).map(this::clienteToResponse);
    }
}