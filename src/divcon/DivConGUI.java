package divcon;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;

/**
 * A classe que reúne as características e comportamento da interface gráfica
 * da aplicação. São os menuse painéis que possibilitam a criação/login de 
 * participantes e contas, além de permitirem a divisão de gastos para serviços
 */
public class DivConGUI {

	private JFrame frame;
	private JTextField txtContas;
	private TelaCadastro telaCadastro;
	private DivCon divConApp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DivConGUI window = new DivConGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DivConGUI() {
		divConApp = new DivCon();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		telaCadastro = new TelaCadastro();
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 667, 491);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JDesktopPane desk = new JDesktopPane();
		desk.setBounds(655, 452, -333, -357);
		frame.setContentPane(desk);
		
		JButton btnAddConta = new JButton("Adicionar nova conta");
		btnAddConta.setBounds(500, 418, 140, 23);
		desk.add(btnAddConta);
		
		JTextArea txtAreaContas = new JTextArea("teste");
		//txtAreaContas.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(txtAreaContas);
		scrollPane.setBounds(36, 51, 200, 200);
		desk.add(scrollPane);
		
		
		txtContas = new JTextField();
		txtContas.setEditable(false);
		txtContas.setText("Contas cadastradas:");
		txtContas.setBounds(36, 22, 132, 20);
		desk.add(txtContas);
		txtContas.setColumns(10);
		desk.add(telaCadastro);
		
		
		btnAddConta.addActionListener(e -> addNovaConta());
		
	}
	
	private void addNovaConta() {
		telaCadastro.setVisible(true);
	}
}
