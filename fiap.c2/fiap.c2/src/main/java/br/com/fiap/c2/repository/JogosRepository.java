package br.com.fiap.c2.repository;

import br.com.fiap.c2.model.Jogos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class JogosRepository extends JpaRepository<Jogos, Long> {
}
