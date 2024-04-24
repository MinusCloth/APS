package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.PessoaDAO;
import entidades.Pessoa;
import entidades.Telefones;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class frmPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNomePessoa;
	private JTextField textEmailPessoa;
	private JTextField textCidadePessoa;
	private JTextField textRuaPessoa;
	private JTextField textTelefonePessoa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmPrincipal frame = new frmPrincipal();
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
	public frmPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 594);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastrar Pessoa");
		lblNewLabel.setBounds(212, 11, 174, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lanbelNomePessoa = new JLabel("Nome Completo");
		lanbelNomePessoa.setBounds(28, 53, 148, 14);
		contentPane.add(lanbelNomePessoa);
		
		textNomePessoa = new JTextField();
		textNomePessoa.setBounds(28, 80, 214, 20);
		contentPane.add(textNomePessoa);
		textNomePessoa.setColumns(10);
		
		JLabel lanbelEmailPessoa = new JLabel("Email");
		lanbelEmailPessoa.setBounds(28, 123, 46, 14);
		contentPane.add(lanbelEmailPessoa);
		
		textEmailPessoa = new JTextField();
		textEmailPessoa.setBounds(28, 159, 214, 20);
		contentPane.add(textEmailPessoa);
		textEmailPessoa.setColumns(10);
		
		JLabel lanbelCidadePessoa = new JLabel("Cidade");
		lanbelCidadePessoa.setBounds(28, 215, 46, 14);
		contentPane.add(lanbelCidadePessoa);
		
		textCidadePessoa = new JTextField();
		textCidadePessoa.setBounds(28, 255, 214, 20);
		contentPane.add(textCidadePessoa);
		textCidadePessoa.setColumns(10);
		
		JLabel lanbelRuaPessoa = new JLabel("Rua");
		lanbelRuaPessoa.setBounds(28, 309, 46, 14);
		contentPane.add(lanbelRuaPessoa);
		
		textRuaPessoa = new JTextField();
		textRuaPessoa.setBounds(28, 351, 214, 20);
		contentPane.add(textRuaPessoa);
		textRuaPessoa.setColumns(10);
		
		JLabel lanbelTelefonePessoa = new JLabel("Telefone");
		lanbelTelefonePessoa.setBounds(28, 409, 46, 14);
		contentPane.add(lanbelTelefonePessoa);
		
		textTelefonePessoa = new JTextField();
		textTelefonePessoa.setBounds(28, 451, 214, 20);
		contentPane.add(textTelefonePessoa);
		textTelefonePessoa.setColumns(10);
		
		JButton btnCadastrarPessoa = new JButton("Cadastrar");
		btnCadastrarPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarPessoa();
			}
		});
		btnCadastrarPessoa.setBounds(224, 521, 89, 23);
		contentPane.add(btnCadastrarPessoa);
	}
	private void cadastrarPessoa() {
		
		
		try {//criar variaveis
			String nomePessoa,emailPessoa,cidadePessoa,ruaPessoa,telefonePessoa;
			
			//salvar parametros que o usuario escreveu
			nomePessoa=textNomePessoa.getText();
			emailPessoa=textEmailPessoa.getText();
			cidadePessoa=textCidadePessoa.getText();
			ruaPessoa=textRuaPessoa.getText();
			telefonePessoa=textTelefonePessoa.getText();
			
			//instanciar obleto da entidade 
			Pessoa objPessoa = new Pessoa(nomePessoa,emailPessoa,cidadePessoa,ruaPessoa);
			Telefones objTelefone=new Telefones(telefonePessoa);
			
			PessoaDAO objPessoaDAO =new PessoaDAO();
			ResultSet rPessoaDAO=objPessoaDAO.autenticacaoPessoa(objPessoa);
			
			if(rPessoaDAO.next()==false) {
				//Pessoa ja esta cadastrada,     //se nao{ CADASTRADO COM SUCESSO}
			}
			else {}
			
		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null,"fmrPessoa"+ e);
			
		}
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
