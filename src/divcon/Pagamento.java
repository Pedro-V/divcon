package divcon;

import java.util.HashMap;
/**
 * A classe {@code Pagamento} é uma classe pai para os diferentes tipos
 * de pagamento: {@code Pix}, {@code CartaoCredito}, {@code CartaoDebito}.
 * Ela encapsula informações e comportamentos do ato de pagar uma conta
 * e também de adicionar dinheiro no saldo individual de um {@code 
 * Participante}.
 */
public class Pagamento {
    private Float valorPago;
    private HashMap<Participante, valorPago> tabelaPagantes;
    private HashMap<Servico, Float> tabelaServicos;
    private Servico servico;

    public Pagamento(Float valor_atual, Float valor_pago, HashMap<Participante, Float> tabelaPagantes) {
        this.valor_pago = valor_pago;
        this.tabelaPagantes = tabelaPagantes;
        this.tabelaServicos = tabelaServicos;
    }
    
    public Float retornaCusto(Servico servico){
        return tabelaServicos.get(servico)
    }
    
    
    public void adicionaPagamento(Participante participante, Float valor){
        valor = 450.0;
        tabelaPagantes.put(participante.getNome(), valor);
    }

    public void atualizarServico(Participante participante, Servico servico){
        preco = atualizarPagamento(participante);
        custo = tabelaServicos.get(servico);
        valorFinal = custo - preco;
        tabelaServicos.put(servico.getNome(), valorFinal)
    }

    /**
    public void atualizaSaldo(){
        return;
    }
    */
    
    /**
    public void realizaPagamento(){
        return;
    }
    */

    public Float getValorPago() {
        return valorPago;
    }

    

}
