package src.view;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;


public class Tela extends JFrame {
    // Atributos
    public static final String titulo = "TELA INICIALs";
    private CardLayout cardLayout;
    private JPanel cardPainel;
    private TelaInicial telaInicial;
    private TelaCadastro telaCadastro;

    // Construtor
    public Tela(){
        super(titulo);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.cardLayout = new CardLayout();
        
        this.cardPainel = new JPanel();
        this.cardPainel.setLayout(cardLayout);
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
        telaCadastro = new TelaCadastro();
        cardPainel.add(telaCadastro, TelaCadastro.class.getName());
    }
} // Fim da classe TelaPrincipal