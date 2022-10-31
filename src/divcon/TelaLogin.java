package divcon;

import javax.swing.*;

public class TelaLogin extends TelaAddParticipante {
	private JPanel painelContas;
	private TelaAddParticipante telaAddParticipante;
	private JLabel lblInfoSaldo;
	/**
	 * Cria a janela de tela de login (JDialog)
	 * @param appDivCon : a parte funcional do aplicativo
	 * @param lblNomeUsuario : uma label da tela principal que mostra o nome do usuário logado
	 * @param painelContas : o painel que mostra as contas do usuário logado
	 * @param telaAddParticipante : tela para adicionar participante em uma conta
	 */
	public TelaLogin(DivCon appDivCon, JPanel painelContas, TelaAddParticipante telaAddParticipante, JLabel lblInfoSaldo) {
		super(appDivCon);
		this.painelContas = painelContas;
		this.telaAddParticipante = telaAddParticipante;
		this.lblInfoSaldo = lblInfoSaldo;
	}

	public void adicionaElemento() {
		String nomeParticipanteSelecionado = cadastradosBox.getSelectedItem().toString();
		if (nomeParticipanteSelecionado  != "-") {
			// Pega o usuário selecionado e puxa-o do hashmap
			appDivCon.logarParticipante(nomeParticipanteSelecionado);
			Participante participanteLogado = appDivCon.getParticipanteLogado();
			
			//Cria um painel de conta para todas as contas que o participante faz parte
			for(ContaColetiva conta : participanteLogado.getContas().values()) {
				painelContas.add(new PainelConta(conta, telaAddParticipante, appDivCon, lblInfoSaldo));
			}
			painelContas.repaint();
			painelContas.revalidate();
			setVisible(false);
		} else {
			String nomeDigitado = getFieldUm();
			String saldoDigitado = getFieldDois();
			
			if(appDivCon.getParticipante(nomeDigitado) != null){
				lblInfo.setText("Participante já cadastrado!");
			}
			//Caso o nome e o saldo digitado forem válidos é cadastrado um novo usuário
			else if (Checadora.checaPar(nomeDigitado, saldoDigitado)) {
					appDivCon.cadastrarParticipante(nomeDigitado, Float.valueOf(saldoDigitado), true);
					//lblNomeUsuario.setText(appDivCon.getNomeParticipanteLogado());
					setVisible(false);
			} else {
				//Caso seja digitado algo inválido nos campos de cadastro
				lblInfo.setText("Usuário ou saldo inválidos!");
			}
		}
	}
}