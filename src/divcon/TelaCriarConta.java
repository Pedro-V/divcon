package divcon;

import java.awt.*;
import java.awt.FlowLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TelaCriarConta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtFieldNome;
	private JTextField txtFieldDescricao;

	/**
	 * Create the dialog.
	 */
	public TelaCriarConta() {
		setBounds(100, 100, 400, 350);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] {60, 60, 160, 60, 60};
		gbl_contentPanel.rowHeights = new int[] {40, 40, 40, 40, 40, 40, 40};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblDigiteNome = new JLabel("Digite o nome da conta:");
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
			GridBagConstraints gbc_txtFieldNome = new GridBagConstraints();
			gbc_txtFieldNome.insets = new Insets(0, 0, 5, 5);
			gbc_txtFieldNome.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtFieldNome.gridx = 2;
			gbc_txtFieldNome.gridy = 1;
			contentPanel.add(txtFieldNome, gbc_txtFieldNome);
			txtFieldNome.setColumns(10);
		}
		{
			JLabel lblDigiteDescricao = new JLabel("Digite a descrição: ");
			lblDigiteDescricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_lblDigiteDescricao = new GridBagConstraints();
			gbc_lblDigiteDescricao.anchor = GridBagConstraints.SOUTH;
			gbc_lblDigiteDescricao.insets = new Insets(0, 0, 5, 5);
			gbc_lblDigiteDescricao.gridx = 2;
			gbc_lblDigiteDescricao.gridy = 2;
			contentPanel.add(lblDigiteDescricao, gbc_lblDigiteDescricao);
		}
		{
			txtFieldDescricao = new JTextField();
			GridBagConstraints gbc_txtFieldDescricao = new GridBagConstraints();
			gbc_txtFieldDescricao.insets = new Insets(0, 0, 5, 5);
			gbc_txtFieldDescricao.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtFieldDescricao.gridx = 2;
			gbc_txtFieldDescricao.gridy = 3;
			contentPanel.add(txtFieldDescricao, gbc_txtFieldDescricao);
			txtFieldDescricao.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnNewButton = new JButton("Criar");
				buttonPane.add(btnNewButton);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}

}
