package br.com.estudos.lista_contatos.service;

import br.com.estudos.lista_contatos.model.Contato;
import br.com.estudos.lista_contatos.repository.ContatoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    private final ContatoRepository repository;

    public ContatoService(ContatoRepository repository){
        this.repository = repository;
    }

    public Contato salvar(Contato contato){
        return repository.save(contato);
    }

    public List<Contato> listar(){
        return repository.findByAtivoTrue();
    }

    public void inativar(Contato contato){
        contato.setAtivo(false);
        repository.save(contato);
    }

}
