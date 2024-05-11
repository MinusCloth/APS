package viewCadastrar;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.LoginDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import entidades.Login;
import view.frmInicialView;
import javax.swing.ImageIcon;



public class frmCadastrarLoginView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNomeUsuario;
	private JTextField textSenhaUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmCadastrarLoginView frame = new frmCadastrarLoginView();
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
	public frmCadastrarLoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelNome = new JLabel("Nome de Usuario");
		labelNome.setBounds(148, 11, 154, 14);
		contentPane.add(labelNome);
		
		textNomeUsuario = new JTextField();
		textNomeUsuario.setBounds(143, 54, 125, 20);
		contentPane.add(textNomeUsuario);
		textNomeUsuario.setColumns(10);
		
		JLabel labelSenha = new JLabel("Senha");
		labelSenha.setBounds(183, 120, 46, 14);
		contentPane.add(labelSenha);
		
		JButton btnLogar = new JButton("Cadastrar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				cadastrar();
			}
		});
		btnLogar.setBounds(216, 214, 125, 23);
		contentPane.add(btnLogar);
		
		textSenhaUsuario = new JTextField();
		textSenhaUsuario.setBounds(143, 161, 125, 20);
		contentPane.add(textSenhaUsuario);
		textSenhaUsuario.setColumns(10);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				voltar();
			}
		});
		btnVoltar.setBounds(58, 214, 125, 23);
		contentPane.add(btnVoltar);
		
		JLabel labelImagem = new JLabel("");
		//labelImagem.setIcon(new ImageIcon(frmCadastrarLoginView.class.getResource("/imagens/imagem1.jpg")));
		labelImagem.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/imagem1.jpg")).getImage().getScaledInstance(434,261,Image.SCALE_SMOOTH)));
		labelImagem.setBounds(0, 0, 434, 261);
		contentPane.add(labelImagem);
	}
	private void cadastrar() {
		//definir variaveis para receber valor
		String senhaUsuario,nomeUsuario;
		
		//pegar informacao que o usuario inseriu
		nomeUsuario=textNomeUsuario.getText();
		senhaUsuario=textSenhaUsuario.getText();
		//verificar se os campos estao preenchidos
		if(nomeUsuario.equals("") || senhaUsuario.equals("")) {
			JOptionPane.showInternalMessageDialog(null, "Preencha todos os campos!");
		}else {
		
		//instanciar Login e setar as informaçoes obtidas
		Login objLogin=new Login();
		objLogin.setUsuario(nomeUsuario);
		objLogin.setSenha(senhaUsuario);
		Login.adicionarLogin(objLogin);
		
		
		//levar para a LoginDao
		LoginDAO objLoginDAO=new LoginDAO();
		if(objLoginDAO.loginExiste(objLogin)) {
			 JOptionPane.showMessageDialog(null, "Essa pessoa já está cadastrada.");
		}else {
		
		objLoginDAO.cadastrarUsuario(objLogin);
		

		
		
		JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso!");
		
		
            	frmCadastrarPessoaView objfrmCadastrarPessoaView=new frmCadastrarPessoaView(objLogin);
            	objfrmCadastrarPessoaView.setVisible(true);
            	dispose();

            }}
	
		}
	
	public void voltar() {
		frmInicialView objfrmInicialView=new frmInicialView();
		
		objfrmInicialView.setVisible(true);
		dispose();
		
	}
}
