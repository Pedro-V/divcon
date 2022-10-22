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
    private HashMap<Participante, Float> tabelaPagantes;
    private HashMap<Servico, Float> tabelaServicos;
    private Servico servico;

    public Pagamento(Float valor_atual, Float valorPago, HashMap<Participante, Float> tabelaPagantes) {
        this.valorPago = valorPago;
        this.tabelaPagantes = tabelaPagantes;
        //this.tabelaServicos = tabelaServicos;
    }
    
    public Float retornaCusto(Servico servico){
        return tabelaServicos.get(servico);
    }
    
    
    public void adicionaPagamento(Participante participante, Float valor){
        valor = Float.valueOf(450);
        tabelaPagantes.put(participante, valor);
    }

    /*
    public void atualizarServico(Participante participante, Servico servico){
        preco = atualizarPagamento(participante);
        custo = tabelaServicos.get(servico);
        valorFinal = custo - preco;
        tabelaServicos.put(servico.getNome(), valorFinal);
    }
    */
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
