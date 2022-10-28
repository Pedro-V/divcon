package divcon;

import java.awt.*;

import javax.swing.*;

public class TelaDoisCampos extends Tela {
    protected String nomeCampoDois;
	protected JTextField txtFieldDois;
	/**
	 * Cria uma tela básica
	 * @param appDivCon : a parte funcional do aplicativo
	 * @param nomeCampoUm: o titulo do primeiro campo da tela
	 * @param nomeCampoDois: o titulo do segundo campo da tela
	 */
	public TelaDoisCampos(DivCon appDivCon, String nomeCampoUm, String nomeCampoDois) {
		super(appDivCon, nomeCampoUm, "Adicionar", "Cancelar");
        this.nomeCampoDois = nomeCampoDois;
		
		{
			JLabel lblDois = new JLabel(this.nomeCampoDois);
			lblDois.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_lblDois = new GridBagConstraints();
			gbc_lblDois.anchor = GridBagConstraints.SOUTH;
			gbc_lblDois.insets = new Insets(0, 0, 5, 5);
			gbc_lblDois.gridx = 2;
			gbc_lblDois.gridy = 2;
			contentPanel.add(lblDois, gbc_lblDois);
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
}