package divcon;

public class TelaPagamento extends Tela {
    private String nomeServico;

    /**
	 * Cria a janela de pagamento
     * @param appDivCon : acesso as funções do aplicativo
     * @param nomeServio : nome do serviço que será feito o pagamento
	 */
    public TelaPagamento(DivCon appDivCon, String nomeServico) {
        super(appDivCon, "Quantia a pagar:", "Pagar", "Cancelar");
        this.nomeServico = nomeServico;
    }

    protected void adicionaElemento() {
        String quantia = getFieldUm();
        if (Checadora.floatOk(quantia)) {
            boolean resultado = appDivCon.pagarServico(Float.valueOf(quantia), nomeServico);
            if (!resultado) {
                lblInfo.setText("<html>A operação não foi concluída.<br/>Seu saldo individual é suficiente?<html/>");
            }
            else {
                this.setVisible(false);
                limparCampos();
            }
        }
        else {
            lblInfo.setText("A quantia informada não é um valor válido");
        }
    }
}
