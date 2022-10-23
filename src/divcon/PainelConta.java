package divcon;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;


public class PainelConta extends JPanel {

	/**
	 * Um painel para mostrar as informações da conta.
	 */
	public PainelConta(String nome, String descricao) {
		setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {80, 310, 80};
		gridBagLayout.rowHeights = new int[] {50};
		gridBagLayout.columnWeights = new double[]{1.0};
		gridBagLayout.rowWeights = new double[]{0.0};
		setLayout(gridBagLayout);
		
		JLabel lblNomeConta = new JLabel(nome);
		lblNomeConta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNomeConta = new GridBagConstraints();
		gbc_lblNomeConta.anchor = GridBagConstraints.WEST;
		gbc_lblNomeConta.fill = GridBagConstraints.VERTICAL;
		gbc_lblNomeConta.insets = new Insets(0, 0, 0, 5);
		gbc_lblNomeConta.gridx = 0;
		gbc_lblNomeConta.gridy = 0;
		add(lblNomeConta, gbc_lblNomeConta);
		
		JLabel lblDescricao = new JLabel(descricao);
		lblDescricao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDescricao = new GridBagConstraints();
		gbc_lblDescricao.anchor = GridBagConstraints.WEST;
		gbc_lblDescricao.fill = GridBagConstraints.VERTICAL;
		gbc_lblDescricao.insets = new Insets(0, 0, 0, 5);
		gbc_lblDescricao.gridx = 1;
		gbc_lblDescricao.gridy = 0;
		add(lblDescricao, gbc_lblDescricao);
		
		JButton btnVerDetalhes = new JButton("Ver detalhes");
		btnVerDetalhes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_btnVerDetalhes = new GridBagConstraints();
		gbc_btnVerDetalhes.gridx = 2;
		gbc_btnVerDetalhes.gridy = 0;
		add(btnVerDetalhes, gbc_btnVerDetalhes);
		
		Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
		 
        // set the border of this component
        lblNomeConta.setBorder(border);
	}

}
