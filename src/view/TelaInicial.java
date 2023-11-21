package src.view;
import javax.swing.*;
import java.awt.*;


import src.model.CadastroAluno;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial extends JPanel {
    // Atributos
    private Tela tela;
    private JToolBar sidePainel;
    private JButton botao;
    private JPanel mainPainel;
    private JTable tabela;
    private JButton botaoExcluir;

    // Construtor
    public TelaInicial(Tela tela) {
        this.tela = tela;

        setLayout(new GridLayout(0,2));

        inserirSidePainel();
        inserirMainPainel();
    }
    // Métodos
    private void inserirSidePainel(){
        JToolBar sidePainel = new JToolBar();
        sidePainel.setFloatable(false);
        sidePainel.setOrientation(1);
        inserirBotoes(sidePainel);
        add(sidePainel);
    }
    private void inserirMainPainel(){
        mainPainel = new JPanel();
        JLabel cabecalhoMain = new JLabel("Tabela de estudantes");

        mainPainel.add(cabecalhoMain);
        inserirTabela(mainPainel);
        add(mainPainel);
    }
    private void inserirBotoes(JToolBar sidePainel){
        botao = new JButton("CRIAR");
        sidePainel.add(botao);
        botao = new JButton("ATUALIZAR");
        sidePainel.add(botao);
        botaoExcluir = new JButton("EXCLUIR");
        botaoExcluir.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
               //CadastroAluno cadastroAluno
            }
        });
       
        sidePainel.add(botaoExcluir);
    }

   

    private void inserirTabela(JPanel mainPainel){
        tabela = new JTable(20,9);
        mainPainel.add(tabela);
    }
}
