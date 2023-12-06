

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TabelaAluno extends AbstractTableModel  {
    //Lista dos cadastros de alunos.
    private List<Aluno> cadastrosAlunos = new ArrayList<Aluno>();
    //Array que titula as colunas da tabela:
    private String[] colunas = new String[] {"Nome completo", "Idade", "E-mail", 
                                            "Endereço", "CEP", "Telefone",
                                            "Curso", "Observações", "Ativo"};

    //Construtor:
    public TabelaAluno(ArrayList<Aluno> cadastrosAlunos){
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
			Aluno cadastroAluno = cadastrosAlunos.get(indexLinha);

			switch (indexColuna) {
			case 0:
				value = cadastroAluno.getNomeCompleto();
				break;
			case 1:
				value = Integer.toString(cadastroAluno.getIdade());
				break;
			case 2:
				value = cadastroAluno.getEmail();
				break;
            case 3:
                value = cadastroAluno.getEndereco();
				break;
            case 4:
                value = cadastroAluno.getCep();
				break;
            case 5:
                value = cadastroAluno.getTelefone();
				break;
            case 6:
                value = cadastroAluno.getCurso();
				break;
            case 7:
                value = cadastroAluno.getObservacoes();
				break;
            case 8:
                value = Boolean.toString(cadastroAluno.getAtivo());
				break;
			default:
				System.err.printf("[ERRO] Índice de coluna inválido: %d\n", indexColuna);
			}
		}
		return value;
	}// Fim do método de pegar valor

	public Aluno getCadastroAluno(int indiceLinha) {
		Aluno cadastroAluno = null;

		if (indiceLinha >= 0 && indiceLinha < cadastrosAlunos.size()) {
			cadastroAluno = cadastrosAlunos.get(indiceLinha);
		}
		return cadastroAluno;
	}

	public void carregar(List<Aluno> alunos){
		this.cadastrosAlunos = alunos;
		fireTableDataChanged();
	}

	public void remover(Aluno aluno){
		cadastrosAlunos.remove(aluno);
		fireTableDataChanged();
	}
}//Fim da classe TabelaAluno

