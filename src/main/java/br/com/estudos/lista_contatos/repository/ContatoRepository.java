package br.com.estudos.lista_contatos.repository;

import br.com.estudos.lista_contatos.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
}
