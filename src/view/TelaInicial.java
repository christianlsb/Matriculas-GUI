package src.view;
import javax.swing.*;

import src.model.CadastroAluno;

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

        inserirSideBotoes(sidePainel);
        inserirIconeUsuario(sidePainel);
        // GridConstraints de TelaInicial
        c.gridx = 0;
        c.gridy = 0;
        add(sidePainel, c);
    }

    // Y altura, X comprimento
    private void inserirSideBotoes(JPanel sidePainel){
        JPanel divBtn = new JPanel();
        divBtn.setLayout(layout);

        // GridConstraints de divBtn
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(50,60,50,60);

        botao = new JButton("CRIAR");
        botao.setPreferredSize(new Dimension(130,50));
        botao.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        c.gridx = 0;
        c.gridy = 0;
        divBtn.add(botao, c);

        botao = new JButton("ATUALIZAR");
        botao.setPreferredSize(new Dimension(130,50));
        botao.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        c.gridx = 0;
        c.gridy = 1;
        divBtn.add(botao, c);

        botao = new JButton("EXCLUIR");
        botao.setPreferredSize(new Dimension(130,50));
        botao.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        c.gridx = 0;
        c.gridy = 2;
        divBtn.add(botao, c);

        // GridConstraints de sidePainel
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0,0,0,0);
        sidePainel.add(divBtn, c);
    }

    private void inserirIconeUsuario(JPanel sidePainel) {
        ImageIcon icone = new ImageIcon("src/img/icon.png");

        JLabel labelIcone = new JLabel(icone);

        c.gridx = 0;
        c.gridy = 1;
        sidePainel.add(labelIcone, c);
    }

    private void inserirMainPainel(){
        mainPainel = new JPanel();
        mainPainel.setLayout(layout);

        inserirMainTabela(mainPainel);

        // GridConstraints de TelaInicial
        c.gridx = 1;
        c.gridy = 0;
        add(mainPainel, c);
    }
    // Y altura, X comprimento
    private void inserirMainTabela(JPanel mainPainel){
        c.insets = new Insets(10,30,10,30);

        JLabel cabecalhoMain = new JLabel("Tabela de estudantes", JLabel.CENTER);
        cabecalhoMain.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        mainPainel.add(cabecalhoMain, c);

        tableModel = new TabelaAluno()
        tabela = new JTable(37,9);
        c.gridx = 0;
        c.gridy = 1;
        c.fill = GridBagConstraints.BOTH;
        mainPainel.add(tabela, c);
    }

}
