package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import conexao.Conexao;
import entidades.Login;

public class LoginDAO {
	
	Connection conn;
	
	public ResultSet autenticacaoUsuario(Login objusuario) {
		new Conexao();
		conn =Conexao.getConexao();//declarar variavel tipo conexao
		
		try {                     //try vai tentar trazer o resultado da query 
			String sql ="select * from login where Usuario=? and Senha=? ";
			
			//verifica se tem essa pessoa com esse login
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, objusuario.getUsuario());
			ps.setString(2, objusuario.getSenha());
			
			ResultSet rs=ps.executeQuery();
			return rs;
			
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null,"LoginDAO"+ erro);
			return null;
		}
				}
	
}
