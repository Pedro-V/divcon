package divcon;

import java.util.HashMap;

/**
 * A classe {@code Participante} representa o conceito de um membro
 * de uma conta coletiva. Ele possui saldo individual, que é somado
 * ao saldo total das contas das quais ele faz parte.
 */
public class Participante {
    private String nome;
    private Float saldoIndividual;
    private HashMap<String, ContaColetiva> contas; 

    /**
     * Constrói um novo {@code Participante}
     * @param nome o nome do novo participante
     * @param saldoInicial o saldo com o qual ele começa inicialmente
     */
    public Participante(String nome, String saldoInicial) {
        contas = new HashMap<>();
        this.nome = nome;
        // Formatamos de 10,9,9 para 10.99, por ex
        String saldoInicialFormatado = saldoInicial.replaceFirst(",", ".").replace(",", "");
        saldoIndividual = Float.parseFloat(saldoInicialFormatado);
    }

    /**
     * Retorna o nome do Participante
     * @return Uma String representando o nome do participante
     */
    public String getNome() {
        return nome;
    }

    /**
     * Adicionado valores ao saldo individual do participante
     * @param quant {@code Float} que representa a quantidade a adicionar no saldo
     */
    public void addSaldoIndividual(Float quant) {
        saldoIndividual += quant;
        return;
    }

    /**
     * Lista todas as contas que o participante faz parte
     * @return Uma string onde cada linha é a info de uma conta
     */
    public String listaContas() {
        String resultado = "";
        for (ContaColetiva conta : contas.values()) {
            resultado += conta.getInfoConta() + "\n";
        }
        return resultado;
    }

    public Float getSaldoIndividual() {
        return saldoIndividual;
    }

    public HashMap<String, ContaColetiva> getContas() {
        return contas;
    }

    /**
     * Adiciona uma nova {@code ContaColetiva} ao qual o participante irá 
     * dividir as contas e automaticamente adiciona o participante que 
     * chamou esse método como o primeiro membro da nova conta.
     * @param nome o nome da nova {@code ContaColetiva}
     * @param descricao a descrição da nova {@code ContaColetiva}
     */
    public void addContaColetiva(String nome, String descricao) {
        ContaColetiva novaContaColetiva = new ContaColetiva(nome, descricao);
        // Automaticamente o criador da conta é adicionado como membro
        novaContaColetiva.addParticipante(this);
        contas.put(nome, novaContaColetiva);
        return;
    }
}
