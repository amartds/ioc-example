package br.com.andremartds.service;

import br.com.andremartds.ioc.Mensagem;
import br.com.andremartds.model.Pessoa;

public class EnvioEmailService implements Mensagem {

    @Override
    public void enviaMensagem(Pessoa pessoa, String mensagem) {
        System.out.print(pessoa.getNome() + " - " + pessoa.getIdade() + " - " + mensagem);
    }

}
