package divcon;

import java.util.ArrayList;
import java.util.List;
/**
 * A classe {@code DivCon} é responsável por administrar uma lista dos participantes,
 * das contas, e também do participante e da conta logados no momento na aplicação.
 * Ela administra a entrada e saída de usuários, devendo evitar que usuários que não
 * pertençam a uma dada {@code Conta} não possam entrar nela.
 */
public class DivCon {
    
    // Essa é a conta atual que está logada/ativa na aplicação
    private Participante participanteLogado;
    // Lista das contas
    private List<Conta> contas;
    private Conta contaLogada;

    public DivCon() {
        contas = new ArrayList<>();
    }

    public void addConta(String nome, String descricao) {
        Conta novaConta = new Conta(nome, descricao);
        // Se o participante logado cria uma conta, ele automaticamente está dentro dela
        novaConta.addParticipante(participanteLogado);
        contas.add(novaConta);
    }

    public void addParticipante(Conta conta, Participante participante) {
        contaLogada.addParticipante(participante);
    }

    public void cadastrarParticipante(String nome, String saldoInicial) {
        Participante part = new Participante(nome, saldoInicial);
        // automaticamente esse participante vira o logado
        participanteLogado = part;
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
    // A aplicação vai vir com uns serviços básicos: Internet, água, luz, supermercado, etc
    private void addServico() {
        return;
    };

    private void pagarServico() {
        return;
    };

}