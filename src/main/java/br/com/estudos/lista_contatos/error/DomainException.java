package br.com.estudos.lista_contatos.error;

public class DomainException extends RuntimeException {
    public DomainException(String message) {
        super(message);
    }
}
