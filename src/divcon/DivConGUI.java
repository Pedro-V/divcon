package divcon;

import java.awt.*;

import javax.swing.*;

public class DivConGUI {

	private JFrame frame;
	private JLabel lblImgLogo;
	private JPanel contentPanel;
	private JPanel panelNorth;
	private JPanel panelUser;
	private JLabel lblImgUsuario;
	private JLabel lblNomeUsuario;
	private JMenuBar menuBar;
	private JMenu mnOpcoes;
	private JMenuItem mItemSair;
    private DivCon appDivCon;
    private TelaLogin telaLogin;

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
		
		//Criação de um painel secundário no centro da janela
		contentPanel = new JPanel();
		frame.getContentPane().add(contentPanel, BorderLayout.CENTER);
		//Definição do GridBagLayout do painel secundario(painel de conteudo)
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{60, 60, 60, 60, 60, 60, 60, 60, 60};
		gridBagLayout.rowHeights = new int[]{0, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40};
		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gridBagLayout);
		
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
		
		//Criação do menu bar
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		mnOpcoes = new JMenu("Opções");
		menuBar.add(mnOpcoes);
		
		mItemSair = new JMenuItem("Sair");
		mnOpcoes.add(mItemSair);
		
		//Ações de cada item do menubar
		mItemSair.addActionListener(e -> deslogarUsuario());
		
		//Criação da imagem de logo do aplicativo
		lblImgLogo = new JLabel();
		addImgLogo();

        telaLogin = new TelaLogin(appDivCon, lblNomeUsuario);
        telaLogin.setVisible(true);
	}
	
    /**
     * Cria a imagem da logo do aplicativo,
     * posicionando-a no local correto
     */
	private void addImgLogo() {
			//A imagem foi criada com base no logo.png
	        ImageIcon logoImg = new ImageIcon(getClass().getResource("logoApp.png"));
	        
	        Image image = logoImg.getImage();  
	        Image newimg = image.getScaledInstance(100, 24,  java.awt.Image.SCALE_SMOOTH);
	        logoImg = new ImageIcon(newimg);
	        
	        lblImgLogo = new JLabel(logoImg);
	        
	        //Foi posicionada no canto inferior direito do painel de conteúdo
	        GridBagConstraints gbc_lblImgLogo = new GridBagConstraints();
	        gbc_lblImgLogo.anchor = GridBagConstraints.EAST;
			gbc_lblImgLogo.gridx = 8;
			gbc_lblImgLogo.gridy = 10;
			contentPanel.add(lblImgLogo, gbc_lblImgLogo);
	        
	    }
    
    /**
     * Desloga o usuário atual, mostrando a tela de login novamente,
     * para ser possível entrar em outra conta
     */
    private void deslogarUsuario(){
        telaLogin.limparCampos();
        telaLogin.setVisible(true);
    }
	
}