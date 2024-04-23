package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;
import entidades.Login;

public class LoginDAO {
	
	public void cadastrarUsuario(Login usuario) {
		String sql ="INSERT INTO login(Usuario,Senha)VALUES(?,?) ";
		
		PreparedStatement ps =null;
		
		try {
			ps=Conexao.getConexao().prepareStatement(sql);
			
			ps.setString(1, usuario.getUsuario());
			ps.setString(2, usuario.getSenha());
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
