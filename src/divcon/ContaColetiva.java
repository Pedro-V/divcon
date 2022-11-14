package divcon;

import java.util.HashMap;
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
    private final int LIMITECHARS = 40;


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

    public void removeServico(String nomeServico) {
        servicos.remove(nomeServico);
    }

    /**
     * Lista os participantes dessa {@code Conta} juntamente com seus respectivos saldo,
     * linha a linha. Ao final, informa o saldo total da conta
     * 
     * @return uma {@code String} listando os participantes, seus saldos e o saldo
     * total da conta
     */
    public String listaParticipantesESaldo() {
        String resultado = "";
        for (Participante participante : participantes.values()) {
            resultado += participante.getInfoFormatada() + "\n";
        }
        // Colocamos uma ultima linha listando o saldo total
        resultado += "\n" + getSaldoFormatado();
        return resultado;
    }

    /**
     * Lista os serviços ainda não pagos por essa conta, juntamento com
     * o preço ainda a pagar por eles
     * @return uma string cujas linhas são os serviços junto aos seus 
     * valores ainda a pagar
     */
    public String listaServicosECusto() {
        String resultado = "";
        for (Servico servico : servicos.values()) {
            resultado += servico.getInfoFormatada() + "\n";
        }
        return resultado;
    }

    public String getInfoFormatada() {
        return nome + " - " + descricao;
    }

    public String getNomeConta() {
        return nome;
    }

    public String getDescricaoConta() {
        return descricao;
    }

    /**
     * Formata e retorna informações sobre a conta. Esse método automaticamente
     * recalcula o saldo individual
     * @return Uma string formatada, representando informações quanto ao
     * saldo total da conta. 
     */
    private String getSaldoFormatado() {
        String strInfo = "Saldo total:";
        return String.format("%" + -LIMITECHARS + "s", strInfo) + "R$" + calculaSaldoTotal();
    }

    /**
     * Soma os saldos individuais de cada usuário ao saldo total
     * @return um {@code Float} representando o valor atual do saldo
     * total após ele ser calculado
     */
    public Float calculaSaldoTotal() {
        saldoTotal = 0f;
        for (Participante participante : participantes.values()) {
            saldoTotal += participante.getSaldoIndividual();
        }
        return saldoTotal;
    }

    /**
     * Adiciona um novo {@code Servico} na conta
     * @param novoServico o novo objeto serviço a ser inserido na conta
     */
    public void addServico(Servico novoServico) {
        servicos.put(novoServico.getNome(), novoServico);
    }

    public Participante getParticipante(String nome) {
        return participantes.get(nome);
    }
    
    public Servico getServico(String nome){
        return servicos.get(nome);
    }

    public HashMap<String, Participante> getParticipantes(){
        return participantes;
    }

    public HashMap<String, Servico> getServicos(){
        return servicos;
    }

    public boolean participanteEstaNaConta(String nomeParticipante){
        return participantes.get(nomeParticipante) != null;
    }
}