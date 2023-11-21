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

        inserirMainTabela(mainPainel);
        add(mainPainel, c);
    }

    private void inserirSideBotoes(JPanel sidePainel){
        JPanel divBtn = new JPanel();
        divBtn.setLayout(new GridLayout(0, 1, 10, 10));

        botao = new JButton("CRIAR");
        divBtn.add(botao);

        botao = new JButton("ATUALIZAR");
        divBtn.add(botao);

        botao = new JButton("EXCLUIR");
        divBtn.add(botao);

        sidePainel.add(divBtn);
    }


    private void inserirMainTabela(JPanel mainPainel){
        JPanel divTabela = new JPanel();
        divTabela.setLayout(new GridLayout(0, 1));

        JLabel cabecalhoMain = new JLabel("Tabela de estudantes", JLabel.CENTER);
        tabela = new JTable(20,9);

        divTabela.add(cabecalhoMain);
        divTabela.add(tabela);

        mainPainel.add(divTabela);
    }

}
