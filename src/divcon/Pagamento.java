package divcon;

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
    private ContaColetiva conta;

    public Pagamento(Float valorPago, ContaColetiva conta, Participante participante, Servico servico) {
        this.valorPago = valorPago;
        this.participante = participante;
        this.servico = servico;
        this.conta = conta;
    }
    
    /**
     * Checa se é possível pagar o serviço, parcial ou totalmente, com o
     * valor do pagamento.
     * @return
     */
    public boolean podePagar() {
        Float saldo = participante.getSaldoIndividual();
        return saldo >= valorPago;
    }

    /**
     * Esse método subtrai uma dada quantia do custo do serviço
     * e retorna o status quanto ao sucesso da operação
     * @return um booleano que é true se a operação de pagamento
     * tiver sido efetuada com sucesso e false caso contrário
     */
    public boolean pagaServico() {
        if (!podePagar()) {
            return false;
        }
        Float custo = servico.getCusto();
        Float troco = Float.valueOf(0);
        // Se tiver troco
        if (valorPago >= custo) {
            troco = valorPago - custo;
            custo = 0f;
        } else { // se não tiver
            custo -= valorPago;
            troco = 0f;
        }
        // Atualizamos o custo do serviço
        servico.setCusto(custo);
        // e atualizamos o troco no saldo do participante.
        atualizaSaldoParticipante(troco);
        return true;
    }
    
    /**
     * Atualiza o saldoIndividual do participante que fez o pagamento
     * Se tiver troco, descontamentos ele da subtração
     * @param troco O troco que é descontado do valor a ser subtraído do
     * saldo individual
     */
    public void atualizaSaldoParticipante(Float troco) {
        Float saldoLiquido = valorPago - troco;
        participante.subtraiSaldoIndividual(saldoLiquido);
    }

    /**
     * Retira o serviço da tabela de serviços caso ele já tenha sido pago
     */
    public void retiraServicoPago() {
        if (servico.estaPago()) {
            conta.removeServico(servico.getNome());
        }
    }

    public Float getValorPago() {
        return valorPago;
    }
}
