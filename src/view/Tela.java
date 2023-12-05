package src.view;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;


public class Tela extends JFrame {
    // Atributos
    public static final String titulo = "TELA INICIAL";
    private CardLayout cardLayout;
    private JPanel cardPainel;
    private TelaInicial telaInicial;
    private TelaCadastro telaCadastro;

    // Construtor
    public Tela(){
        super(titulo);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);

        this.cardLayout = new CardLayout();
        
        cardPainel = new JPanel();
        cardPainel.setLayout(cardLayout);
        add(cardPainel);

        criarCards();
    }

    // Métodos
    public void mostrar(){
        pack();
		setLocationRelativeTo(null);
		setVisible(true);
    }
    private void criarCards(){
        telaInicial = new TelaInicial(this);
        cardPainel.add(telaInicial, TelaInicial.class.getName());

        telaCadastro = new TelaCadastro(this);
        cardPainel.add(telaCadastro, TelaCadastro.class.getName());
    }

    public void mostrarTelaCadastro(){
        cardLayout.show(cardPainel, TelaCadastro.class.getName());
    }

    public void mostrarTelaInicial(){
        cardLayout.show(cardPainel, TelaInicial.class.getName());
    }
} // Fim da classe TelaPrincipal