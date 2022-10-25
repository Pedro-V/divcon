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
    private Participante participante;
    private Servico servico;

    public Pagamento(Float valorPago) {
        this.valorPago = valorPago;
        servico = new Servico;
        participante = new Participante();
    }
    
    public Bool checaSaldo(Float pagar, Servico servico){
        Float custo = servico.getCusto;
        
    }
    
    public void atualizaSaldo(Servico servico, Pagamento pagamento){
        Float resto = servico.getCusto();
        Float troco = pagamento.recebePagamento();
        Float total = resto - troco;
        servico.setCusto(total);
    }
    
    public Float recebePagamento(Float pagar, Servico servico) {
        Float custo = servico.getCusto();
        Float troco = Float.valueOf(0);
        // Se tiver troco
        if (pagar >= custo) {
            troco = valorPago - custo;
            custo = 0f;
        } else { // se não tiver
            custo -= valorPago;
            troco = 0f;
        }
        return troco;
    }

    /**
    public void atualizarServico(Participante participante, Servico servico){
        preco = atualizarPagamento(participante);
        custo = tabelaServicos.get(servico);
        valorFinal = custo - preco;
        tabelaServicos.put(servico.getNome(), valorFinal);
    }
    */

    public Float getValorPago() {
        return valorPago;
    }

    

}
