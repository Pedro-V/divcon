package divcon;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class DivConGUI {

	private JFrame frame;
	private JLabel lblImgLogo;
	private JPanel panelNorth;
	private JPanel panelUser;
	private JLabel lblImgUsuario;
	private JLabel lblNomeUsuario;
	private JMenuBar menuBar;
	private JMenu mnOpcoes;
	private JMenuItem mItemMudarParticipante;
    private DivCon appDivCon;
    private TelaLogin telaLogin;
    private TelaCriarConta telaCriarConta;
    private JPanel panelSouth;
    private JScrollPane scrollContas;
    private JPanel painelContas;
    private JButton btnAddConta;

	/**
	 * Inicia o aplicativo.
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
	 * Cria a aplicação.
	 */
	public DivConGUI() {
        appDivCon = new DivCon();
		initialize();
	}

	/**
	 * Inicializa os conteúdos da janela
	 */
	private void initialize() {
		//Criação da janela principal com BorderLayout
		frame = new JFrame("DivCon");
		frame.setBounds(100, 100, 619, 468);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());
		
		//Criação de um painel para ficar no norte da janela
		panelNorth = new JPanel();
		frame.getContentPane().add(panelNorth, BorderLayout.NORTH);
		GridBagLayout gbl_panelNorth = new GridBagLayout();
		gbl_panelNorth.columnWidths = new int[] {60, 60, 60, 60, 60, 60, 60, 60, 60};
		gbl_panelNorth.rowHeights = new int[] {30};
		gbl_panelNorth.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0};
		gbl_panelNorth.rowWeights = new double[]{1.0};
		panelNorth.setLayout(gbl_panelNorth);
		
		//Criação de um painel que armazena o nome e a foto do usuário
		panelUser = new JPanel();
		panelUser.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		FlowLayout flowLayout = (FlowLayout) panelUser.getLayout();
		flowLayout.setVgap(1);
		flowLayout.setHgap(2);
		GridBagConstraints gbc_panelUser = new GridBagConstraints();
		gbc_panelUser.anchor = GridBagConstraints.EAST;
		gbc_panelUser.fill = GridBagConstraints.VERTICAL;
		gbc_panelUser.gridx = 8;
		gbc_panelUser.gridy = 0;
		panelNorth.add(panelUser, gbc_panelUser);
		
		//Label com a foto do usuário
		lblImgUsuario = new JLabel("");
		lblImgUsuario.setIcon(new ImageIcon(DivConGUI.class.getResource("/divcon/logoUser.jpg")));
		panelUser.add(lblImgUsuario);
		
		//Label com o nome do usuário que está logado
		lblNomeUsuario = new JLabel("");
		panelUser.add(lblNomeUsuario);
		
		panelSouth = new JPanel();
        frame.getContentPane().add(panelSouth, BorderLayout.SOUTH);
        GridBagLayout gbl_panelSouth = new GridBagLayout();
        gbl_panelSouth.columnWidths = new int[] {30, 60, 30, 30, 60, 60, 60, 60, 50, 60};
        gbl_panelSouth.rowHeights = new int[] {30};
        gbl_panelSouth.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
        gbl_panelSouth.rowWeights = new double[]{1.0};
        panelSouth.setLayout(gbl_panelSouth);
        
        scrollContas = new JScrollPane();
        frame.getContentPane().add(scrollContas, BorderLayout.CENTER);
        
        painelContas = new JPanel();
        scrollContas.setViewportView(painelContas);
        painelContas.setLayout(new BoxLayout(painelContas, BoxLayout.Y_AXIS));
        
		//Criação do menu bar
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		mnOpcoes = new JMenu("Opções");
		menuBar.add(mnOpcoes);
		
		mItemMudarParticipante = new JMenuItem("Mudar Participante");
		mnOpcoes.add(mItemMudarParticipante);
        
		//Ações de cada item do menubar
		mItemMudarParticipante.addActionListener(e -> deslogarUsuario());
		
		//Criação da imagem de logo do aplicativo
		addImgLogo();
		
		frame.setVisible(true);
		telaLogin = new TelaLogin(appDivCon, lblNomeUsuario);
        telaLogin.setVisible(true);
        
        telaCriarConta = new TelaCriarConta(appDivCon, painelContas, frame);
        telaCriarConta.setVisible(false);
		
		btnAddConta.addActionListener(e -> telaCriarConta.setVisible(true));
	}
	
    /**
     * Cria a imagem da logo do aplicativo,
     * posicionando-a no local correto
     */
	private void addImgLogo() {
			//A imagem foi criada com base no logoApp.png
	        ImageIcon logoImg = new ImageIcon(getClass().getResource("logoApp.png"));
	        
	        Image image = logoImg.getImage();  
	        Image newimg = image.getScaledInstance(100, 24,  java.awt.Image.SCALE_SMOOTH);
	        logoImg = new ImageIcon(newimg);
	        
	        btnAddConta = new JButton("Adicionar conta");
	        btnAddConta.setFont(new Font("Tahoma", Font.PLAIN, 12));
	        GridBagConstraints gbc_btnAddConta = new GridBagConstraints();
	        gbc_btnAddConta.insets = new Insets(0, 0, 0, 5);
	        gbc_btnAddConta.gridx = 1;
	        gbc_btnAddConta.gridy = 0;
	        panelSouth.add(btnAddConta, gbc_btnAddConta);
	        
	        lblImgLogo = new JLabel(logoImg);
	        GridBagConstraints gbc_lblImgLogo = new GridBagConstraints();
	        gbc_lblImgLogo.anchor = GridBagConstraints.EAST;
	        gbc_lblImgLogo.gridx = 9;
	        gbc_lblImgLogo.gridy = 0;
	        panelSouth.add(lblImgLogo, gbc_lblImgLogo);
	        
	    }
    
    /**
     * Desloga o usuário atual, mostrando a tela de login novamente,
     * para ser possível entrar em outra conta,
     * ao deslogar as contas da tela são apagadas
     */
    private void deslogarUsuario(){
        telaLogin.limparCampos();
        
        //Apaga todas as contas da tela
        painelContas.removeAll();
        //Redesenha o painel de contas
        painelContas.repaint();
        painelContas.revalidate();
        
        telaLogin.setVisible(true);
    }
  
}