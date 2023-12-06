import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ArmazenamentoAlunos {

	public static void inserir(Aluno aluno) {
        String query = "INSERT INTO aluno (nomeCompleto, idade, email, endereco, cep, telefone,usuario, senha, curso,observacoes,ativo) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        Connection conexao = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            conexao = ConexaoFactory.getConexao();
            //conectar*
            conexao = ConexaoFactory.getConexao();
            //Já é feito a passagem da query.
            statement = conexao.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, aluno.getNomeCompleto());
            statement.setInt(2, aluno.getIdade());
            statement.setString(3, aluno.getEmail());
            statement.setString(4, aluno.getEndereco());
            statement.setString(5, aluno.getCep());
            statement.setString(6, aluno.getTelefone());
            statement.setString(7, aluno.getUsuario());
            statement.setString(8, aluno.getSenha());
            statement.setString(9, aluno.getCurso());
            statement.setString(10, aluno.getObservacoes());
            statement.setBoolean(11, aluno.getAtivo());
            //statement.setInt(9, aluno.getId());
            //A query já foi executada, então não precisa executar novamente.
            statement.execute();
            resultSet = statement.getGeneratedKeys();

            while (resultSet.next()) {
                aluno.setId(resultSet.getInt(1));   
            }
            
        }catch(Exception erro){
            erro.printStackTrace();
        }
	}//Fim do método inserir.

	public static void atualizar(Aluno aluno) {
        //Se o campo vier vazio, ele atualiza para o que já estava no banco.
		String query = "UPDATE aluno SET nomeCompleto = ?, idade = ?, email = ?, endereco = ?, cep = ?, telefone = ?, usuario = ?, senha = ?, curso = ?, observacoes = ?, ativo = ? WHERE id = ?";

        Connection conexao = null;
        PreparedStatement statement = null;

        try{
            //conectar*
            conexao = ConexaoFactory.getConexao();
            //Já é feito a passagem da query.
            statement = conexao.prepareStatement(query);
            statement.setString(1, aluno.getNomeCompleto());
            statement.setInt(2, aluno.getIdade());
            statement.setString(3, aluno.getEmail());
            statement.setString(4, aluno.getEndereco());
            statement.setString(5, aluno.getCep());
            statement.setString(6, aluno.getTelefone());
            statement.setString(7, aluno.getUsuario());
            statement.setString(8, aluno.getSenha());
            statement.setString(9, aluno.getCurso());
            statement.setString(10, aluno.getObservacoes());
            statement.setBoolean(11, aluno.getAtivo());
            statement.setInt(12, aluno.getId());
            //A query já foi executada, então não precisa executar novamente.
            statement.execute();
        }catch(Exception erro){
            erro.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
	}//Fim do método atualizar.

	public static void remover(Aluno aluno) {
        //Não dá pra saber o id, então usa ? e troca pelo valor definido no parâmetro.
        String query = "DELETE FROM aluno WHERE id = ?";

        Connection conexao = null;
        PreparedStatement statement = null;

        try{
            //conectar*
            conexao = ConexaoFactory.getConexao();
            //Já é feito a passagem da query.
            statement = conexao.prepareStatement(query);
            statement.setInt(1, aluno.getId());
            //A query já foi executada, então não precisa executar novamente.
            statement.execute();

        }catch(Exception erro){
            erro.printStackTrace();
        }
	}

	public static ArrayList<Aluno> listar() {
        ArrayList<Aluno> alunos = new ArrayList<>();
        
        String query = "SELECT * FROM aluno ORDER BY id";
        Connection conexao = null;
        Statement statement = null;
        ResultSet resultSet = null;
        //Tenta executar o bloco, se falhar levanta a exceção definida.
        try{
            conexao = ConexaoFactory.getConexao();
            //A partir da conexão cria o statement.
            statement = conexao.createStatement();
            //Aloca os results da query.
            resultSet = statement.executeQuery(query);
            
            //Vai processar cada linha do result, quando acabar o next será falso.
            while(resultSet.next()){
                Aluno aluno = new Aluno();

                aluno.setId(resultSet.getInt("id"));
                aluno.setNomeCompleto(resultSet.getString("nomeCompleto"));
                aluno.setIdade(resultSet.getInt("idade"));
                aluno.setEmail(resultSet.getString("email"));
                aluno.setEndereco(resultSet.getString("endereco")); 
                aluno.setCep(resultSet.getString("cep"));
                aluno.setTelefone(resultSet.getString("telefone"));
                aluno.setUsuario(resultSet.getString("usuario"));
                aluno.setSenha(resultSet.getString("senha"));
                aluno.setCurso(resultSet.getString("curso"));
                aluno.setObservacoes(resultSet.getString("observacoes"));
                aluno.setAtivo(resultSet.getBoolean("ativo"));

                alunos.add(aluno);
            }
        } catch(Exception erro){
            //Joga os erros no terminal.
            erro.printStackTrace();
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (resultSet != null)
                    resultSet.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
		return alunos;
	} //  Fim do método listar
}//Fim da classe ArmazenamentoAlunos


