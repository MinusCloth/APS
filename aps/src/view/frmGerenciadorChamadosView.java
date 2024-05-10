package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import DAO.ChamadosDAO;
import DAO.LoginDAO;
import DAO.PessoaDAO;
import entidades.Chamados;
import entidades.Login;

import javax.swing.ListSelectionModel;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;



public class frmGerenciadorChamadosView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textDescricao;
	private static JTable table;
	DefaultTableModel model;
	private JButton btnCadastrarChamado;
	private JButton btnAtualizar;
	private JButton btnExcluir;
	private JLabel labelSeusChamados;
	private JButton btnVoltar;
	private JButton btnLimparDescricao;
	private JTextField textCodigo;
	private JButton btnAlterar;
	private static Login login;
	private static int id_pessoa;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmGerenciadorChamadosView frame = new frmGerenciadorChamadosView(login);
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

	
	public frmGerenciadorChamadosView(Login login) {
		super();
		this.login=login;
		//loginDAO pegar id_login 
		int id_login=login.getId_login();
		
		//instanciar pessoaDAO
		PessoaDAO objPessoaDAO=new PessoaDAO();
		//obter id_pessoa atraves do id login
		id_pessoa=objPessoaDAO.obterIDPessoaLogin(id_login);
		
		
		
		setBackground(new Color(30, 144, 255));
		setForeground(new Color(30, 144, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 680);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(0, 0, 670, 641);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel labeldescricao = new JLabel("Descricao:");
		labeldescricao.setBounds(198, 452, 88, 24);
		panel.add(labeldescricao);
		
		textDescricao = new JTextField();
		textDescricao.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
			}
		});
		textDescricao.setBounds(198, 499, 446, 113);
		panel.add(textDescricao);
		textDescricao.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(198, 37, 443, 382);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		model= new DefaultTableModel();
		Object []column= {"id","estado","dt_abertura","descricao"};
		Object [] row=new Object[0];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		//largura da coluna descricao
		table.getColumnModel().getColumn(3).setPreferredWidth(300);
		pesquisar();
		btnCadastrarChamado = new JButton("Cadastrar");
		btnCadastrarChamado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String descricao = textDescricao.getText().trim();
		        if (!descricao.isEmpty()) {
					//verificacao se tem descricao
					cadastrarChamado();
					pesquisar();
					limparCampo();
				}else {JOptionPane.showInternalMessageDialog(null,"Preencha a descrição");}
			}
		});
		btnCadastrarChamado.setBounds(25, 37, 150, 53);
		panel.add(btnCadastrarChamado);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisar();
			}
		});
		btnAtualizar.setBounds(25, 101, 150, 53);
		panel.add(btnAtualizar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carregarCampos();
				excluirChamado();
				pesquisar();
				limparCampo();
			}
		});
		btnExcluir.setBounds(25, 229, 150, 53);
		panel.add(btnExcluir);
		
		labelSeusChamados = new JLabel("Seus Chamados");
		labelSeusChamados.setBounds(337, 11, 199, 14);
		panel.add(labelSeusChamados);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				voltar();
			}
		});
		btnVoltar.setBounds(25, 366, 150, 53);
		panel.add(btnVoltar);
		
		JButton btnCarregarDescricao = new JButton("Carregar Descricao");
		btnCarregarDescricao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carregarCampos();
			}
		});
		btnCarregarDescricao.setBounds(25, 500, 150, 47);
		panel.add(btnCarregarDescricao);
		
		btnLimparDescricao = new JButton("Limpar");
		btnLimparDescricao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampo();
			}
		});
		btnLimparDescricao.setBounds(25, 565, 150, 47);
		panel.add(btnLimparDescricao);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(558, 454, 86, 20);
		panel.add(textCodigo);
		textCodigo.setColumns(10);
		//desabilitar a edicao
		textCodigo.setEditable(false);
		
		JLabel labelCodigo = new JLabel("Codigo:");
		labelCodigo.setBounds(502, 457, 46, 14);
		panel.add(labelCodigo);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//carregarCampos();
				atualizarChamado();
				carregarCampos();
				pesquisar();
				limparCampo();
				
				//pesquisar();
			}
		});
		btnAlterar.setBounds(25, 165, 150, 53);
		panel.add(btnAlterar);
		
		
		
		
		
		
	}
	
	private void cadastrarChamado() {
		//definir variaveis
		String descricao;
		
		//obter conteudo
		descricao=textDescricao.getText();
		
		//setar
		Chamados objChamados=new Chamados(id_pessoa,descricao);
		
		//levar para DAO
		ChamadosDAO objChamadosDAO=new ChamadosDAO();
		objChamadosDAO.cadastrarChamado(objChamados);
		
		//mensagem na tela
		JOptionPane.showInternalMessageDialog(null,"Chamado cadastrado com sucesso!");
		
		
		
		
	}
	
	private void voltar() {
		frmMenuView objfrmMenuView=new frmMenuView(login);
		objfrmMenuView.setVisible(true);
		dispose();
	}
	
	private static void pesquisar() {
		
		ChamadosDAO objChamadosDAO=new ChamadosDAO();
		
		
		try {//definir a informacao que vai aparecer nas linhas
			DefaultTableModel model=(DefaultTableModel) table.getModel();
			model.setRowCount(0);
			
			ArrayList<Chamados> lista=objChamadosDAO.pesquisarChamado(id_pessoa);
			
			//adiciona linhas com essas informações
			for(int num=0;num<lista.size();num++) {
				model.addRow(new Object[] {
						lista.get(num).getId_chamados(),//tirar depois
						lista.get(num).getStatus(),
						lista.get(num).getDt_abertura(),
						lista.get(num).getDescricao(),
						//lista.get(num).getId_pessoa()
						
						});
			}
			
		} catch (Exception erro) {
			JOptionPane.showInternalMessageDialog(null,"PesquisarView"+ erro);
		}
		
	}
	
	private void carregarCampos() {
		//saber qual linha esta selecionada
		int setar=table.getSelectedRow();
		
		//pegar o textfield selecionar a tabela,pegar valor da tabela,colocar a linha que pegamos anteriormente
		
		textDescricao.setText(table.getModel().getValueAt(setar,3).toString());
		textCodigo.setText(table.getModel().getValueAt(setar, 0).toString());
		
	}
	
	private void limparCampo() {
		textDescricao.setText("");
		textCodigo.setText("");
		textDescricao.requestFocus();
	}
	
	private void atualizarChamado() {
		int id_chamados;
		String descricao;
		id_chamados=Integer.parseInt(textCodigo.getText());		
		descricao=textDescricao.getText();
		
		//instanciar DTO
		Chamados objChamados=new Chamados();
		// objChamados.setId_pessoa(id_chamados); // talvez excluir esse
		objChamados.setId_chamados(id_chamados);
		objChamados.setDescricao(descricao);
		
		
		//instanciar DAO
		ChamadosDAO objChamadosDAO=new ChamadosDAO();
		objChamadosDAO.atualizarChamado(objChamados);
		
		JOptionPane.showInternalMessageDialog(null,"Alterado com sucesso!");
	}
	
	
	private void excluirChamado() {
		int id_chamado;
		//pegando id no campo de texto codigo e convertendo para int
		id_chamado=Integer.parseInt(textCodigo.getText());
		
		
		//instanciar DTO
		Chamados objChamados=new Chamados();
		objChamados.setId_chamados(id_chamado);
		
		//instanciar DAO
		ChamadosDAO objChamadosDAO=new ChamadosDAO();
		objChamadosDAO.excluirChamado(objChamados);
		
	}
	
	
	
	
}
