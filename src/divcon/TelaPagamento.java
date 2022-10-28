package divcon;

public class TelaPagamento extends Tela {
    private String nomeServico;

    public TelaPagamento(DivCon appDivCon, String nomeServico) {
        super(appDivCon, "Quantia a pagar:", "Pagar", "Cancelar");
        this.nomeServico = nomeServico;
    }

    protected void adicionaElemento() {
        String quantia = getFieldUm();
        if (Checadora.floatOk(quantia)) {
            boolean resultado = appDivCon.pagarServico(Float.valueOf(quantia), nomeServico);
            if (!resultado) {
                lblInfo.setText("A operação não foi concluída. Seu saldo individual é suficiente?");
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
