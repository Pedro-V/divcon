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
        criaExemplosServicos();
    }

    /**
     * Cria 5 novos serviços na ContaColetiva, exemplificando a usabilidade
     * dela.
     */
    public void criaExemplosServicos() {
        Servico agua, luz, supermercado, internet, combustivel;
        agua = new Servico("Água e Esgoto", 100.2f);
        luz = new Servico("Luz e Energia", 120f);
        supermercado = new Servico("Supermercado Melba Roy Mouton", 1969.11f);
        internet = new Servico("VivoFibra", 13.13f);
        combustivel = new Servico("Gasolina - Posto Vargas Llosa", 59f);

        servicos.put(agua.getNome(), agua);
        servicos.put(luz.getNome(), luz);
        servicos.put(supermercado.getNome(), supermercado);
        servicos.put(internet.getNome(), internet);
        servicos.put(combustivel.getNome(), combustivel);
        return;
    }

    public void addParticipante(Participante participante){
        participantes.put(participante.getNome(), participante);
        // Adicionamos o saldo do novo participante ao saldo total da conta
        saldoTotal += participante.getSaldoIndividual();
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
        return "Saldo total da conta:" + "\t" + "R$ " + calculaSaldoTotal();
    }

    /**
     * Soma os saldos individuais de cada usuário ao saldo total
     * @return um {@code Float} representando o valor atual do saldo
     * total após ele ser calculado
     */
    private Float calculaSaldoTotal() {
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
