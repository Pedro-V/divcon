package divcon;

public class TelaAddServico extends TelaDoisCampos {
    public TelaAddServico(DivCon appDivCon) {
        super(appDivCon, "Nome do novo serviço:", "Custo do novo serviço:");
    }

    @Override
    protected void adicionaElemento() {
        String nomeNovoServico = getFieldUm();
        String custoNovoServico = getFieldDois();
        if (Checadora.checaPar(nomeNovoServico, custoNovoServico)) {
            appDivCon.addServico(nomeNovoServico, Float.valueOf(custoNovoServico));
            this.setVisible(false);
            limparCampos();
        }
        else {
            lblInfo.setText("Nome ou custo do serviço inválidos.");
        }
    }
}
