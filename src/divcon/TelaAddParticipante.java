package divcon;

import java.awt.*;

import javax.swing.*;

public class TelaAddParticipante extends Tela {
	protected JComboBox<String> cadastradosBox;
	protected ContaColetiva contaAtual;
	protected Participante partAdicionado;
	//Criar uma table aqui como atributo e um setTable e la no painel conta usar o settable
	
	/**
	 * Cria a janela de tela de login (JDialog)
	 * @param appDivCon : a parte funcional do aplicativo
	 */
	public TelaAddParticipante(DivCon appDivCon) {
		super(appDivCon, "Digite o nome:", "Digite o saldo:", "Adicionar", "Cancelar");
		{
			JLabel lblUsrCadastrados = new JLabel("Usuários cadastrados");
			lblUsrCadastrados.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_lblUsrCadastrados = new GridBagConstraints();
			gbc_lblUsrCadastrados.insets = new Insets(0, 0, 5, 5);
			gbc_lblUsrCadastrados.gridx = 2;
			gbc_lblUsrCadastrados.gridy = 5;
			contentPanel.add(lblUsrCadastrados, gbc_lblUsrCadastrados);
		}
		{
			lblInfo = new JLabel("");
			lblInfo.setForeground(Color.RED);
			lblInfo.setFont(new Font("Tahoma", Font.BOLD, 12));
			GridBagConstraints gbc_lblInfo = new GridBagConstraints();
			gbc_lblInfo.insets = new Insets(0, 0, 0, 5);
			gbc_lblInfo.gridx = 2;
			gbc_lblInfo.gridy = 8;
			contentPanel.add(lblInfo, gbc_lblInfo);
		}
        {
            cadastradosBox = new JComboBox<>();
			cadastradosBox.setMaximumRowCount(20);
			cadastradosBox.setModel(new DefaultComboBoxModel<String>(new String[] {"-"}));
			cadastradosBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
			GridBagConstraints gbc_cadastradosBox = new GridBagConstraints();
			gbc_cadastradosBox.insets = new Insets(0, 0, 5, 5);
			gbc_cadastradosBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_cadastradosBox.gridx = 2;
			gbc_cadastradosBox.gridy = 6;
			contentPanel.add(cadastradosBox, gbc_cadastradosBox);
        }
        attComboBox();
	}
	
	/**
     * Para entrar no sistema, cria um novo cadastro
	 * ou entra em um cadastro já existente no sistema
     */
	public void adicionaElemento() {
		String nomeParticipanteSelecionado = cadastradosBox.getSelectedItem().toString();
        
		if (nomeParticipanteSelecionado  != "-") {
			//Pega o usuário selecionado e puxa-o do hashmap
			if(contaAtual.participanteEstaNaConta(nomeParticipanteSelecionado)){
				lblInfo.setText("Participante já existe nessa conta!");
			} else {
				Participante participanteSelecionado = appDivCon.getParticipante(nomeParticipanteSelecionado);
				contaAtual.addParticipante(participanteSelecionado);
				participanteSelecionado.addConta(contaAtual);
				this.partAdicionado = participanteSelecionado;
				setVisible(false);
			}
		} else {
			String nomeDigitado = getFieldUm();
			String saldoDigitado = getFieldDois();
			if(appDivCon.getParticipante(nomeDigitado) != null){
				lblInfo.setText("Participante já cadastrado!");

			} else if (Checadora.checaPar(nomeDigitado, saldoDigitado)){
				Participante novoParticipante = new Participante(nomeDigitado, Float.valueOf(saldoDigitado));
				appDivCon.cadastrarParticipante(novoParticipante, false);
                contaAtual.addParticipante(novoParticipante);
                novoParticipante.addConta(contaAtual);
                this.partAdicionado = novoParticipante;
				setVisible(false);
			} else {
				//Caso o campo de nome esteja vazio
				lblInfo.setText("Usuário ou saldo inválidos!");
			}
		}
        
	}

    public void setContaAtual(ContaColetiva contaAtual){
        this.contaAtual = contaAtual;
    }

    public void attComboBox(){
		cadastradosBox.removeAllItems();
		cadastradosBox.addItem("-");
        for(Participante participante : appDivCon.getParticipantes().values()){
            cadastradosBox.addItem(participante.getNome());
        }
    }
    
    public Participante getPartAdicionado() {
    	return partAdicionado;
    }
}