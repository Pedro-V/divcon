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
        servico = new Servico();
        participante = new Participante();
    }
    
    public boolean checaSaldo(Float pagar, Participante participante){
        Float saldo = participante.getSaldoIndividual();
        boolean x = (pagar > saldo);
        if (x == true) {
            System.out.println("Saldo insuficiente para realizar pagamento");
        } else {
            System.out.println("O pagamento pode ser realizado");
        }
        
        return x;
    }
    
    public void atualizaCusto(Servico servico, Pagamento pagamento){
        Float resto = servico.getCusto();
        Float troco = pagamento.recebePagamento(servico);
        Float total = resto - troco;
        servico.setCusto(total);
    }
    
    public Float recebePagamento(Servico servico) {
        Float pagar = getvalorPago();
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

    public Float getValorPago() {
        return valorPago;
    }

    

}
