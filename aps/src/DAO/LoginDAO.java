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
	PreparedStatement ps;
	public ResultSet autenticacaoUsuario(Login objusuario) {
		new Conexao();
		conn =Conexao.getConexao();//declarar variavel tipo conexao
		
		try {                     //try vai tentar trazer o resultado da query 
			String sql ="select * from login where Usuario=? and Senha=? ";
			
			//verifica se tem essa pessoa com esse login
			ps=conn.prepareStatement(sql);
			ps.setString(1, objusuario.getUsuario());
			ps.setString(2, objusuario.getSenha());
			
			ResultSet rs=ps.executeQuery();
			return rs;
			
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null,"LoginDAO"+ erro);
			return null;
		}
				}
	
	public void cadastrarUsuario(Login objUsuario) {
		//preparar comando SQL
		String sql="INSERT INTO login(Usuario,Senha) VALUES(?,?)";
		
		//conectar DB
		new Conexao();
		conn =Conexao.getConexao();
		
		try {
			
			//preparar comando SQL
			ps=conn.prepareStatement(sql);
			ps.setString(1, objUsuario.getUsuario());
			ps.setString(2,objUsuario.getSenha());
			
			//Executar comando SQL
			ps.execute();
			ps.close();
			
			
		} catch (Exception erro) {
			JOptionPane.showInternalMessageDialog(null, "LoginDAO"+erro);
		}
		
	}
	
	public boolean loginExiste(Login login) {
		
		new Conexao();
		conn =Conexao.getConexao();
		String sql = "SELECT COUNT(*) FROM login WHERE Usuario=? AND Senha=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,login.getUsuario());
			ps.setString(2,login.getSenha());
			
			 ResultSet rs = ps.executeQuery();
		        if (rs.next()) {
		            int count = rs.getInt(1);
		            return count > 0;
		        }
			
			
		}catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Erro ao verificar se a pessoa já existe: " + erro);
		}
		return false;
	
	
	}
	
	
}
