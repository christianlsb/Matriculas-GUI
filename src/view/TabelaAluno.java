package src.view;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import src.model.CadastroAluno;

public class TabelaAluno extends AbstractTableModel  {
    
    //Lista dos cadastros de alunos.
    private ArrayList<CadastroAluno> cadastrosAlunos = new ArrayList<CadastroAluno>();

    //Array que titula as colunas da tabela:
    private String[] colunas = new String[] {"Nome completo", "Idade", "E-mail", 
                                            "Endereço", "CEP", "Telefone",
                                            "Curso", "Observações", "Ativo"};

    //Construtor:
    public TabelaAluno(ArrayList<CadastroAluno> cadastrosAlunos){
        this.cadastrosAlunos = cadastrosAlunos;
    }
    //Método que retorna a quantidade de linhas da tabela (JTable):
	@Override
	public int getRowCount() {
		return cadastrosAlunos.size();
	}
    //Método que retorna a quantidade de linhas da tabela (JTable):
	@Override
	public int getColumnCount() {
		return colunas.length;
	}

    //Método que retorna os nomes das colunas (O JTable itera pra passar por todas):
	@Override
	public String getColumnName(int indexColuna) {
		String nomeColuna = null;

		if (indexColuna >= 0 && indexColuna < colunas.length) {
			nomeColuna = colunas[indexColuna];
		}
        //Se inválido retorna String vazia.
		return nomeColuna;
	}
	@Override
	public Object getValueAt(int indexLinha, int indexColuna) {
		String value = null;

		if (indexLinha >= 0 && indexLinha < cadastrosAlunos.size()) {
			CadastroAluno cadastroAluno = cadastrosAlunos.get(indexLinha);

			switch (indexColuna) {
			case 0:
				value = cadastroAluno.getNomeCompleto();
				break;
			case 1:
				value = Integer.toString(cadastroAluno.getIdadeMatricula());
				break;
			case 2:
				value = cadastroAluno.getEmail();
				break;
            case 3:
                value = cadastroAluno.getEndereco();
            case 4:
                value = cadastroAluno.getCep();
            case 5:
                value = cadastroAluno.getTelefone();
            case 6:
                value = cadastroAluno.getCurso();
            case 7:
                value = cadastroAluno.getObservacoes();
            case 8:
                value = Boolean.toString(cadastroAluno.getAtivo());
			default:
				System.err.printf("[ERRO] Índice de coluna inválido: %d\n", indexColuna);
			}
		}
		return value;
	}
}//Fim da classe TabelaAluno

