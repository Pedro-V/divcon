package divcon;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

public class Tela extends JDialog {

	protected final JPanel contentPanel = new JPanel();
    protected String nomeCampoUm;
	protected JTextField txtFieldUm;
	protected JLabel lblInfo;
	protected DivCon appDivCon;
    protected String nomeBotao1;
    protected String nomeBotao2;
	/**
	 * Cria uma tela básica
	 * @param appDivCon : a parte funcional do aplicativo
	 * @param nomeCampoUm: o titulo do primeiro campo da tela
	 * @param nomeCampoDois: o titulo do segundo campo da tela
	 */
	public Tela(DivCon appDivCon, String nomeCampoUm, String botao1, String botao2) {
		this.appDivCon = appDivCon;
        this.nomeCampoUm = nomeCampoUm;
        nomeBotao1 = botao1;
        nomeBotao2 = botao2;
		
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
			JLabel lblUm = new JLabel(this.nomeCampoUm);
			lblUm.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_lblUm = new GridBagConstraints();
			gbc_lblUm.anchor = GridBagConstraints.SOUTH;
			gbc_lblUm.insets = new Insets(0, 0, 5, 5);
			gbc_lblUm.gridx = 2;
			gbc_lblUm.gridy = 0;
			contentPanel.add(lblUm, gbc_lblUm);
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
				JButton btnUm = new JButton(nomeBotao1);
				buttonPane.add(btnUm);
				btnUm.addActionListener(e -> adicionaElemento());
			}
			{
				JButton btnDois = new JButton(nomeBotao2);
				buttonPane.add(btnDois);
				btnDois.addActionListener(e -> limparCampos());
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
     * Limpa os campos de texto da tela de login
     */
	protected void limparCampos() {
		txtFieldUm.setText("");
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