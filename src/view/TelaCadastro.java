package src.view;

import javax.swing.*;

import src.model.Aluno;
import src.model.ArmazenamentoAlunos;
import src.model.CadastroAluno;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class TelaCadastro extends JPanel {
    private static final Insets FIELD_INSETS = new Insets(5, 10, 0, 0);
    private Aluno aluno;
    private CadastroAluno cadastro;
    private Tela tela;

    private GridBagLayout layout;
    private GridBagConstraints constraints;

    private JTextField nomeCompletoTxt;
    private JTextField idadeMatriculaTxt;
    private JTextField emailTxt;
    private JTextField enderecoTxt;
    private JTextField cepTxt;
    private JTextField telefoneTxt;
    private JTextField usuarioTxt;
    private JTextField senhaTxt;
    private JTextField cursoTxt;
    private JTextField observacoesTxt;
    private JCheckBox ativoCb;
    private JButton salvarBtn;
    private JButton cancelarBtn;


    //construtor
    public TelaCadastro(){
        cadastro = null;

        layout = new GridBagLayout();
        constraints = new GridBagConstraints();

        setLayout(layout);
        addComponentListener(new ComponentAdapter(){
            @Override
            public void componentShown(ComponentEvent e){
                if (cadastro == null){
                    nomeCompletoTxt.setText("");
                    idadeMatriculaTxt.setText("");
                    emailTxt.setText("");
                    enderecoTxt.setText("");
                    cepTxt.setText("");
                    telefoneTxt.setText("");
                    usuarioTxt.setText("");
                    senhaTxt.setText("");
                    cursoTxt.setText("");
                    observacoesTxt.setText("");
                    ativoCb.setSelected(false);
                }else {
                    nomeCompletoTxt.setText(cadastro.getNomeCompleto());
                    idadeMatriculaTxt.setText(Integer.toString(cadastro.getIdadeMatricula()));
                    emailTxt.setText(cadastro.getEmail());
                    enderecoTxt.setText(cadastro.getEndereco());
                    cepTxt.setText(cadastro.getCep());
                    telefoneTxt.setText(cadastro.getTelefone());
                    usuarioTxt.setText(cadastro.getUsuario());
                    senhaTxt.setText(cadastro.getSenha());
                    cursoTxt.setText(cadastro.getCurso());
                    observacoesTxt.setText(cadastro.getObservacoes());
                    ativoCb.setSelected(cadastro.getAtivo());

                }
            } 
        });

        criarForm();
    }

    public void setCadastro(CadastroAluno cadastro){
        this.cadastro = cadastro;
    }

    private void criarForm(){

        JLabel nome;

        nome = new JLabel("Nome Completo");
        adicionarComponente(nome, 0, 0);
        nomeCompletoTxt = new JTextField(10);
        nomeCompletoTxt.setEditable(true);
        adicionarComponente(nomeCompletoTxt, 0, 1);

        nome = new JLabel("Idade Matricula");
        adicionarComponente(nome, 0, 2);
        idadeMatriculaTxt = new JTextField(10);
        idadeMatriculaTxt.setEditable(true);
        adicionarComponente(idadeMatriculaTxt, 0, 3);

        nome = new JLabel("Email");
        adicionarComponente(nome, 1, 0);
        emailTxt = new JTextField(10);
        emailTxt.setEditable(true);
        adicionarComponente(emailTxt, 1, 1);

        nome = new JLabel("Endereco");
        adicionarComponente(nome, 1, 2);
        enderecoTxt = new JTextField(10);
        enderecoTxt.setEditable(true);
        adicionarComponente(enderecoTxt, 1, 3);

        nome = new JLabel("Cep");
        adicionarComponente(nome, 2, 0);
        cepTxt = new JTextField(10);
        cepTxt.setEditable(true);
        adicionarComponente(cepTxt, 2, 1);

        nome = new JLabel("Telefone");
        adicionarComponente(nome, 2, 2);
        telefoneTxt = new JTextField(10);
        telefoneTxt.setEditable(true);
        adicionarComponente(telefoneTxt, 2, 3);

        nome = new JLabel("Usuario");
        adicionarComponente(nome, 3, 0);
        usuarioTxt = new JTextField(10);
        usuarioTxt.setEditable(true);
        adicionarComponente(usuarioTxt, 3, 1);

        nome = new JLabel("Senha");
        adicionarComponente(nome, 3, 2);
        senhaTxt = new JTextField(10);
        senhaTxt.setEditable(true);
        adicionarComponente(senhaTxt, 3, 3);

        nome = new JLabel("Curso");
        adicionarComponente(nome, 4, 0);
        cursoTxt = new JTextField(10);
        cursoTxt.setEditable(true);
        adicionarComponente(cursoTxt, 4, 1);

        nome = new JLabel("Observações");
        adicionarComponente(nome, 4, 2);
        observacoesTxt = new JTextField(10);
        observacoesTxt.setEditable(true);
        adicionarComponente(observacoesTxt, 4, 3);

        nome = new JLabel("Aluno Ativo");
        adicionarComponente(nome, 5, 0);
        ativoCb = new JCheckBox();
        ativoCb.setFocusable(true);
        adicionarComponente(ativoCb, 5, 1);

        criarBotoes();

    }
    private void adicionarComponente(JComponent componente, int linha, int coluna) {
		adicionarComponente(componente, linha, coluna, 1, 1);
	}
    private void adicionarComponente(JComponent componente, int linha, int coluna, int largura, int altura) {
		constraints.gridx = coluna;
		constraints.gridy = linha;
		constraints.gridwidth = largura;
		constraints.gridheight = altura;

		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = FIELD_INSETS;

		layout.setConstraints(componente, constraints);
		add(componente);
	}

    private void criarBotoes() {
		JPanel btnPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) btnPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);

		criarSalvarBtn(btnPanel);
		criarCancelarBtn(btnPanel);

		adicionarComponente(btnPanel, 7, 1, 2, 1);
	}

    private void criarSalvarBtn(JPanel panel){
        salvarBtn = new JButton("Salvar");
        salvarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (cadastro == null){
                    cadastro = new CadastroAluno();
                    cadastro.setNomeCompleto(nomeCompletoTxt.getText());
                    cadastro.setIdadeMatricula(Integer.parseInt(idadeMatriculaTxt.getText()));
                    cadastro.setEmail(emailTxt.getText());
                    cadastro.setEndereco(enderecoTxt.getText());
                    cadastro.setCep(cepTxt.getText());
                    cadastro.setTelefone(telefoneTxt.getText());
                    cadastro.setUsuario(usuarioTxt.getText());
                    cadastro.setSenha(senhaTxt.getText());
                    cadastro.setCurso(cursoTxt.getText());
                    cadastro.setObservacoes(observacoesTxt.getText());
                    cadastro.setAtivo(ativoCb.isSelected());
                    ArmazenamentoAlunos.inserir(aluno);
                }else{
                    cadastro = new CadastroAluno();
                    cadastro.setNomeCompleto(nomeCompletoTxt.getText());
                    cadastro.setIdadeMatricula(Integer.parseInt(idadeMatriculaTxt.getText()));
                    cadastro.setEmail(emailTxt.getText());
                    cadastro.setEndereco(enderecoTxt.getText());
                    cadastro.setCep(cepTxt.getText());
                    cadastro.setTelefone(telefoneTxt.getText());
                    cadastro.setUsuario(usuarioTxt.getText());
                    cadastro.setSenha(senhaTxt.getText());
                    cadastro.setCurso(cursoTxt.getText());
                    cadastro.setObservacoes(observacoesTxt.getText());
                    cadastro.setAtivo(ativoCb.isSelected());
                    ArmazenamentoAlunos.atualizar(aluno);
                }
                JOptionPane.showMessageDialog(TelaCadastro.this, "Cadastro feito com sucesso!", Tela.titulo,
						JOptionPane.INFORMATION_MESSAGE);

                    tela.mostrarTelaInicial();

            }
        });
        panel.add(salvarBtn);
    }

    private void criarCancelarBtn(JPanel panel){
        cancelarBtn = new JButton("Cancelar");
        cancelarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                tela.mostrarTelaInicial();
            }
        });
        panel.add(cancelarBtn);
    }
}
    