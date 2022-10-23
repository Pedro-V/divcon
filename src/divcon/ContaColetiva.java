package divcon;

import java.util.*;
/**
 * A classe {@code Conta} representa uma conta coletiva na aplicação, que
 * reúne um ou mais participantes para compartilharem despesas.
 * O {@code saldoTotal} da conta é a soma dos saldos individuais de seus
 * participantes
 */
public class ContaColetiva {
    private String nome;
    private String descricao;
    private Float saldoTotal;
    // Cada chave é o nome, o valor é o objeto participante
    private HashMap<String, Participante> participantes;
    // A lista de serviços dessa conta
    private HashMap<String, Servico> servicos;


    /**
     * Construtor de um novo objeto Conta
     * @param nome O nome da conta. É importante, pois é necessário para diferenciar
     * entre as diferentes contas da aplicação
     * @param descricao A descrição da conta, que pode informar o seu propósito
     */
    public ContaColetiva(String nome, String descricao){
        // o saldoTotal da conta sempre começa zerado, e vai enchendo conforme participantes adicionam saldo individual
        this.saldoTotal = Float.valueOf(0f);
        this.nome = nome;
        this.descricao = descricao;
        servicos = new HashMap<>();
        participantes = new HashMap<>();
    }

    public void addParticipante(Participante participante){
        participantes.put(participante.getNome(), participante);
        // Adicionamos o saldo do novo participante ao saldo total da conta
        saldoTotal += participante.getSaldoIndividual();
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
    public String listaParticipantes() {
        String resultado = "";
        for (Participante participante : participantes.values()) {
            resultado += participante.getNome() + "\n";
        }
        return resultado;
    }

    public String getNomeConta() {
        return nome;
    }

    public String getDescricaoConta() {
        return descricao;
    }

    public String getSaldoFormatado() {
        return "R$ " + saldoTotal.toString();
    }

    /**
     * Adiciona um novo {@code Servico} na conta
     * @param novoServico o novo objeto serviço a ser inserido na conta
     */
    public void adicionaServico(Servico novoServico) {
        servicos.put(novoServico.getNome(), novoServico);
    }

    
    /**
     * Processa o {@code Pagamento} de um dado {@code Servico}
     * @param pagamento objeto que representa o pagamento a ser feito
     * @param nomeServico o nome do serviço que será pago
     * @return um {@code boolean} representando se a operação foi um
     * sucesso ({@code true}) ou não ({@code false})
     */
    public boolean pagaServico(Pagamento pagamento, String nomeServico) {
        boolean resultadoOperacao;
        Servico servicoAPagar = servicos.get(nomeServico);
        if (servicoAPagar == null) {
            resultadoOperacao = false;
        }
        else {
            servicoAPagar.recebePagamento(pagamento);
            resultadoOperacao = true;    
        }
        return resultadoOperacao;   
    }

    public Participante getParticipante(String nome) {
        return participantes.get(nome);
    }
    
    public Servico getServico(String nome){
        return servicos.get(nome);
    }
}
