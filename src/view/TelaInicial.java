package src.view;
import javax.swing.*;
import java.awt.*;

public class TelaInicial extends JPanel {
    // Atributos
    private Tela tela;
    private GridBagLayout layout;
    private GridBagConstraints c;
    private JPanel sidePainel;
    private JButton botao;
    private JPanel mainPainel;
    private JTable tabela;

    // Construtor
    public TelaInicial(Tela tela) {
        this.tela = tela;

        layout = new GridBagLayout();
        c = new GridBagConstraints();
        c.weightx = 1.0;
        c.weighty = 1.0;

        setLayout(layout);

        inserirSidePainel();
        inserirMainPainel();
    }
    // Métodos
    private void inserirSidePainel(){
        sidePainel = new JPanel();
        sidePainel.setLayout(layout);

        c.gridx = 0;
        c.gridy = 0;
        inserirSideBotoes(sidePainel);
        add(sidePainel, c);
    }

    
    private void inserirMainPainel(){
        mainPainel = new JPanel();
        mainPainel.setLayout(layout);

        c.gridx = 1;
        c.gridy = 0;

        inserirMainCabecalho(mainPainel);
        inserirMainTabela(mainPainel);
        add(mainPainel, c);
    }

    private void inserirSideBotoes(JPanel sidePainel){
        JPanel divBtn = new JPanel();
        divBtn.setLayout(layout);

        

        botao = new JButton("CRIAR");
        c.gridx = 0;
        c.gridy = 0;
        sidePainel.add(botao, c);

        botao = new JButton("ATUALIZAR");
        c.gridx = 0;
        c.gridy = 1;
        sidePainel.add(botao, c);

        botao = new JButton("EXCLUIR");
        c.gridx = 0;
        c.gridy = 2;
        sidePainel.add(botao, c);

    }

    private void inserirMainCabecalho(JPanel mainPainel){
        JLabel cabecalhoMain = new JLabel("Tabela de estudantes", JLabel.CENTER);

        mainPainel.add(cabecalhoMain);
    }

    private void inserirMainTabela(JPanel mainPainel){
        tabela = new JTable(20,9);
        
        mainPainel.add(tabela);
    }

}
