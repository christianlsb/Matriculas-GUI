import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class TelaCadastro extends JPanel {
    // Atributos
    private static final Insets FIELD_INSETS = new Insets(5, 10, 0, 0);

    private Tela tela;
    private Aluno cadastro;

    private GridBagLayout layout;
    private GridBagConstraints constraints;

    private JTextField idTxt;
    private JTextField nomeCompletoTxt;
    private JTextField idadeMatriculaTxt;
    private JTextField emailTxt;
    private JTextField enderecoTxt;
    private JTextField cepTxt;
    private JTextField telefoneTxt;
    private JTextField usuarioTxt;
    private JTextField senhaTxt;
    private JComboBox<String> cursoTxt;
    private JTextArea observacoesTxt;
    private JCheckBox ativoCb;
    private JButton salvarBtn;
    private JButton cancelarBtn;
    private boolean campoVazioEncontrado;

    //construtor
    public TelaCadastro(Tela tela){
        this.tela = tela;

        cadastro = null;

        layout = new GridBagLayout();
        constraints = new GridBagConstraints();

        setLayout(layout);
        addComponentListener(new ComponentAdapter(){
            @Override
            public void componentShown(ComponentEvent e){
                if (cadastro == null){
                    idTxt.setText("");
                    nomeCompletoTxt.setText("");
                    idadeMatriculaTxt.setText("");
                    emailTxt.setText("");
                    enderecoTxt.setText("");
                    cepTxt.setText("");
                    telefoneTxt.setText("");
                    usuarioTxt.setText("");
                    senhaTxt.setText("");
                    cursoTxt.setToolTipText("");
                    observacoesTxt.setText("");
                    ativoCb.setSelected(false);
                }else {
                    idTxt.setText(Integer.toString(cadastro.getId()));
                    nomeCompletoTxt.setText(cadastro.getNomeCompleto());
                    idadeMatriculaTxt.setText(Integer.toString(cadastro.getIdade()));
                    emailTxt.setText(cadastro.getEmail());
                    enderecoTxt.setText(cadastro.getEndereco());
                    cepTxt.setText(cadastro.getCep());
                    telefoneTxt.setText(cadastro.getTelefone());
                    usuarioTxt.setText(cadastro.getUsuario());
                    senhaTxt.setText(cadastro.getSenha());
                    cursoTxt.setToolTipText(cadastro.getCurso());
                    observacoesTxt.setText(cadastro.getObservacoes());
                    ativoCb.setSelected(cadastro.getAtivo());

                }
            } 
        });

        criarForm();
    }

    public void setCadastro(Aluno cadastro){
        this.cadastro = cadastro;
    }

    private void criarForm(){

        JLabel nome;

        nome = new JLabel("Nome completo");
        adicionarComponente(nome, 0, 0);
        nomeCompletoTxt = new JTextField(10);
        nomeCompletoTxt.setEditable(true);
        adicionarComponente(nomeCompletoTxt, 0, 1);

        idTxt = new JTextField();

        nome = new JLabel("Idade completa");
        adicionarComponente(nome, 0, 2);
        idadeMatriculaTxt = new JTextField(10);
        idadeMatriculaTxt.setEditable(true);
        adicionarComponente(idadeMatriculaTxt, 0, 3);

        nome = new JLabel("E-mail");
        adicionarComponente(nome, 1, 0);
        emailTxt = new JTextField(10);
        emailTxt.setEditable(true);
        adicionarComponente(emailTxt, 1, 1);

        nome = new JLabel("Endereço");
        adicionarComponente(nome, 1, 2);
        enderecoTxt = new JTextField(10);
        enderecoTxt.setEditable(true);
        adicionarComponente(enderecoTxt, 1, 3);

        nome = new JLabel("CEP");
        adicionarComponente(nome, 2, 0);
        cepTxt = new JTextField(10);
        cepTxt.setEditable(true);
        adicionarComponente(cepTxt, 2, 1);

        nome = new JLabel("Telefone");
        adicionarComponente(nome, 2, 2);
        telefoneTxt = new JTextField(10);
        telefoneTxt.setEditable(true);
        adicionarComponente(telefoneTxt, 2, 3);

        nome = new JLabel("Usuário");
        adicionarComponente(nome, 3, 0);
        usuarioTxt = new JTextField(10);
        usuarioTxt.setEditable(true);
        adicionarComponente(usuarioTxt, 3, 1);

        nome = new JLabel("Senha");
        adicionarComponente(nome, 3, 3);
        senhaTxt = new JPasswordField(10);
        senhaTxt.setEditable(true);
        adicionarComponente(senhaTxt, 3, 3);

        nome = new JLabel("Curso");
        adicionarComponente(nome, 4, 0);
        cursoTxt = new JComboBox<String>();
        cursoTxt.addItem("");
        cursoTxt.addItem("Análise e Desenvolvimento de Sistemas");
        cursoTxt.addItem("Ciência da Computação");
        cursoTxt.addItem("Engenharia da Computação");
        cursoTxt.addItem("Engenharia de Software");
        cursoTxt.addItem("Gestão da Tecnologia da Informação");
        cursoTxt.addItem("Sistemas de Informação");
        cursoTxt.setEditable(false);
        adicionarComponente(cursoTxt, 4, 1);

        nome = new JLabel("Observações");
        adicionarComponente(nome, 4, 2);
        observacoesTxt = new JTextArea();
        observacoesTxt.setEditable(true);
        observacoesTxt.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(observacoesTxt);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
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

    private Aluno criarAluno(){
        cadastro = new Aluno();
        cadastro.setNomeCompleto(nomeCompletoTxt.getText());
        cadastro.setIdade(Integer.parseInt(idadeMatriculaTxt.getText()));
        cadastro.setEmail(emailTxt.getText());
        cadastro.setEndereco(enderecoTxt.getText());
        cadastro.setCep(cepTxt.getText());
        cadastro.setTelefone(telefoneTxt.getText());
        cadastro.setUsuario(usuarioTxt.getText());
        cadastro.setSenha(senhaTxt.getText());
        cadastro.setCurso((String) cursoTxt.getSelectedItem());
        cadastro.setObservacoes(observacoesTxt.getText());
        cadastro.setAtivo(ativoCb.isSelected());
        return cadastro;
    }

    private void criarSalvarBtn(JPanel panel){
        salvarBtn = new JButton("Salvar");
        salvarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (!validarCampos()) {
                    return;
                }else{
                    if (cadastro == null){
                        cadastro = criarAluno();
                        ArmazenamentoAlunos.inserir(cadastro);
                        JOptionPane.showMessageDialog(TelaCadastro.this, "Cadastro feito com sucesso!", null,
                                JOptionPane.INFORMATION_MESSAGE);
                        cadastro = null;
                        tela.mostrarTelaInicial();
                    } else {
                        cadastro = criarAluno();
                        cadastro.setId(Integer.parseInt(idTxt.getText()));
                        ArmazenamentoAlunos.atualizar(cadastro);
                        JOptionPane.showMessageDialog(TelaCadastro.this, "Cadastro atualizado com sucesso!", null,
                                JOptionPane.INFORMATION_MESSAGE);
                        tela.mostrarTelaInicial();
                    }
                }
            }
        });
        panel.add(salvarBtn);
    }

    private boolean validarCampos() {
        campoVazioEncontrado = false;
        validarCampoVazio("Nome completo", nomeCompletoTxt.getText());
        validarCampoVazio("Idade completa", idadeMatriculaTxt.getText());
        validarCampoVazio("E-mail", emailTxt.getText());
        validarCampoVazio("Endereço", enderecoTxt.getText());
        validarCampoVazio("Usuário", usuarioTxt.getText());
        validarCampoVazio("Senha", senhaTxt.getText());
        validarCampoVazio("Curso", (String) cursoTxt.getSelectedItem());
        return !(campoVazioEncontrado);
    }

    private void validarCampoVazio(String campo, String valor) {
        if (valor.equals("")) {
            JOptionPane.showMessageDialog(TelaCadastro.this, "Por favor, insira um " + campo + " válido!", null,
                    JOptionPane.INFORMATION_MESSAGE);
            campoVazioEncontrado = true;
        }
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
    