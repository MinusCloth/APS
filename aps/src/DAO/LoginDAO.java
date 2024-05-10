package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	    // Preparar comando SQL
	    String sql = "INSERT INTO login(Usuario, Senha) VALUES(?, ?)";
	    
	    try {
	        // Conectar DB
	        Connection conn = Conexao.getConexao();
	        
	        // Preparar comando SQL
	        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	        ps.setString(1, objUsuario.getUsuario());
	        ps.setString(2, objUsuario.getSenha());
	        
	        //passar para a lista dos logins
	        
	        
	        
	        // Executar comando SQL
	        ps.execute();
	        
	        // Obter o ID gerado automaticamente
	        ResultSet rs = ps.getGeneratedKeys();
	        if (rs.next()) {
	            int idGerado = rs.getInt(1);
	            objUsuario.setId_login(idGerado);
	        }
	        
	       
	        
	        // Fechar recursos
	        rs.close();
	        ps.close();
	   
	    } catch (Exception erro) {
	        JOptionPane.showMessageDialog(null, "LoginDAO: " + erro);
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
	
	
	public void obterIDLogin(Login login) {
	    int id = -1; // Valor padrão, caso não haja nenhum ID inserido
	    
	    new Conexao();
		conn =Conexao.getConexao();
	    try {
	        // Consulta para obter o último ID inserido
	        String sql = "SELECT id_login FROM login WHERE Usuario = ? AND Senha = ?";
	        	
	        
	        ps = conn.prepareStatement(sql);
	        ps.setString(1,login.getUsuario());
	        ps.setString(2,login.getSenha());
	        
	        
	        
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            id = rs.getInt("id_login");
	            login.setId_login(id);
	        }
	        
	        // Fecha o ResultSet
	        rs.close();
	    } catch (Exception erro) {
	    	JOptionPane.showMessageDialog(null, "LoginDAO obterUltimoIDInserido " + erro);
		}
	        
	    

	    
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
