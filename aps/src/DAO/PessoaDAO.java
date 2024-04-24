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
	
	public ResultSet cadastrarPessoa(Pessoa objpessoa) {

		
		try {//INSERIR DADOS OBTIDOS PARA O BANCO DE DADOS
			String sql="INSERT INTO pessoa(nome,email,cidade,rua)VALUES(?,?,?,?)";
			
			
			//Preparar comando 	SQL
			PreparedStatement ps=conn.prepareStatement(sql);
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
	
	public ResultSet autenticacaoPessoa(Pessoa objpessoa) {
		new Conexao();
		conn =Conexao.getConexao();
			
			try {//INSERIR DADOS OBTIDOS PARA O BANCO DE DADOS
				String sql="select * from login where nome=? and email=? and cidade=? and rua=?";
				
				//Preparar comando 	SQL
				PreparedStatement ps=conn.prepareStatement(sql);
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
	
	

}
