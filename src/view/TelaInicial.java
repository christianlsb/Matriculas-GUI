package src.view;
import javax.swing.*;

import src.model.ArmazenamentoAlunos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial extends JPanel {
    // Atributos
    private Tela tela;
    private GridBagLayout layout;
    private GridBagConstraints c;
    private JPanel sidePainel;
    private JPanel mainPainel;
    private JTable tabela;
    private ArmazenamentoAlunos armazenamentoAlunos;

    // Construtor
    public TelaInicial(Tela tela) {
        this.tela = tela;

        layout = new GridBagLayout();
        c = new GridBagConstraints();

        setLayout(layout);

        inserirSidePainel();
        inserirMainPainel();
    }
    // Métodos
    private void inserirSidePainel(){
        sidePainel = new JPanel();
        sidePainel.setLayout(layout);

        inserirSideBotoes(sidePainel);
        inserirSideIcone(sidePainel);
        // GridConstraints de TelaInicial
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0,0,0,0);
        add(sidePainel, c);
    }

    private void inserirSideBotoes(JPanel sidePainel){
        JPanel btnPainel = new JPanel();
        btnPainel.setLayout(layout);

        // Criando e adicionando os botões a btnPainel
        JButton botao;

        botao = new JButton("CRIAR");
        estilizarBtn(botao,0,0);
        botao.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tela.mostrarTelaCadastro();
            }
        });
        btnPainel.add(botao);

        botao = new JButton("ATUALIZAR");
        estilizarBtn(botao,0,1);
        btnPainel.add(botao);

        botao = new JButton("EXCLUIR");
        estilizarBtn(botao,0,2);
        btnPainel.add(botao);

        // GridConstraints de btnPainel
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0,0,0,0);
        sidePainel.add(btnPainel, c);
    }

    private void inserirSideIcone(JPanel sidePainel) {
        ImageIcon icone = new ImageIcon("src/img/icon.png");
        JLabel labelIcone = new JLabel(icone, SwingConstants.LEADING);

        // GridConstraints de labelIcone
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(0,5,0,0);
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

    private void inserirMainTabela(JPanel mainPainel){
        c.insets = new Insets(10,30,10,30);

        JLabel cabecalhoMain = new JLabel("Tabela de estudantes", JLabel.CENTER);
        cabecalhoMain.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        mainPainel.add(cabecalhoMain, c);

        TabelaAluno tableModel = new TabelaAluno(ArmazenamentoAlunos.listar());
        tabela = new JTable(27,9);
        c.gridx = 0;
        c.gridy = 1;
        c.fill = GridBagConstraints.BOTH;
        mainPainel.add(tabela, c);
    }

    private void estilizarBtn(JButton botao, int gridx, int gridy){
        botao.setPreferredSize(new Dimension(130,50));
        botao.setFont(new Font("Times New Roman", Font.PLAIN, 17));

        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(50,60,50,60);
        c.gridx = gridx;
        c.gridy = gridy;

        layout.setConstraints(botao, c);
    }
}// Fim da classe TelaInicial
