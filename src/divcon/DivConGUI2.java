package divcon;

import java.awt.*;

import javax.swing.*;

public class DivConGUI2 {
    private static final String VERSAO = "Versão 0.1";
    private JFrame frame;
    // private  PainelConta contaPainel;
    private JLabel infoLabel;
    private JButton addParticipanteButton;
    private JButton addContaButton;
    private DivCon appDivCon;
    private JTextField txtTeste;
    private JLabel logoImgLabel;
    private ImageIcon imgLogo;

    public static void main(String[] args) {
        DivConGUI2 window = new DivConGUI2();
        window.frame.setVisible(true);
    }

    public DivConGUI2() { 
        appDivCon = new DivCon();
        makeFrame();
    }

    private void mostraCadastro() {
        JTextField nomeField = new JTextField(5);
        JTextField saldoInicialField = new JTextField(5);
        JPanel loginPanel = new JPanel();
        loginPanel.add(new JLabel("Nome: "));
        loginPanel.add(nomeField);
        loginPanel.add(Box.createVerticalStrut(10));
        loginPanel.add(new JLabel("Saldo inicial: "));
        loginPanel.add(saldoInicialField);
        JOptionPane.showConfirmDialog(frame, loginPanel,
            "Crie um novo perfil de participante", JOptionPane.OK_CANCEL_OPTION);
        // Enviamos as informações obtidas para o app DivCon
        try {
            appDivCon.cadastrarParticipante(nomeField.getText(), saldoInicialField.getText());
            infoLabel.setText("Novo participante cadastrado e logado");
        } catch (Exception e) {
            infoLabel.setText("Cadastro não efetuado. Você digitou alguma letra no saldo inicial?");
        }
        System.out.println(nomeField.getText());
    }

    private void makeFrame() {
    	imgLogo = new ImageIcon(getClass().getResource("logo.png"));
        frame = new JFrame("DivCon");
        // Obtemos o contentPane
        JPanel contentPane = (JPanel)frame.getContentPane();
        contentPane.setLayout(new BorderLayout(6, 6));
        // Construímos o menu
        makeMenuBar(frame);
        // Colocamos um JLabel para mostrar o status da aplicação pro usuário
        infoLabel = new JLabel(VERSAO);
        JPanel baixo = new JPanel();
 
        contentPane.add(baixo, BorderLayout.SOUTH);
        GridBagLayout gbl_baixo = new GridBagLayout();
        gbl_baixo.columnWidths = new int[]{0, 0, 0, 0, 0};
        gbl_baixo.rowHeights = new int[]{0, 0};
        gbl_baixo.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_baixo.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        baixo.setLayout(gbl_baixo);
        
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0};
        gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
        
        
        GridBagConstraints gbc_infoLabel = new GridBagConstraints();
        gbc_infoLabel.fill = GridBagConstraints.BOTH;
        gbc_infoLabel.gridwidth = 3;
        gbc_infoLabel.insets = new Insets(0, 0, 0, 5);
        gbc_infoLabel.gridx = 0;
        gbc_infoLabel.gridy = 0;
        baixo.add(infoLabel, gbc_infoLabel);
        
        //Redimensionar a logo (resolução bugada)
        Image image = imgLogo.getImage();  
        Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH);
        imgLogo = new ImageIcon(newimg);
        
        logoImgLabel = new JLabel(imgLogo);
        GridBagConstraints gbc_logoImgPanel = new GridBagConstraints();
        gbc_logoImgPanel.anchor = GridBagConstraints.EAST;
        gbc_logoImgPanel.fill = GridBagConstraints.VERTICAL;
        gbc_logoImgPanel.gridx = 3;
        gbc_logoImgPanel.gridy = 0;
        baixo.add(logoImgLabel, gbc_logoImgPanel);
        // Uma toolbar lateral com botões para executar diferentes funções
        JPanel toolbar = new JPanel();
        toolbar.setLayout(new GridLayout(0, 2));
        // Botão de adicionar participante
        addParticipanteButton = new JButton("Entrar");
        addParticipanteButton.addActionListener(e -> mostraCadastro());
        toolbar.add(addParticipanteButton);


        // A toolbar é adicionado a um flow com layout para espaçamento
        JPanel flow = new JPanel();
        flow.add(toolbar);

        contentPane.add(flow, BorderLayout.WEST);

        addParticipanteButton.setEnabled(true);
        frame.pack();

        /* Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(d.width/2 - frame.getWidth()/2, d.height/2 - frame.getHeight()/2);
        frame.setVisible(true); */
    }

    private void makeMenuBar(JFrame frame) {};
}
