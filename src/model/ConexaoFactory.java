package src.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//BAIXAR O DRIVER DO SQL!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//Descompactar a pasta, e por o .jar dentro do diretório do projeto.
//Rodar com o comando: java -cp ".;./mysql-connector-j-8.2.0.jar" Main

public class ConexaoFactory { 
    //Protocolo pra conversar com o banco, porta para localizar o processo, database.
    private static final String URL = "jdbc:mysql://localhost:3306/alunos";
    private static final String USER = "root";
    private static final String PASS = "root";

    //Singleton --> Só um objeto desse tipo.
    //Usar uma conexão singleton, para garantir que só tenha uma conexão.

    private static Connection conexao;

    //Construtor privado não deixa dar new.
    private ConexaoFactory(){}

    public static Connection getConexao() throws SQLException{
        //Se não for nula só devolve a conexão.
        if(conexao == null){
            //Se for nula, ainda não conectou e deve fazer a conexão.
            conexao = DriverManager.getConnection(URL, USER, PASS);
            //Exceção de SQL, é melhor jogar pra fora --> "throws SQLException."
        }
        return conexao;
    }
}

