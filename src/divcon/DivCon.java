package divcon;

import java.util.*;
/**
 * A classe {@code DivCon} é responsável por administrar uma lista dos participantes,
 * das contas, e também do participante e da conta logados no momento na aplicação.
 * Ela administra a entrada e saída de usuários, devendo evitar que usuários que não
 * pertençam a uma dada {@code Conta} não possam entrar nela.
 */
public class DivCon {
    private HashMap<String, ContaColetiva> contas;
    // Esse HashMap tem como chave o nome dos participantes já criados nessa sessão
    private HashMap<String, Participante> participantes;
    // Essa é a conta atual que está logada/ativa na aplicação
    private Participante participanteLogado;
    private ContaColetiva contaLogada;

    public DivCon() {
        contas = new HashMap<>();
        participantes = new HashMap<>();
    }

    public ContaColetiva addConta(String nome, String descricao) {
        ContaColetiva novaConta = new ContaColetiva(nome, descricao);
        // Se o participante logado cria uma conta, ele automaticamente está dentro dela
        novaConta.addParticipante(participanteLogado);
        contas.put(nome, novaConta);
        return novaConta;
    }

    public void cadastrarParticipante(String nome, String saldoInicial) {
        Participante novoParticipante = new Participante(nome, saldoInicial);
        participantes.put(nome, novoParticipante);
        // automaticamente esse participante vira o logado
        participanteLogado = novoParticipante;
    }

    /**
     * Escolhe uma conta para ser a utiliza ou logada no momento.
     * @param nome o nome da conta a ser logada
     */
    public void logaConta(String nome) {
        ContaColetiva resultado = contas.get(nome);
        contaLogada = resultado;
    }

    public String getNomeParticipanteLogado() {
        return participanteLogado.getNome();
    }

    /**
     * Loga na aplicação como um participante
     * @param nome Nome do participante a logar
     */
    public void logarParticipante(String nome) {
        participanteLogado = participantes.get(nome);
    }

    /**
     * Adiciona valores ao saldo individual do participante logado no momento
     * @param quantia: Uma string representando a quantia a ser depositada
     */
    public void addSaldo(String quantia) {
        Float quantiaFloat = Float.valueOf(quantia);
        participanteLogado.addSaldoIndividual(quantiaFloat);
        return;
    };

    /**
     * Adiciona um serviço na {@code ContaColetiva contaLogada} atual
     */
    public void addServico(String nome, Float custo) {
        Servico novoServico = new Servico(nome, custo);
        contaLogada.adicionaServico(novoServico);
        return;
    };


    /**
     * Paga o Serviço com o nome especificado do participante e da conta 
     * logada atuais.
     * @param valorPago a quantidade do pagamento
     * @param nomeServico o nome do serviço a ser pago
     * @return um {@code boolean} indicando o sucesso (true) ou não (false) 
     * da operação
     */
    public boolean pagarServico(Float valorPago, String nomeServico) {
        Servico servicoAPagar = contaLogada.getServico(nomeServico);
        Pagamento pagamento = new Pagamento(valorPago, contaLogada, participanteLogado, servicoAPagar);
        return pagamento.pagaServico();
    };

}