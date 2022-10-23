package test;

import org.junit.Test;
import divcon.Servico;;

public class ServicoTest {
    @Test
    public void testEstaPago() {
        Servico servicoTeste = new Servico("!azx/_S123Z", "1002,22");
        servicoTeste.recebePagamento(null);
    }

    @Test
    public void testRecebePagamento() {

    }
}
