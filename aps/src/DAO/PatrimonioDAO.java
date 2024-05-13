package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import conexao.Conexao;
import entidades.Chamados;
import entidades.Patrimonio;

public class PatrimonioDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	ArrayList<Patrimonio>lista=new ArrayList<>();

	public void cadastrarPatrimonio(Patrimonio objPatrimonio) {
		//preparar comando SQL
		String sql="INSERT INTO patrimonio(nome_patrimonio,pn,sn) VALUES(?,?,?)";
		
		//conectar DB
		new Conexao();
		conn=Conexao.getConexao();

		
		try {
			//preparar valores para  o sql
			ps=conn.prepareStatement(sql);
			
			
			ps.setString(1,objPatrimonio.getNome_Patrimonio());
			ps.setString(2,objPatrimonio.getPn());
			ps.setString(3,objPatrimonio.getSn());
			
			//Executar comando SQL
			ps.execute();
			ps.close();
			
		} catch (Exception erro) {
			JOptionPane.showInternalMessageDialog(null, "PatrimonioDAO"+erro);
		
		}
		
		
		
		
	}
	
	
	public ArrayList<Patrimonio> pesquisarPatrimonio(){
		new Conexao();
		conn=Conexao.getConexao();
		
		String sql="SELECT id_patrimonio,nome_patrimonio,pn,sn FROM patrimonio";
		
		
		try {		
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();			
			
			while(rs.next()) {
				Patrimonio objPatrimonio=new Patrimonio();
				//pegando id da tabela chamada
				objPatrimonio.setId_patrimonio(rs.getInt("id_patrimonio"));
				objPatrimonio.setNome_Patrimonio(rs.getString("nome_patrimonio"));
				objPatrimonio.setPn(rs.getString("pn"));
				objPatrimonio.setSn(rs.getString("sn"));
				
				lista.add(objPatrimonio);
			}
			
		} catch (Exception erro) {
			JOptionPane.showInternalMessageDialog(null,"PatrimonioDAO Pesquisar"+ erro);
		}
		
		return lista;
		
	}
	
	
	public void atualizarPatrimonio(Patrimonio objPatrimonio) {
		new Conexao();
		conn=Conexao.getConexao();
		
		String sql="UPDATE patrimonio set nome_patrimonio=?,pn=?, sn=? WHERE id_patrimonio=?";    //UPDATE chamados set descricao=?,estado=? WHERE id_chamados=?"
		
		try {
			//Preparar comando 	SQL
			ps=conn.prepareStatement(sql);
			ps.setString(1,objPatrimonio.getNome_Patrimonio());
			ps.setString(2,objPatrimonio.getPn());
			ps.setString(3,objPatrimonio.getSn());
			ps.setInt(4,objPatrimonio.getId_patrimonio());
			
			//Executar comando SQL
			ps.execute();
			ps.close();
			
		} catch (Exception erro) {
			JOptionPane.showInternalMessageDialog(null,"PatrimonioDAO Atualizar"+ erro);
			
		}
	}
	
	public void excluirChamado(Patrimonio objPatrimonio) {
		new Conexao();
		conn=Conexao.getConexao();
		
		String sql="delete from patrimonio where id_patrimonio=?";
		
		try {
			
			ps=conn.prepareStatement(sql);
			ps.setInt(1,objPatrimonio.getId_patrimonio());
			
			ps.execute();
			ps.close();
			
		} catch (Exception erro) {
			JOptionPane.showInternalMessageDialog(null,"PatrimonioDAO excluri"+ erro);
		}
		
		
	}
	
	

}
