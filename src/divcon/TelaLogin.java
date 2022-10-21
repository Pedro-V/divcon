package divcon;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TelaLogin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtFieldNome;
	private JTextField txtFieldSaldo;
	private JLabel lblInfo;
	private JComboBox<String> cadastradosBox;
	private DivCon appDivCon;
	private JLabel lblNomeUsuario;

	/**
	 * Cria a janela de tela de login (JDialog)
	 * @param appDivCon : a parte funcional do aplicativo
	 * @param lblNomeUsuario : uma label da tela principal que mostra o nome do usuário logado
	 */
	public TelaLogin(DivCon appDivCon, JLabel lblNomeUsuario) {
		this.lblNomeUsuario = lblNomeUsuario;
		this.appDivCon = appDivCon;
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		setBounds(100, 100, 435, 420);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] {60, 60, 110, 60, 60};
		gbl_contentPanel.rowHeights = new int[] {40, 40, 40, 40, 40, 40, 40, 40, 40};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblDigiteNome = new JLabel("Digite o nome:");
			lblDigiteNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_lblDigiteNome = new GridBagConstraints();
			gbc_lblDigiteNome.anchor = GridBagConstraints.SOUTH;
			gbc_lblDigiteNome.insets = new Insets(0, 0, 5, 5);
			gbc_lblDigiteNome.gridx = 2;
			gbc_lblDigiteNome.gridy = 0;
			contentPanel.add(lblDigiteNome, gbc_lblDigiteNome);
		}
		{
			txtFieldNome = new JTextField();
			GridBagConstraints gbc_textFieldNome = new GridBagConstraints();
			gbc_textFieldNome.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldNome.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldNome.gridx = 2;
			gbc_textFieldNome.gridy = 1;
			contentPanel.add(txtFieldNome, gbc_textFieldNome);
			txtFieldNome.setColumns(10);
		}
		{
			JLabel lblSaldo = new JLabel("Digite o saldo:");
			lblSaldo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_lblSaldo = new GridBagConstraints();
			gbc_lblSaldo.anchor = GridBagConstraints.SOUTH;
			gbc_lblSaldo.insets = new Insets(0, 0, 5, 5);
			gbc_lblSaldo.gridx = 2;
			gbc_lblSaldo.gridy = 2;
			contentPanel.add(lblSaldo, gbc_lblSaldo);
		}
		{
			txtFieldSaldo = new JTextField();
			GridBagConstraints gbc_textFieldSaldo = new GridBagConstraints();
			gbc_textFieldSaldo.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldSaldo.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldSaldo.gridx = 2;
			gbc_textFieldSaldo.gridy = 3;
			contentPanel.add(txtFieldSaldo, gbc_textFieldSaldo);
			txtFieldSaldo.setColumns(10);
		}
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
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnEntrar = new JButton("Entrar");
				buttonPane.add(btnEntrar);
				btnEntrar.addActionListener(e -> entrarSistema());
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				buttonPane.add(btnCancelar);
				btnCancelar.addActionListener(e -> limparCampos());
			}
		}
		
		
	}
	
	/**
     * @return String digitada no campo nome da tela de login
     */
	public String getNomeDigitado() {
		return txtFieldNome.getText();
	}
	
	/**
     * @return String digitada no campo saldo da tela de login
     */
	public String getSaldoDigitado() {
		return txtFieldSaldo.getText();
	}
	
	/**
     * Limpa os campos de texto da tela de login
     */
	public void limparCampos() {
		txtFieldNome.setText("");
		txtFieldSaldo.setText("");
		lblInfo.setText("");
	}
	
	/**
     * Para entrar no sistema, cria um novo cadastro
	 * ou entra em um cadastro já existente no sistema
     */
	public void entrarSistema() {
		String nomeParticipanteSelecionado = cadastradosBox.getSelectedItem().toString();
		if(nomeParticipanteSelecionado  != "-") {
			//Pega o usuário selecionado e puxa-o do hashmap
			appDivCon.logarParticipante(nomeParticipanteSelecionado);
			lblNomeUsuario.setText(nomeParticipanteSelecionado);
			setVisible(false);
		} else {
			if(!getNomeDigitado().equals("")) {
				try {
					appDivCon.cadastrarParticipante(getNomeDigitado(), getSaldoDigitado());
					cadastradosBox.addItem(getNomeDigitado());
					lblNomeUsuario.setText(getNomeDigitado());
					setVisible(false);
				} catch (Exception e) {
					//Caso seja digitado algo errado no campo saldo
					lblInfo.setText("Usuário ou saldo inválidos");
				}
			} else {
				//Caso o campo de nome esteja vazio
				lblInfo.setText("Usuário ou saldo inválidos");
				
			}
		}
	}

}
