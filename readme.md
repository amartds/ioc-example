## Exemplo de inversão de controle

Um grande problema que temos é a interdependência dentro de uma aplicação,
o alto acoplamento faz com que cada mudança no código seja extremamente trabalhosa
dolorida e muitas vezes cansativa.

Para ilustrar imagine que vai enviar uma mensagem via sms para determinado cliente que
fez uma compra na aplicação, mas em determinado momento foi solicitado que, a partir de
agora seja enviado por email para o cliente, a instância de EnvioMensagemService 
dentro do seu controlador agora precisa ser outra, nesse caso a de EnvioEmailService, 
isso não está correto.

Quanto menos uma classe conhecer a outra melhor seria, como resolvemos?

Vamos utilizar polimorfismo.

Vamos criar uma Interface responsável pelo contrato.

```java
public interface Mensagem {
    void enviaMensagem(Pessoa pessoa, String mensagem);
}
```

Agora podemos implementar esse contrato dentro de EnvioMensagemService e EnvioEmailService.

```java
public class EnvioMensagemService implements Mensagem {

    @Override
    public void enviaMensagem(Pessoa pessoa, String mensagem) {
        System.out.print(pessoa.getNome() + " - " + pessoa.getIdade() + " - " + mensagem);
    }
}
```

```java
public class EnvioEmailService implements Mensagem {

    @Override
    public void enviaMensagem(Pessoa pessoa, String mensagem) {
        System.out.print(pessoa.getNome() + " - " + pessoa.getIdade() + " - " + mensagem);
    }
}
```

Por fim vamos deixar o controller agnóstico em sentido de não saber quem será a instância para
fazer o envio.

```java
public class Cart {

    public Mensagem mensagem;

    public Cart(Mensagem mensagem) {
        this.mensagem = mensagem;
    }

    public void checkout(Pessoa pessoa, String mensagem){
        this.mensagem.enviaMensagem(pessoa, mensagem);
    }
}
```
O caso contrário seria
```java
public class Cart {

    public void checkout(Pessoa pessoa, String mensagem){
        EnvioEmailService envioEmailService = new EnvioEmailService();
        envioEmailService.enviaMensagem(pessoa, mensagem);
        
        // ou 

        EnvioMensagemService envioMensagemService = new EnvioMensagemService();
        EnvioMensagemService.enviaMensagem(pessoa, mensagem);
    }
}
```

Consegue perceber as vantagens? não utilizamos um CDI ou Spring para fazer a inversão de controle,
mas mesmo com Java puro ainda fica bonito.