package br.com.estudos.lista_contatos.web;

import br.com.estudos.lista_contatos.model.CategoriaContato;
import br.com.estudos.lista_contatos.model.Contato;
import br.com.estudos.lista_contatos.service.ContatoService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component("contatoBean")
@ViewScoped
public class ContatoBean implements Serializable {

    private final ContatoService contatoService;

    private static final long serialVersionUID = 1L;

    private Contato contato = new Contato();
    private Contato contatoSalvo;
    private List<Contato> contatos;

    @PostConstruct
    public void inicializar(){
        this.contatos = contatoService.listar();
    }

    public ContatoBean(ContatoService contatoService){
        this.contatoService = contatoService;
    }

    public void salvar() {

        boolean editando = isEditando();

        this.contatoSalvo = contatoService.salvar(contato);
        this.contato = new Contato();
        this.contatos = contatoService.listar();

        if(editando){
            adicionarMensagemSucesso("Contato atualizado com sucesso");
        }else{
            adicionarMensagemSucesso("Contato salvo com sucesso");
        }

    }

    public Contato getContato(){
        return this.contato;
    }

    public Contato getContatoSalvo(){
        return contatoSalvo;
    }

    public List<Contato> getContatos(){
        return contatos;
    }

    public CategoriaContato[] getCategorias(){
        return CategoriaContato.values();
    }

    public void deletarContato(Contato contato){
        contatoService.inativar(contato);
        this.contatos = contatoService.listar();

        adicionarMensagemSucesso("Contato excluído com sucesso");
    }

    public void editarContato(Contato contato){
        this.contato = contato;
        this.contatoSalvo = null;
    }

    public boolean isEditando(){
        return this.contato != null && this.contato.getId() != null;
    }

    public void cancelarEdicao(){
        this.contato = new Contato();
        this.contatos = contatoService.listar();
    }

    private void adicionarMensagemSucesso(String mensagem){
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, null));
    }
}
