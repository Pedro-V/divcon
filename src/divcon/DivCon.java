package divcon;

import java.util.List;
import java.util.ArrayList;

public class DivCon {

    private List<Conta> contas;
    private List<Participante> participantes;

    public DivCon() {
        contas = new ArrayList<>();
        participantes = new ArrayList<>();
    }

    public void addConta(float valor, String nome, String descricao){
        Conta novaConta = new Conta(valor, nome, descricao);
        contas.add(novaConta);
    }

    public void addParticipante(Conta conta, Participante participante){
        conta.addParticipante(participante);
    }

    public void cadastrarParticipante(String nome, String saldoInicial ){
        Participante part = new Participante(nome, saldoInicial);
        participantes.add(part);
    }

    private void addSaldo() {
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