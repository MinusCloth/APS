package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import conexao.Conexao;
import entidades.Chamados;

public class ChamadosDAO {
	Connection conn;
	PreparedStatement ps;
	public void cadastrarChamado(Chamados objChamados) {
		
		//conectar DB
		new Conexao();
		conn=Conexao.getConexao();
		
		//Comando SQL
		String sql="INSERT INTO chamados(descricao,estado)VALUES(?,?)";
		
		try {
			//Preparar comando 	SQL
			ps=conn.prepareStatement(sql);
			ps.setString(1,objChamados.getDescricao());
			ps.setString(2,objChamados.getStatus());
			
			//Executar comando SQL
			ps.execute();
			ps.close();
			
		} catch (Exception erro) {
			JOptionPane.showInternalMessageDialog(null,"ChamadosDAO"+ erro);
			
		}
		
		
		
	}

}
