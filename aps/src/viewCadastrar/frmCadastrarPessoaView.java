package viewCadastrar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.PessoaDAO;
import DAO.TelefoneDAO;
import entidades.Pessoa;
import entidades.Telefones;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmCadastrarPessoaView extends JFrame {

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
					frmCadastrarPessoaView frame = new frmCadastrarPessoaView();
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
	public frmCadastrarPessoaView() {
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
		lanbelTelefonePessoa.setBounds(28, 409, 89, 14);
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
		btnCadastrarPessoa.setBounds(224, 521, 128, 23);
		contentPane.add(btnCadastrarPessoa);
	}
	private void cadastrarPessoa() {
		
		
		//criar variaveis
			String nomePessoa,emailPessoa,cidadePessoa,ruaPessoa,telefonePessoa;
			
			
			
			//salvar parametros que o usuario escreveu
			nomePessoa=textNomePessoa.getText();
			emailPessoa=textEmailPessoa.getText();
			cidadePessoa=textCidadePessoa.getText();
			ruaPessoa=textRuaPessoa.getText();
			telefonePessoa=textTelefonePessoa.getText();
			
			if(nomePessoa.equals("") || emailPessoa.equals("") || cidadePessoa.equals("") || ruaPessoa.equals("") || telefonePessoa.equals("")) {
				JOptionPane.showInternalMessageDialog(null,"Preencha todos os campos!");
			}
			else {
			//instanciar obleto da entidade 
			Pessoa objPessoa = new Pessoa(nomePessoa,emailPessoa,cidadePessoa,ruaPessoa);
			Telefones objTelefone=new Telefones(telefonePessoa);
			
			
			//instanciar pessoaDAO para mandar as informções para o DB
			PessoaDAO objPessoaDAO =new PessoaDAO();
			
			//verificar se a pessoa ja esta cadastrada
			 if (objPessoaDAO.pessoaExiste(objPessoa)) {
			        JOptionPane.showMessageDialog(null, "Essa pessoa já está cadastrada.");
			    } else {
			    	
			    	objPessoaDAO.cadastrarPessoa(objPessoa);
			    	
			    	//instanciar telefonDAO para mandar as informções para o DB
					TelefoneDAO objtelefoneDAO= new TelefoneDAO();
					objtelefoneDAO.cadastrarTelefone(objTelefone);
					JOptionPane.showMessageDialog(null, "Pessoa cadastrada com sucesso!");
					 
				                frmCadastrarPatrimonioView objfrmCadastrarPatrimonio=new frmCadastrarPatrimonioView();
				                objfrmCadastrarPatrimonio.setVisible(true);
				                dispose();
				              
				    }
			}
			    
	
	
	}

	
}
