import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
    private JButton botaoCriar;
    private JButton botaoAtualizar;
    private JButton botaoExcluir;

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
   
        adicionarComponente(this, sidePainel, 0, 0);
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
        botaoCriar = new JButton("CRIAR");
        estilizar(botaoCriar,0,0);
        botaoCriar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tela.mostrarTelaCadastro(null);
            }
        });
        btnPainel.add(botaoCriar);

        botaoAtualizar = new JButton("ATUALIZAR");
        estilizar(botaoAtualizar,0,1);
        botaoAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tela.mostrarTelaCadastro(tableModel.getCadastroAluno(tabela.getSelectedRow()));
            }
        });
        btnPainel.add(botaoAtualizar);

        botaoExcluir = new JButton("EXCLUIR");
        estilizar(botaoExcluir,0,2);
        botaoExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Aluno aluno = tableModel.getCadastroAluno(tabela.getSelectedRow());
                int confirmar = JOptionPane.showConfirmDialog(TelaInicial.this, "Quer realmente excluir isto?",
                                                             Tela.titulo, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (confirmar == JOptionPane.YES_OPTION){
                    ArmazenamentoAlunos.remover(aluno);
                    tableModel.remover(aluno);
                }
            }
        });
        btnPainel.add(botaoExcluir);

        adicionarComponente(sidePainel, btnPainel, 0, 0);
        desabilitarBtns();
    } // Fim do método inserirSideBotoes

    private void inserirSideIcone(JPanel sidePainel) {
        ImageIcon icone = new ImageIcon("src/img/icon.png");
        JLabel labelIcone = new JLabel(icone, SwingConstants.CENTER);
        
        adicionarComponente(sidePainel, labelIcone, 0, 1);
    } // Fim do método inserirSideIcone

    private void inserirMainTabela(JPanel mainPainel){
        JLabel cabecalhoMain = new JLabel("Tabela de estudantes", JLabel.CENTER);
        cabecalhoMain.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        adicionarComponente(mainPainel, cabecalhoMain, 0, 0);

        tableModel = new TabelaAluno(ArmazenamentoAlunos.listar());
        tabela = new JTable(tableModel);
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabela.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					if (tabela.getSelectedRow() >= 0) {
						habilitarBtns();
					} else {
						desabilitarBtns();
					}
				}
			}
		});
        estilizar(tabela);
        adicionarComponente(mainPainel, tabela, 0, 1);

        JScrollPane scrollPane = new JScrollPane(tabela);
        adicionarComponente(mainPainel, scrollPane, 0, 2);
    } // Fim do método inserirMainTabela

    private void adicionarComponente(JComponent componentePai, JComponent componente, int gridx, int gridy) {
        c.insets = new Insets(0,0,0,0);
        c.gridx = gridx;
        c.gridy = gridy;
        c.fill = GridBagConstraints.HORIZONTAL;

        componentePai.add(componente, c);
    } // Fim do método adicionarComponente

    private void estilizar(JTable tabela) {
        tabela.setPreferredScrollableViewportSize(new Dimension(700,615));
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(115);
        tabela.getColumnModel().getColumn(7).setPreferredWidth(100);
    } // Fim do método estilizar

    private void estilizar(JButton botao, int gridx, int gridy){
        botao.setPreferredSize(new Dimension(130,50));
        botao.setFont(new Font("Times New Roman", Font.PLAIN, 17));

        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(50,60,50,60);
        c.gridx = gridx;
        c.gridy = gridy;

        layout.setConstraints(botao, c);
    } // Fim do método estilizar

    private void habilitarBtns(){
        botaoAtualizar.setEnabled(true);
        botaoExcluir.setEnabled(true);
    } // Fim do método habilitarBtns

    private void desabilitarBtns(){
        botaoAtualizar.setEnabled(false);
        botaoExcluir.setEnabled(false);
    } // Fim do método habilitarBtns
}// Fim da classe TelaInicial