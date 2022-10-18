package divcon;

import java.util.HashMap;
/**
 * A classe {@code Conta} representa uma conta coletiva na aplicação, que
 * reúne um ou mais participantes para compartilharem despesas.
 * O {@code saldoTotal} da conta é a soma dos saldos individuais de seus
 * participantes
 */
public class Conta {
    private String nome;
    private String descricao;
    private Float saldoTotal;
    // Cada chave é o nome, o valor é o objeto participante
    private HashMap<String, Participante> participantes;


    /**
     * Construtor de um novo objeto Conta
     * @param nome O nome da conta. É importante, pois é necessário para diferenciar
     * entre as diferentes contas da aplicação
     * @param descricao A descrição da conta, que pode informar o seu propósito
     */
    public Conta(String nome, String descricao){
        // o saldoTotal da conta sempre começa zerado, e vai enchendo conforme participantes adicionam saldo individual
        this.saldoTotal = Float.valueOf(0f);
        this.nome = nome;
        this.descricao = descricao;
        participantes = new HashMap<>();
    }

    public void addParticipante(Participante participante){
        participantes.put(participante.getNome(), participante);
    }

    public String getStatusFormatado() {
        return "Quantidade de participantes: " + participantes.size() +" | Saldo total: " + getSaldoFormatado();
    }

    /**
     * Lista os participantes dessa {@code Conta} e retorna uma string listando
     * eles.
     * 
     * @return uma {@code String} listando os participantes
     */
    public String listParticipantes() {
        String resultado = "";
        for (Participante participante : participantes.values()) {
            resultado += participante.getNome() + "\n";
        }
        return resultado;
    }

    public String getInfoConta() {
        return nome + "\n" + descricao;
    }

    public String getSaldoFormatado() {
        return "R$ " + saldoTotal.toString();
    }

    public void pagaServico() {

    }
}
