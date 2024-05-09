package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import conexao.Conexao;
import entidades.Chamados;

public class ChamadosDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	ArrayList<Chamados>lista=new ArrayList<>();
	
	public void cadastrarChamado(Chamados objChamados) {
		
		//conectar DB
		new Conexao();
		conn=Conexao.getConexao();
		
		//Comando SQL
		String sql="INSERT INTO chamados(id_pessoa,descricao,estado)VALUES(?,?,?)";
		
		try {
			//Preparar comando 	SQL
			ps=conn.prepareStatement(sql);
			ps.setInt(1,objChamados.getId_pessoa());
			ps.setString(2,objChamados.getDescricao());
			ps.setString(3,objChamados.getStatus());
			
			//Executar comando SQL
			ps.execute();
			ps.close();
			
		} catch (Exception erro) {
			JOptionPane.showInternalMessageDialog(null,"ChamadosDAO Cadastrar"+ erro);
			
		}
		
		
		
	}
	
	public ArrayList<Chamados> pesquisarChamado(int id_pessoa){
		new Conexao();
		conn=Conexao.getConexao();
		
		String sql="SELECT id,descricao,dt_abertura,estado FROM chamados WHERE id_pessoa=?";
		
		
		try {
			
			ps=conn.prepareStatement(sql);
			ps.setInt(1,id_pessoa);
			rs=ps.executeQuery();			
			
			while(rs.next()) {
				Chamados objChamados=new Chamados();
				//pegando id da tabela chamada
				objChamados.setId_chamados(rs.getInt("id"));
				objChamados.setDescricao(rs.getString("descricao"));
				objChamados.setDt_abertura(rs.getString("dt_abertura"));
				objChamados.setStatus(rs.getString("estado"));
				
				lista.add(objChamados);
			}
			
		} catch (Exception erro) {
			JOptionPane.showInternalMessageDialog(null,"ChamadosDAO Pesquisar"+ erro);
		}
		
		return lista;
		
	}
	
	
	public void atualizarChamado(Chamados objChamados) {
		new Conexao();
		conn=Conexao.getConexao();
		
		String sql="UPDATE chamados set descricao=?,estado=? WHERE id=?";    //UPDATE chamados set descricao=?,estado=? WHERE id_chamados=?"
		
		try {
			//Preparar comando 	SQL
			ps=conn.prepareStatement(sql);
			ps.setString(1,objChamados.getDescricao());
			ps.setString(2,objChamados.getStatus());
			ps.setInt(3,objChamados.getId_chamados());
			
			//Executar comando SQL
			ps.execute();
			ps.close();
			
		} catch (Exception erro) {
			JOptionPane.showInternalMessageDialog(null,"ChamadosDAO Atualizar"+ erro);
			
		}
		
		
		
		
	}
	
	
	public void excluirChamado(Chamados objchamados) {
		new Conexao();
		conn=Conexao.getConexao();
		
		String sql="delete from chamados where id=?";
		
		try {
			
			ps=conn.prepareStatement(sql);
			ps.setInt(1,objchamados.getId_chamados());
			
			ps.execute();
			ps.close();
			
		} catch (Exception erro) {
			JOptionPane.showInternalMessageDialog(null,"ChamadasDAO excluri"+ erro);
		}
		
		
		
		
	}
	

}
