package divcon;

import java.util.ArrayList;
import java.util.List;

public class Conta {
	private float valor;
    private String nome;
    private String descricao;
    private int saldoReal = 0;
    private int saldoDecimal = 0;
    private List<Participante> participantes;

    public Conta(float valor, String nome, String descricao){
        this.valor = valor;
        this.nome = nome;
        this.descricao = descricao;
        participantes = new ArrayList<>();
    }

    public void addParticipante(Participante participante){
        participantes.add(participante);
    }

    private String getStatusFormatado() {
        return "Particpantes: " + participantes.size() +" | Saldo total: " + getSaldoFormatado();
    }

    private String getSaldoFormatado() {
        return "R$ " + saldoReal + "," + saldoDecimal;
    }
}
