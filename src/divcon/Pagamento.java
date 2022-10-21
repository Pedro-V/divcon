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
    protected boolean formaPagamento;
    protected Float valor_atual;
    protected Float valor_pago;
    protected HashMap<Participante, Float> tabelaPagantes;

    public Pagamento(Float valor_atual, Float valor_pago, HashMap<Participante, Float> tabelaPagantes) {
        this.valor_atual = valor_atual;
        this.valor_pago = valor_pago;
        this.tabelaPagantes = tabelaPagantes;
    }
    
    public Float pegarPagamento(Participante participante){
        return tabelaPagantes.get(participante);
    }


    public void informaPagamento(){
        if (formaPagamento) {
            System.out.println("Pagamento em débito");
        } else {
            System.out.println("Pagamento em crédito");
        }
    }

    public Float atualizarPagamento(Participante participante){
        valor_pago = valor_pago + pegarPagamento(participante);
        return valor_pago;
    }

    public void atualizarConta(Participante participante, Float valor_atual, Float valor_pago){
        valor_pago = atualizarPagamento(participante);
        this.valor_atual = valor_atual - valor_pago;
    }

    public void atualizaSaldo(){
        return;
    }
    
    public void realizaPagamento(){
        return;
    }

    public Float getValor_atual() {
        return valor_atual;
    }

    public Float getValor_pago() {
        return valor_pago;
    }

    

}