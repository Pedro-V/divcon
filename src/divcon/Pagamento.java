package divcon;

import java.util.HashMap;

public class Pagamento {
    protected boolean formaPagamento;
    protected Float valor_atual;
    protected Float valor_pago;
    protected HashMap<Participante, Float> tre;

    
    public Float pegarPagamento(Participante participante){
        return tre.get(participante);
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
        getSaldoIndividual();
    }
    
    public void realizaPagamento(){
        
    }
    public void setForma_pagamento(Bool forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
    }

    public Float getValor_atual() {
        return valor_atual;
    }

    public void setValor_atual(Float valor_atual) {
        this.valor_atual = valor_atual;
    }

    public Float getValor_pago() {
        return valor_pago;
    }

    public void setValor_pago(Float valor_pago) {
        this.valor_pago = valor_pago;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Pagamento(Float valor_atual, Float valor_pago, HashMap<Participante, Float> tre) {
        this.valor_atual = valor_atual;
        this.valor_pago = valor_pago;
        this.tre = tre;
    }

}