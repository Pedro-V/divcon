package divcon;

import java.util.ArrayList;
import java.util.List;

public class Conta {
    private String nome;
    private String descricao;
    private Float saldoTotal;
    private List<Participante> participantes;

    public Conta(String nome, String descricao){
        // o saldoTotal da conta sempre começa zerado, e vai enchendo conforme participantes adicionam saldo individual
        this.saldoTotal = Float.valueOf(0f);
        this.nome = nome;
        this.descricao = descricao;
        participantes = new ArrayList<>();
    }

    public void addParticipante(Participante participante){
        participantes.add(participante);
    }

    public String getStatusFormatado() {
        return "Quantidade de participantes: " + participantes.size() +" | Saldo total: " + getSaldoFormatado();
    }

    public void listParticipantes() {
        for (Participante participante : participantes) {
            System.out.println(participante.getNome() + "\n");
        }
    }

    private String getSaldoFormatado() {
        return "R$ " + saldoTotal.toString();
    }
}
