package divcon;

public class TelaSaldoIndividual extends Tela {
    private Participante participante;
    public TelaSaldoIndividual(DivCon appDivCon, Participante participante) {
        super(appDivCon, "Quantia para adicionaro ao saldo:", "Transferir", "Cancelar");
        this.participante = participante;
    }

    @Override
    protected void adicionaElemento() {
        String quantia = getFieldUm();
        if (Checadora.floatOk(quantia)) {
            participante.addSaldoIndividual(Float.valueOf(quantia));
            this.setVisible(false);
            limparCampos();
        }
        else {
            lblInfo.setText("A quantia informada não é um valor válido");
        }
    }
}
