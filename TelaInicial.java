import javax.swing.*;

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
    private TabelaAluno tableModel;
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
    public void recarregar(){
        tableModel.carregar(ArmazenamentoAlunos.listar());
    }

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

    private void inserirMainPainel(){
        mainPainel = new JPanel();
        mainPainel.setLayout(layout);

        inserirMainTabela(mainPainel);

        // GridConstraints de TelaInicial
        c.insets = new Insets(10,30,5,30);
        c.gridx = 1;
        c.gridy = 0;
        c.anchor = GridBagConstraints.NORTH;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(mainPainel, c);
    }

    private void inserirSideBotoes(JPanel sidePainel){
        JPanel btnPainel = new JPanel();
        btnPainel.setLayout(layout);

        // Criando e adicionando os botões a btnPainel
        JButton botao;

        botao = new JButton("CRIAR");
        estilizar(botao,0,0);
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tela.mostrarTelaCadastro(null);
            }
        });
        btnPainel.add(botao);

        botao = new JButton("ATUALIZAR");
        estilizar(botao,0,1);
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnPainel.add(botao);

        botao = new JButton("EXCLUIR");
        estilizar(botao,0,2);
        btnPainel.add(botao);

        // GridConstraints de btnPainel
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0,0,0,0);
        sidePainel.add(btnPainel, c);
    }

    private void inserirSideIcone(JPanel sidePainel) {
        ImageIcon icone = new ImageIcon("src/src.img/icon.png");
        JLabel labelIcone = new JLabel(icone, SwingConstants.LEADING);

        // GridConstraints de labelIcone
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(0,0,0,0);
        sidePainel.add(labelIcone, c);
    }

    private void inserirMainTabela(JPanel mainPainel){
        JLabel cabecalhoMain = new JLabel("Tabela de estudantes", JLabel.CENTER);
        cabecalhoMain.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        adicionarComponentes(mainPainel, cabecalhoMain, 0, 0);

        tableModel = new TabelaAluno(ArmazenamentoAlunos.listar());
        tabela = new JTable(tableModel);
        estilizar(tabela);
        adicionarComponentes(mainPainel, tabela, 0, 1);

        JScrollPane scrollPane = new JScrollPane(tabela);
        adicionarComponentes(mainPainel, scrollPane, 0, 2);
    }

    private void adicionarComponentes(JComponent componentePai, JComponent componente, int gridx, int gridy) {
        c.insets = new Insets(0,0,0,0);
        c.gridx = gridx;
        c.gridy = gridy;
        c.fill = GridBagConstraints.HORIZONTAL;

        componentePai.add(componente, c);
    }

    private void estilizar(JTable tabela) {
        tabela.setPreferredScrollableViewportSize(new Dimension(700,615));
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(115);
        tabela.getColumnModel().getColumn(7).setPreferredWidth(100);
    }

    private void estilizar(JButton botao, int gridx, int gridy){
        botao.setPreferredSize(new Dimension(130,50));
        botao.setFont(new Font("Times New Roman", Font.PLAIN, 17));

        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(50,60,50,60);
        c.gridx = gridx;
        c.gridy = gridy;

        layout.setConstraints(botao, c);
    }
}// Fim da classe TelaInicial