package view;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.ChamadosDAO;
import DAO.PatrimonioDAO;
import entidades.Chamados;
import entidades.Login;
import entidades.Patrimonio;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;

public class frmGerenciadorPatrimonioView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textSn;
	private JTextField textPn;
	DefaultTableModel model;
	private static JTable table;
	private static Login login;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmGerenciadorPatrimonioView frame = new frmGerenciadorPatrimonioView(login);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmGerenciadorPatrimonioView(Login login) {
		super();
		this.login=login;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 603);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrarChamado = new JButton("Cadastrar");
		btnCadastrarChamado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textNome.getText().trim();
				String sn = textSn.getText().trim();
				String pn = textPn.getText().trim();
				if(!nome.isEmpty() && !pn.isEmpty() && !sn.isEmpty()) {
					
				
				cadastrar();
				pesquisar();
				limparCampos();
				
			}else {JOptionPane.showInternalMessageDialog(null,"Preencha a descrição");}
				
			}
		});
		btnCadastrarChamado.setBounds(33, 47, 106, 44);
		contentPane.add(btnCadastrarChamado);
		
		JLabel labelNome = new JLabel("Nome do Patrimonio");
		labelNome.setBounds(190, 11, 267, 14);
		contentPane.add(labelNome);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					atualizarPatrimonio();
					carregarCampos();
					pesquisar();
					limparCampos();
			}
		});
		btnAtualizar.setBounds(33, 127, 106, 44);
		contentPane.add(btnAtualizar);
		
		JButton btnCarregar = new JButton("Carregar");
		btnCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carregarCampos();
			}
		});
		btnCarregar.setBounds(33, 207, 106, 44);
		contentPane.add(btnCarregar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carregarCampos();
				excluirCampos();
				pesquisar();
				limparCampos();
			}
		});
		btnExcluir.setBounds(33, 294, 106, 44);
		contentPane.add(btnExcluir);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				voltar();
			}
		});
		btnVoltar.setBounds(33, 457, 106, 44);
		contentPane.add(btnVoltar);
		
		textNome = new JTextField();
		textNome.setBounds(190, 48, 360, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel labelSn = new JLabel("Serial Number");
		labelSn.setBounds(190, 79, 112, 14);
		contentPane.add(labelSn);
		
		textSn = new JTextField();
		textSn.setBounds(190, 103, 168, 20);
		contentPane.add(textSn);
		textSn.setColumns(10);
		
		JLabel labelPn = new JLabel("Part Number");
		labelPn.setBounds(382, 77, 97, 14);
		contentPane.add(labelPn);
		
		textPn = new JTextField();
		textPn.setBounds(382, 103, 168, 20);
		contentPane.add(textPn);
		textPn.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(200, 186, 350, 328);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		model= new DefaultTableModel();
		Object []column= {"id","nome","PN","SN"};
		Object [] row=new Object[0];
		table.setModel(model);
		
		JLabel labelImagem = new JLabel("");
		//labelImagem.setIcon(new ImageIcon(frmGerenciadorPatrimonioView.class.getResource("/imagens/Destaque-Guia-Help-Desk.png")));
		labelImagem.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Destaque-Guia-Help-Desk.png")).getImage().getScaledInstance(586,564,Image.SCALE_SMOOTH)));
		labelImagem.setBounds(0, 0, 586, 564);
		contentPane.add(labelImagem);
		model.setColumnIdentifiers(column);
		table.getColumnModel().getColumn(1).setPreferredWidth(300);
		pesquisar();
	}
	
	private void cadastrar() {
		//criar variaveis
		String nome,pn,sn;
		
		//pegar informações do usuario
		nome=textNome.getText();
		pn=textPn.getText();
		sn=textSn.getText();
		
		//settar
		Patrimonio objPatrimonio=new Patrimonio();
		objPatrimonio.setNome_Patrimonio(nome);
		objPatrimonio.setPn(pn);
		objPatrimonio.setSn(sn);
		
		//instanciar a DAO
		PatrimonioDAO objPatrimonioDAO=new PatrimonioDAO();
		objPatrimonioDAO.cadastrarPatrimonio(objPatrimonio);
		
		JOptionPane.showInternalMessageDialog(null,"Patrimonio cadastrado com sucesso!");
		
	}
	
	private void voltar() {
		frmMenuView objfrmMenuView=new frmMenuView(login);
		objfrmMenuView.setVisible(true);
		dispose();
	}
	
	
	private static void pesquisar() {
		
		PatrimonioDAO objPatrimonioDAO=new PatrimonioDAO();
		
		try {//definir a informacao que vai aparecer nas linhas
			DefaultTableModel model=(DefaultTableModel) table.getModel();
			model.setRowCount(0);
			
			ArrayList<Patrimonio> lista=objPatrimonioDAO.pesquisarPatrimonio();
			
			//adiciona linhas com essas informações
			for(int num=0;num<lista.size();num++) {
				model.addRow(new Object[] {
						lista.get(num).getId_patrimonio(),//tirar depois
						lista.get(num).getNome_Patrimonio(),
						lista.get(num).getPn(),
						lista.get(num).getSn(),
						//lista.get(num).getId_pessoa()
						
						});
			}
			
		} catch (Exception erro) {
			JOptionPane.showInternalMessageDialog(null,"PesquisarView"+ erro);
		}
		
	}
	
	private void atualizarPatrimonio() {
		int setar=table.getSelectedRow();
		String id_patrimonioString=table.getModel().getValueAt(setar,0).toString();
		int id_patrimonio=Integer.parseInt(id_patrimonioString);
		String nome,pn,sn;
		
		nome=textNome.getText();
		pn=textPn.getText();
		sn=textSn.getText();
		
		
		//instanciar DTO
		Patrimonio objPatrimonio=new Patrimonio();
		// objChamados.setId_pessoa(id_chamados); // talvez excluir esse
		objPatrimonio.setId_patrimonio(id_patrimonio);
		objPatrimonio.setNome_Patrimonio(nome);
		objPatrimonio.setPn(pn);
		objPatrimonio.setSn(sn);
		
		
		
		//instanciar DAO
		PatrimonioDAO objPatrimonioDAO =new PatrimonioDAO();
		objPatrimonioDAO.atualizarPatrimonio(objPatrimonio);
		
		
		JOptionPane.showInternalMessageDialog(null,"Alterado com sucesso!");
	}
	
	
	private void carregarCampos() {
		//saber qual linha esta selecionada
		int setar=table.getSelectedRow();
		
		//pegar o textfield selecionar a tabela,pegar valor da tabela,colocar a linha que pegamos anteriormente
		
		textNome.setText(table.getModel().getValueAt(setar,1).toString());
		textPn.setText(table.getModel().getValueAt(setar, 2).toString());
		textSn.setText(table.getModel().getValueAt(setar, 3).toString());
	}
	
	
	private void excluirCampos() {
		int setar=table.getSelectedRow();
		String id_patrimonioString=table.getModel().getValueAt(setar,0).toString();
		int id_patrimonio=Integer.parseInt(id_patrimonioString);
		
		Patrimonio objPatrimonio =new Patrimonio();
		objPatrimonio.setId_patrimonio(id_patrimonio);
		
		PatrimonioDAO objPatrimonioDAO=new PatrimonioDAO();
		objPatrimonioDAO.excluirChamado(objPatrimonio);
		
		
	}
	
	private void limparCampos() {
		textNome.setText("");
		textPn.setText("");
		textSn.setText("");
		textSn.requestFocus();
	}
	
	
	
		
		
		
		
       
}

