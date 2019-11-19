package br.com.drogaria.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Aurora
 */
public class ConexaoFactory {
    
    private static final String URL = "jdbc:mysql://localhost:3306/drogaria?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "euusonetbeans8";
    
    public static Connection conectar() throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection conexao = DriverManager.getConnection(URL, USER, PASSWORD);
        return conexao;
    }
    
    public static void main(String[] args) {
        try{
            Connection conexao = ConexaoFactory.conectar();
            System.out.println("Conectado com sucesso!");
        }catch(SQLException ex) {
            ex.printStackTrace();
            System.out.println("Não foi possivel conectar!");
        }
    }
    
}
