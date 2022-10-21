package divcon;

import java.awt.*;

import javax.swing.*;

public class DivConGUI3 {
    private static final String VERSAO = "Versão 0.1";
    private JFrame frame;
    // private  PainelConta contaPainel;
    private JLabel infoLabel;
    private DivCon appDivCon;
    private JTextField txtTeste;
    private JLabel logoImgLabel;
    private JLabel lblImgLogo;
    private JPanel baixo;
    private TelaLogin telaLogin;
    

    public static void main(String[] args) {
        DivConGUI3 window = new DivConGUI3();
        window.frame.setVisible(true);
    }

    public DivConGUI3() { 
        appDivCon = new DivCon();
        makeFrame();
    }

    private void mostraCadastro() {
        return;
    }

    private void makeFrame() {
        frame = new JFrame("DivCon");
        // Obtemos o contentPane
        JPanel contentPane = (JPanel)frame.getContentPane();
        contentPane.setLayout(new BorderLayout(6, 6));
        // Construímos o menu
        makeMenuBar(frame);
        // Colocamos um JLabel para mostrar o status da aplicação pro usuário
        infoLabel = new JLabel(VERSAO);
        baixo = new JPanel();
 
        //O border south foi dividido em um gridbag layout, armazenando a logo png e o infolabel
        contentPane.add(baixo, BorderLayout.SOUTH);
        GridBagLayout gbl_baixo = new GridBagLayout();
        gbl_baixo.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
        gbl_baixo.rowHeights = new int[]{0, 0};
        gbl_baixo.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_baixo.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        baixo.setLayout(gbl_baixo);
        
        GridBagConstraints gbc_infoLabel = new GridBagConstraints();
        gbc_infoLabel.fill = GridBagConstraints.BOTH;
        gbc_infoLabel.gridwidth = 3;
        gbc_infoLabel.insets = new Insets(0, 0, 0, 5);
        gbc_infoLabel.gridx = 0;
        gbc_infoLabel.gridy = 0;
        baixo.add(infoLabel, gbc_infoLabel);
        
        // Uma toolbar lateral com botões para executar diferentes funções
        JPanel toolbar = new JPanel();
        toolbar.setLayout(new GridLayout(0, 2));

        // A toolbar é adicionado a um flow com layout para espaçamento
        JPanel flow = new JPanel();
        flow.add(toolbar);
        
        contentPane.add(flow, BorderLayout.WEST);
        telaLogin = new TelaLogin(appDivCon);
    	telaLogin.setVisible(true);
        frame.pack();
        JButton sair = new JButton("Sair");
        contentPane.add(sair, BorderLayout.CENTER);
        sair.addActionListener(e->voltar());
        addImgLogo();

        /* Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(d.width/2 - frame.getWidth()/2, d.height/2 - frame.getHeight()/2);
        frame.setVisible(true); */
    }
    
    private void addImgLogo() {
        
        ImageIcon logoImg = new ImageIcon(getClass().getResource("logo.png"));
        
        Image image = logoImg.getImage();  
        Image newimg = image.getScaledInstance(100, 24,  java.awt.Image.SCALE_SMOOTH);
        logoImg = new ImageIcon(newimg);
        
        lblImgLogo = new JLabel(logoImg);
        GridBagConstraints gbc_lblImgLogo = new GridBagConstraints();
        gbc_lblImgLogo.anchor = GridBagConstraints.EAST;
        gbc_lblImgLogo.gridx = 4;
        gbc_lblImgLogo.gridy = 0;
        baixo.add(lblImgLogo, gbc_lblImgLogo);
    }

    private void voltar(){
        telaLogin.limparCampos();
        telaLogin.setVisible(true);
    }

    private void makeMenuBar(JFrame frame) {};
}
