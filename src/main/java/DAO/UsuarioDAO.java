package DAO;

import DTO.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    
    Connection conn;
    
    public ResultSet autenticacaoUsauario(UsuarioDTO objusuariodto) throws ClassNotFoundException{
        
        conn = new ConexaoDAO().conectaBD();
        try {            
            
            String sql = "SELECT * FROM Usuario WHERE NomeUsuario = ? AND Senha = ?";
            
            String senha = HashFunctions.getHashInstance().getHash(objusuariodto.getSenha_usuario().getBytes(), "SHA-256");
            
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, objusuariodto.getNome_usuario());
            pstm.setString(2, senha);
            
            ResultSet rs = pstm.executeQuery();
            return rs;
            
        } catch (SQLException erro) {
        	
            System.out.println("Erro AutenticacaoUser=> "+erro);
            return null;
        }
        
    }  
    
    public boolean cadastrarUsuario(UsuarioDTO objusuariodto) throws ClassNotFoundException {
        
         conn = new ConexaoDAO().conectaBD();
         
         try {
            String sql = "INSERT INTO Usuario (NomeUsuario, Email, Senha) VALUES (?, ?, ?)";
            
            //String senha = objusuariodto.getSenha_usuario();
            String senha = HashFunctions.getHashInstance().getHash(objusuariodto.getSenha_usuario().getBytes(), "SHA-256");
            
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, objusuariodto.getNome_usuario());
            pstm.setString(2, objusuariodto.getEmail());
            pstm.setString(3, senha);

            
            pstm.execute();
            pstm.close();
            return true;
             
        } catch (SQLException erro) {
            
        	System.out.println("Erro CadUserDAO=> "+erro);                
            return false;            
        }
        
    }
}
