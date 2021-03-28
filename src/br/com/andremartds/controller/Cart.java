package br.com.andremartds.controller;

import br.com.andremartds.ioc.Mensagem;
import br.com.andremartds.model.Pessoa;

public class Cart {

    public Mensagem mensagem;

    public Cart(Mensagem mensagem) {
        this.mensagem = mensagem;
    }

    public void checkout(Pessoa pessoa, String mensagem){
        this.mensagem.enviaMensagem(pessoa, mensagem);
    }
}
