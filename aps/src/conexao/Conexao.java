package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    // URL de conexão com o banco de dados
    private static final String URL = "jdbc:mysql://localhost:3306/aps";
    private static final String USER = "localhost"; 
    private static final String PASSWORD = "123456";

    private static Connection conn;
    
    public static Connection getConecao() {
        try {
            if(conn == null) { // Verifica se a conexão é nula ou fechada
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
            } 
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // Retorna null em caso de falha na conexão
        }
    }
}
