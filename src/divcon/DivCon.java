package divcon;

import java.util.HashMap;
/**
 * A classe {@code DivCon} é responsável por administrar uma lista dos participantes,
 * das contas, e também do participante e da conta logados no momento na aplicação.
 * Ela administra a entrada e saída de usuários, devendo evitar que usuários que não
 * pertençam a uma dada {@code Conta} não possam entrar nela.
 */
public class DivCon {
    // Esse HashMap tem como chave o nome dos participantes já criados nessa sessão
    private HashMap<String, Participante> participantes;
    // Essa é a conta atual que está logada/ativa na aplicação
    private Participante participanteLogado;
    private ContaColetiva contaLogada;

    public DivCon() {
        participantes = new HashMap<>();
    }

    /**
    * Realiza o cadastro de um novo participante
    * @param nome : o nome do participante a ser criado
    * @param saldoInicial : o saldo desse participante
    * @param logar : um booleano que diz se esse participante irá logar ou não
    */
    public void cadastrarParticipante(String nome, Float saldoInicial, boolean logar) {
        Participante novoParticipante = new Participante(nome, saldoInicial);
        participantes.put(nome, novoParticipante);
        // Para o participante virar o logado, é necessário o booleano ser true
        if (logar) {
            participanteLogado = novoParticipante;
        }
    }

    public void cadastrarParticipante(Participante novoParticipante, boolean logar) {
        participantes.put(novoParticipante.getNome(), novoParticipante);
        if (logar) {
            participanteLogado = novoParticipante;
        }
    }

    /**
     * Cadastra uma nova conta, adicionando o participante logado nela
     * @param novaConta : a conta que será cadastrada
     */
    public void cadastrarConta(ContaColetiva novaConta) {
        novaConta.addParticipante(participanteLogado);
        participanteLogado.addConta(novaConta);
    }

    /**
     * Escolhe uma conta para ser a utiliza ou logada no momento.
     * @param nome o nome da conta a ser logada
     */
    public void logaConta(String nome) {
        contaLogada = participanteLogado.getConta(nome);
    }

    /**
     * Loga na aplicação como um participante
     * @param nome Nome do participante a logar
     */
    public void logarParticipante(String nome) {
        participanteLogado = participantes.get(nome);
    }

    /**
     * Adiciona um serviço na {@code ContaColetiva contaLogada} atual
     */
    public void addServico(String nome, Float custo) {
        Servico novoServico = new Servico(nome, custo);
        contaLogada.addServico(novoServico);
        return;
    }


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
    }
    
    public Participante getParticipanteLogado() {
    	return participanteLogado;
    }
    
    public Participante getParticipante(String nome) {
    	return participantes.get(nome);
    }

    /**
     * @return um hashmap com todos os participantes
    */
    public HashMap<String, Participante> getParticipantes(){
        return participantes;
    }

}