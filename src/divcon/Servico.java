package divcon;

/**
 * A classe {@code Servico} encapsula os serviços aos quais as pessoas
 * usuárias da conta coletiva podem fazer uso e desejarem pagar
 * Podem ser serviços como intenet, supermercado, água, luz, etc
 */
public class Servico {
    private String nome;
    private Float custo;

    public Servico(String nome, Float custo) {
        this.nome = nome;
        this.custo = custo;
    }

    public boolean estaPago() {
        return custo == 0f;
    }

    public String infoSummary() {
        return nome + ". Valor ainda a pagar: R$ " + custo.toString();
    }

    /**
     * Esse método subtrai uma dada quantia do custo do serviço
     * @param pagamento é o objeto pagamento que contêm as informações do tipo e da quantia a pagar
     * @return o troco da operação de pagamento
     */
    public Float recebePagamento(Pagamento pagamento) {
        Float valorPago = pagamento.getValor_pago();
        Float troco = Float.valueOf(0);
        // Se tiver troco
        if (valorPago >= custo) {
            troco = valorPago - custo;
            custo = 0f;
        } else { // se não tiver
            custo -= valorPago;
            troco = 0f;
        }
        return troco;
    }
}
