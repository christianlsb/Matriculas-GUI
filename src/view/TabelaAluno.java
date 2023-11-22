package src.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import src.model.Aluno;

public class TabelaAluno extends AbstractTableModel  {
    
    //Lista dos cadastros de alunos.
    private ArrayList<Aluno> alunos = new ArrayList<Aluno>();

    //Array que titula as colunas da tabela:
    private String[] colunas = new String[] {"Nome completo", "Idade", "E-mail", 
                                            "Endereço", "CEP", "Telefone",
                                            "Curso", "Observações", "Ativo"};

    //Construtor:
    public TabelaAluno(ArrayList<Aluno> alunos){
        this.alunos = alunos;
    }
    //Método que retorna a quantidade de linhas da tabela (JTable):
	@Override
	public int getRowCount() {
		return alunos.size();
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
	//Método que retorna o valor de acordo com o index da coluna e da linha.
	@Override
	public Object getValueAt(int indexLinha, int indexColuna) {
		String value = null;

		if (indexLinha >= 0 && indexLinha < alunos.size()) {
			Aluno aluno = alunos.get(indexLinha);

			switch (indexColuna) {
			case 0:
				value = aluno.getNomeCompleto();
				break;
			case 1:
				value = Integer.toString(aluno.getIdade());
				break;
			case 2:
				value = aluno.getEmail();
				break;
            case 3:
                value = aluno.getEndereco();
            case 4:
                value = aluno.getCep();
            case 5:
                value = aluno.getTelefone();
            case 6:
                value = aluno.getCurso();
            case 7:
                value = aluno.getObservacoes();
            case 8:
                value = Boolean.toString(aluno.getAtivo());
			default:
				System.err.printf("Erro! O índex %d da coluna não é válido.\n", indexColuna);
			}
		}
		return value;
	}

	//Método que retorna o aluno na linha do index parâmetro.
	public Aluno getAluno(int indexLinha){
		//Se o index não for válido retorna um aluno null.
		Aluno aluno = null;
		
		//Busca o aluno de acordo com o index da linha.
		if(indexLinha >= 0 && indexLinha < alunos.size()){
			aluno = alunos.get(indexLinha);
		}

		return aluno;
	}

	public void carregar(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
		fireTableDataChanged();
	}

	public void remover(Aluno aluno) {
		alunos.remove(aluno);
		fireTableDataChanged();
	}

}//Fim da classe TabelaAluno

