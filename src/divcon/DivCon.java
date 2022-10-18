package divcon;
import java.awt.BorderLayout;
import java.util.List;

import javax.swing.*;

public class DivCon {
    private static final String VERSAO = "Versão 1.0\n";

    private JFrame frame;
    private JButton addParticipanteButton;
    private JButton addSaldoButton;
    private int saldoReal;
    private int saldoDecimal;
    private JLabel statusLabel;
    private JLabel infoLabel;

    private List<Participante> participantes;

    public DivCon() {
        makeFrame();
    }

    // --- Funções da aplicação e da GUI ---
    private void mostraAjuda() {
        String mensagem_ajuda = "DivCon\n" + VERSAO + "DivCon é um app para facilitar a divisão de contas com quem você ama";
        JOptionPane.showMessageDialog(frame, 
                    mensagem_ajuda,
                    "Sobre o DivCon",
                    JOptionPane.INFORMATION_MESSAGE);
    }

    private void addParticipante() {};

    private String getStatusFormatado() {
        return "Particpantes: " + participantes.size() + "| Saldo total: " + getSaldoFormatado();
    }
    private String getSaldoFormatado() {
        return "R$ " + saldoReal + "," + saldoDecimal;
    }
    private void addSaldo() {};
    // A aplicação vai vir com uns serviços básicos: Internet, água, luz, supermercado, etc
    private void addServico() {};

    private void pagarServico() {};

    // --- GUI ---
    private void makeFrame() {
        frame = new JFrame("DivCon");
        JPanel contentPane = (JPanel)frame.getContentPane();
        
        makeMenuBar(frame);

        contentPane.setLayout(new BorderLayout(6, 6));
        /**
         * Cria um label na parte superior indicando a quantidade de participantes
         * e o saldo disponível atualmente
        */
        statusLabel = new JLabel(getStatusFormatado());
        contentPane.add(statusLabel);

        // Cria um label na parte inferior para avisos e informações 
        infoLabel = new JLabel(VERSAO);
        contentPane.add(infoLabel);
    }

    private void makeMenuBar(JFrame frame) {
        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);

        JMenu menu;
        JMenuItem item;
        // Cria o menu de ajuda  
        menu = new JMenu("Ajuda");
        menubar.add(menu);

        item = new JMenuItem("Sobre o DivCon...");
        item.addActionListener(e -> mostraAjuda());
        menu.add(item);
        // 
    }
}
