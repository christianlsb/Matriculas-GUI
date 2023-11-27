package src.view;
import javax.swing.*;
import java.awt.*;

import static java.awt.GridBagConstraints.LINE_START;

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
        c.weightx = 0.5;
        c.weighty = 0.5;

        setLayout(layout);

        inserirSidePainel();
        inserirMainPainel();
    }
    // Métodos
    private void inserirSidePainel(){
        sidePainel = new JPanel();
        sidePainel.setLayout(layout);
        sidePainel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        inserirSideBotoes(sidePainel);
        add(sidePainel, c);
    }
    // Y altura, X comprimento
    private void inserirSideBotoes(JPanel sidePainel){
        JPanel divBtn = new JPanel();
        divBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        divBtn.setLayout(layout);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10,20,10,20);

        c.gridx = 0;
        c.gridy = 0;
        botao = new JButton("CRIAR");
        divBtn.add(botao, c);

        c.gridx = 0;
        c.gridy = 1;
        botao = new JButton("ATUALIZAR");
        divBtn.add(botao, c);

        c.gridx = 0;
        c.gridy = 2;
        botao = new JButton("EXCLUIR");
        divBtn.add(botao, c);

        
        c.gridx = 0;
        c.gridy = 0;
        sidePainel.add(divBtn, c);
    }

    private void inserirSideImg(JPanel sidePainel){
        ImageIcon user_icon = new ImageIcon("/src/images/user_img.png");

    }

    private void inserirMainPainel(){
        mainPainel = new JPanel();
        mainPainel.setLayout(layout);
        mainPainel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        c.gridx = 1;
        c.gridy = 0;

        inserirMainTabela(mainPainel);
        add(mainPainel, c);
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
