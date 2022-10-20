package divcon;

public class Servico {
    private String nome;
    private Float custo;

    public Servico(String nome, Float custo) {
        this.nome = nome;
        this.custo = custo;
    }

    public boolean estaPago() {
        return custo == 0;
    }

    public String infoSummary() {
        return nome + ". Valor ainda a pagar: R$ " + custo.toString();
    }

    public int recebePagamento(Pagamento formaPagamento) {
        Float valorpago = formaPagamento.getvalorpago()
        if ( > custo) {
            custo = 0f;
            return 
        }
    }
}
