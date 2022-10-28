package divcon;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Tela extends JDialog {

	protected final JPanel contentPanel = new JPanel();
    protected String nomeCampoUm;
    protected String nomeCampoDois;
	protected JTextField txtFieldUm;
	protected JTextField txtFieldDois;
	protected JLabel lblInfo;
	protected DivCon appDivCon;
	/**
	 * Cria uma tela básica
	 * @param appDivCon : a parte funcional do aplicativo
	 * @param nomeCampoUm: o titulo do primeiro campo da tela
	 * @param nomeCampoDois: o titulo do segundo campo da tela
	 */
	public Tela(DivCon appDivCon, String nomeCampoUm, String nomeCampoDois) {
		this.appDivCon = appDivCon;
        this.nomeCampoUm = nomeCampoUm;
        this.nomeCampoDois = nomeCampoDois;
		
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
			JLabel lblDigiteNome = new JLabel(this.nomeCampoUm);
			lblDigiteNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_lblDigiteNome = new GridBagConstraints();
			gbc_lblDigiteNome.anchor = GridBagConstraints.SOUTH;
			gbc_lblDigiteNome.insets = new Insets(0, 0, 5, 5);
			gbc_lblDigiteNome.gridx = 2;
			gbc_lblDigiteNome.gridy = 0;
			contentPanel.add(lblDigiteNome, gbc_lblDigiteNome);
		}
		{
			txtFieldUm = new JTextField();
			GridBagConstraints gbc_textFieldNome = new GridBagConstraints();
			gbc_textFieldNome.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldNome.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldNome.gridx = 2;
			gbc_textFieldNome.gridy = 1;
			contentPanel.add(txtFieldUm, gbc_textFieldNome);
			txtFieldUm.setColumns(10);
		}
		{
			JLabel lblSaldo = new JLabel(this.nomeCampoDois);
			lblSaldo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_lblSaldo = new GridBagConstraints();
			gbc_lblSaldo.anchor = GridBagConstraints.SOUTH;
			gbc_lblSaldo.insets = new Insets(0, 0, 5, 5);
			gbc_lblSaldo.gridx = 2;
			gbc_lblSaldo.gridy = 2;
			contentPanel.add(lblSaldo, gbc_lblSaldo);
		}
		{
			txtFieldDois = new JTextField();
			GridBagConstraints gbc_textFieldSaldo = new GridBagConstraints();
			gbc_textFieldSaldo.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldSaldo.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldSaldo.gridx = 2;
			gbc_textFieldSaldo.gridy = 3;
			contentPanel.add(txtFieldDois, gbc_textFieldSaldo);
			txtFieldDois.setColumns(10);
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
				JButton btnEntrar = new JButton("Adicionar");
				buttonPane.add(btnEntrar);
				btnEntrar.addActionListener(e -> adicionaElemento());
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
	public String getFieldUm() {
		return txtFieldUm.getText();
	}
	
	/**
     * @return String digitada no campo saldo da tela de login
     */
	public String getFieldDois() {
		return txtFieldDois.getText();
	}
	
	/**
     * Limpa os campos de texto da tela de login
     */
	protected void limparCampos() {
		txtFieldUm.setText("");
		txtFieldDois.setText("");
		lblInfo.setText("");
	}

    /**
     * Uma função responsável por adicionar algum elemento da aplicação,
	 * como conta, participante ou serviço.
     */
    protected void adicionaElemento() {
        return;
    }
}