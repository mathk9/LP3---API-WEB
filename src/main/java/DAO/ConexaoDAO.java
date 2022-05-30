package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDAO {
    
    public Connection conectaBD() throws ClassNotFoundException{
        Connection conn = null;
        
        try {
            String url = "jdbc:mysql://localhost/apprender?user=root&password=";
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url);
            
        } catch (SQLException erro) {           
            System.out.println("Erro ConexaoDAO => "+erro);
        }
        return conn;
    }
    
}
