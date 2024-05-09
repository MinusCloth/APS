package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import conexao.Conexao;
import entidades.Patrimonio;

public class PatrimonioDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	public void cadastrarPatrimonio(Patrimonio objPatrimonio) {
		//preparar comando SQL
		String sql="INSERT INTO patrimonio(id_pessoa,conta_corrente,conta_poupanca,outros_investimentos) VALUES(?,?,?,?)";
		
		//conectar DB
		new Conexao();
		conn=Conexao.getConexao();

		
		try {
			//preparar valores para  o sql
			ps=conn.prepareStatement(sql);
			
			ps.setInt(1,objPatrimonio.getId_pessoa());
			ps.setDouble(2,objPatrimonio.getContaCorrente());
			ps.setDouble(3,objPatrimonio.getContaPoupanca());
			ps.setDouble(4,objPatrimonio.getOutrosInvestimentos());
			
			//Executar comando SQL
			ps.execute();
			ps.close();
			
		} catch (Exception erro) {
			JOptionPane.showInternalMessageDialog(null, "PatrimonioDAO"+erro);
		
		}
		
		
		
		
	}
	
	
	public Patrimonio pesquisarPatrimonio(int id_pessoa) {
		
		new Conexao();
		conn=Conexao.getConexao();
		Patrimonio patrimonio = null;
		String sql="SELECT conta_corrente,conta_poupanca,outros_investimentos  FROM patrimonio WHERE id_pessoa=?";
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1,id_pessoa);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				double contaCorrente =rs.getDouble("conta_corrente");
				double contaPoupanca = rs.getDouble("conta_poupanca");
				double outrosInvestimentos =rs.getDouble("outros_investimentos");
				patrimonio = new Patrimonio(contaCorrente, contaPoupanca, outrosInvestimentos);
			}
			
		} catch (Exception erro) {
			
		}
		
		return patrimonio;
		
	}
	

}
