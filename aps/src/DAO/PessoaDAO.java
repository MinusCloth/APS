package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import conexao.Conexao;
import entidades.Pessoa;

public class PessoaDAO {
	Connection conn;
	PreparedStatement ps;
	public void cadastrarPessoa(Pessoa objpessoa) {
		//INSERIR DADOS OBTIDOS PARA O BANCO DE DADOS
		String sql="INSERT INTO pessoa(nome,email,cidade,rua)VALUES(?,?,?,?)";
		//Conectar 	DB
		new Conexao();
		conn =Conexao.getConexao();
		try {
		
			
			
			//Preparar comando 	SQL
			ps=conn.prepareStatement(sql);
			ps.setString(1, objpessoa.getNome());
			ps.setString(2, objpessoa.getemail());
			ps.setString(3,objpessoa.getCidade());
			ps.setString(4, objpessoa.getRua());
		
			
			//Executar comando SQL
			ps.execute();
			ps.close();
			
			
			
		} catch (SQLException erro) {
			JOptionPane.showInternalMessageDialog(null, "PessoaDAO"+erro);
		}
		
	}
	
	public ResultSet autenticacaoPessoa(Pessoa objpessoa) {
		new Conexao();
		conn =Conexao.getConexao();
			
			try {//INSERIR DADOS OBTIDOS PARA O BANCO DE DADOS
				String sql="select * from login where nome=? and email=? and cidade=? and rua=?";
				
				//Preparar comando 	SQL
				ps=conn.prepareStatement(sql);
				ps.setString(1, objpessoa.getNome());
				ps.setString(2, objpessoa.getemail());
				ps.setString(3,objpessoa.getCidade());
				ps.setString(4, objpessoa.getRua());
				
				//Executar comando SQL
				ResultSet rs=ps.executeQuery();
				return rs;
				
				
			} catch (SQLException erro) {
				JOptionPane.showInternalMessageDialog(null, "PessoaDAO"+erro);
				return null;
			}
			
		}
	
	public boolean pessoaExiste(Pessoa objPessoa) {
		new Conexao();
		conn =Conexao.getConexao();
		
		
	    // Consulta SQL para verificar se a pessoa já existe
	    String sql = "SELECT COUNT(*) FROM pessoa WHERE nome=? AND email=? AND cidade=? AND rua=?";
	    try {
	        // Preparar comando SQL
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, objPessoa.getNome());
	        ps.setString(2, objPessoa.getemail());
	        ps.setString(3, objPessoa.getCidade());
	        ps.setString(4, objPessoa.getRua());

	        // Executar consulta SQL
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            int count = rs.getInt(1);
	            return count > 0; // Se count for maior que 0, significa que a pessoa já existe
	        }
	    } catch (SQLException erro) {
	        JOptionPane.showMessageDialog(null, "Erro ao verificar se a pessoa já existe: " + erro.getMessage());
	    }
	    return false;
	}
	
	

}
