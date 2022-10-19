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
        frame = new JFrame("DivCon");
        // Obtemos o contentPane
        JPanel contentPane = (JPanel)frame.getContentPane();
        contentPane.setLayout(new BorderLayout(6, 6));
        // Construímos o menu
        makeMenuBar(frame);
        // Colocamos um JLabel para mostrar o status da aplicação pro usuário
        infoLabel = new JLabel(VERSAO);
        contentPane.add(infoLabel, BorderLayout.SOUTH);
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
