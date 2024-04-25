package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import conexao.Conexao;
import entidades.Telefones;

public class TelefoneDAO {
	
	Connection conn;
	PreparedStatement ps;
	
	
	public void cadastrarTelefone(Telefones objtelefone) {
		//comando SQL
		String sql="insert into telefones(telefone1)values(?)";
		
		//conectar com db
		new Conexao();
		conn =Conexao.getConexao();
		
		//preparar comando SQL	
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1,objtelefone.getTelefone1());
			
			ps.execute();
			ps.close();
			
			
		} catch (SQLException erro) {
			JOptionPane.showInternalMessageDialog(null, "TelefoneDAO"+erro);
			
		}
		
		
		
		
	}

}
