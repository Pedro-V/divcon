package divcon;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaCadastro extends JInternalFrame {
	private JTextField txtFieldNome;
	private JTextField txtFieldParticipante;
	private JTextField txtFieldDescricao;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public TelaCadastro() {
		setBounds(100, 100, 508, 322);
		getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Digite o nome da conta:");
		lblNome.setBounds(10, 11, 156, 14);
		getContentPane().add(lblNome);
		
		txtFieldNome = new JTextField();
		txtFieldNome.setBounds(188, 8, 280, 20);
		getContentPane().add(txtFieldNome);
		txtFieldNome.setColumns(10);
		
		JLabel lblParticipante = new JLabel("Digite o nome do primeiro participante da conta: ");
		lblParticipante.setBounds(10, 36, 156, 14);
		getContentPane().add(lblParticipante);
		
		txtFieldParticipante = new JTextField();
		txtFieldParticipante.setBounds(188, 33, 280, 20);
		getContentPane().add(txtFieldParticipante);
		txtFieldParticipante.setColumns(10);
		
		JLabel lblDescricao = new JLabel("Digite a descrição da conta: ");
		lblDescricao.setBounds(10, 61, 168, 14);
		getContentPane().add(lblDescricao);
		
		txtFieldDescricao = new JTextField();
		txtFieldDescricao.setBounds(188, 58, 280, 20);
		getContentPane().add(txtFieldDescricao);
		txtFieldDescricao.setColumns(10);
		
		JButton btnConfirma = new JButton("Confirmar");
		btnConfirma.setBounds(343, 243, 125, 32);
		getContentPane().add(btnConfirma);

	}
}
