package divcon;

import java.util.HashMap;
import java.util.List;

/**
 * A classe {@code Participante} representa o conceito de um membro
 * de uma conta coletiva. Ele possui saldo individual, que é somado
 * ao saldo total das contas das quais ele faz parte.
 */
public class Participante {
    private String nome;
    private Float saldoIndividual;
    private HashMap<String, Conta> contas; 

    /**
     * Constrói um novo {@Participante}
     * @param nome o nome do novo participante
     * @param saldoInicial o saldo com o qual ele começa inicialmente
     */
    public Participante(String nome, String saldoInicial) {
        this.nome = nome;
        // Formatamos de 10,9,9 para 10.99, por ex
        String saldoInicialFormatado = saldoInicial.replaceFirst(",", ".").replace(",", "");
        saldoIndividual = Float.parseFloat(saldoInicialFormatado);
    }

    public String getNome() {
        return nome;
    }

    public void addSaldoIndividual(Float quant) {
        saldoIndividual += quant;
        return;
    }

    public String listaContas() {
        String resultado = "";
        for (Conta conta : contas.values()) {
            resultado += conta.getInfoConta();
        }
        return resultado;
    }

    public Float getSaldoIndividual() {
        return saldoIndividual;
    }

}
