package wolframapha.api;

import java.sql.ResultSet;

import DAO.UsuarioDAO;
import DTO.UsuarioDTO;

public class CadastroController {
	
	public String handleBtnCadastrar(String txtUsuario, String txtSenha, String txtEmail) {
		try {
			UsuarioDTO objusuariodto = new UsuarioDTO();
            
            objusuariodto.setNome_usuario(txtUsuario);
            objusuariodto.setSenha_usuario(txtSenha);
            objusuariodto.setEmail(txtEmail);
            
            UsuarioDAO objusuariodao = new UsuarioDAO();
            
            if(objusuariodao.cadastrarUsuario(objusuariodto)) {
            	return txtUsuario;
            }
            return "erro controller";
		}
		catch(Exception e){
			System.out.print("ERRO Controller => "+e.getMessage() + " - " + e);
			return "erro controller catch";
		}
	}
	
	public String handleBtnAutenticar(String txtUsuario, String txtSenha) {
		try {
			UsuarioDTO objusuariodto = new UsuarioDTO();
            
            objusuariodto.setNome_usuario(txtUsuario);
            objusuariodto.setSenha_usuario(txtSenha);
            
            UsuarioDAO objusuariodao = new UsuarioDAO();
            
            ResultSet rsusuariodao = objusuariodao.autenticacaoUsauario(objusuariodto);
            
            if (rsusuariodao.next()) {
            	return txtUsuario + " LOGADO!";
            }
            else {            	
            	return "Não foi possível logar verifique Usuário e Senha";
            }
		}
		catch(Exception e){
			System.out.print("ERRO Controller => "+e.getMessage() + " - " + e);
			return "Erro catch aut";
		}
		
	}
}
