package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import conexao.Conexao;
import entidades.Patrimonio;

public class PatrimonioDAO {
	Connection conn;
	PreparedStatement ps;
	public void cadastrarPatrimonio(Patrimonio objPatrimonio) {
		//preparar comando SQL
		String sql="INSERT INTO patrimonio(conta_corrente,conta_poupanca,outros_investimentos) VALUES(?,?,?)";
		
		//conectar DB
		new Conexao();
		conn=Conexao.getConexao();

		
		try {
			//preparar valores para  o sql
			ps=conn.prepareStatement(sql);
			ps.setDouble(1,objPatrimonio.getContaCorrente());
			ps.setDouble(2,objPatrimonio.getContaPoupanca());
			ps.setDouble(3,objPatrimonio.getOutrosInvestimentos());
			
			//Executar comando SQL
			ps.execute();
			ps.close();
			
		} catch (Exception erro) {
			JOptionPane.showInternalMessageDialog(null, "PatrimonioDAO"+erro);
		
		}
		
		
		
		
	}

}
