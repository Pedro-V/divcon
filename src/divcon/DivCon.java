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

    public void addConta(String nome, String descricao) {
        ContaColetiva novaConta = new ContaColetiva(nome, descricao);
        // Se o participante logado cria uma conta, ele automaticamente está dentro dela
        novaConta.addParticipante(participanteLogado);
        contas.put(nome, novaConta);
    }

    public void cadastrarParticipante(String nome, String saldoInicial) {
        Participante novoParticipante = new Participante(nome, saldoInicial);
        participantes.put(nome, novoParticipante);
        // automaticamente esse participante vira o logado
        participanteLogado = novoParticipante;
    }

    public void mudarParticipante(String nome) {
        
    }

    /**
     * O usuário logado irá adicionar saldo no seu perfil da conta logada no momento
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
    public void addServico() {
        return;
    };

    /**
     * 
     */
    public void pagarServico() {
        return;
    };
    
    public Participante getParticipante(String nome) {
    	return participantes.get(nome);
    }

}