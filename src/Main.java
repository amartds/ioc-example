import br.com.andremartds.controller.Cart;
import br.com.andremartds.ioc.Mensagem;
import br.com.andremartds.model.Pessoa;
import br.com.andremartds.service.EnvioEmailService;
import br.com.andremartds.service.EnvioMensagemService;

public class Main {

    public static void main(String[] args) {
        Pessoa Roberto = new Pessoa("Roberto", "33", "00000000000");
        Pessoa Ana = new Pessoa("Ana", "10", "111111111111");

        // Mensagem ees = new EnvioMensagemService();
        Mensagem ees = new EnvioEmailService();

        Cart cart = new Cart(ees);

        cart.checkout(Roberto, " Parabens por sua compra ");
        System.out.println();
        cart.checkout(Ana, " Parabens por sua compra ");

    }
}
