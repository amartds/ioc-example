package br.com.andremartds.ioc;

import br.com.andremartds.model.Pessoa;

public interface Mensagem {

    void enviaMensagem(Pessoa pessoa, String mensagem);

}
