package viewCadastrar;

import java.awt.EventQueue;
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
		btnLogar.setBounds(143, 213, 125, 23);
		contentPane.add(btnLogar);
		
		textSenhaUsuario = new JTextField();
		textSenhaUsuario.setBounds(143, 161, 125, 20);
		contentPane.add(textSenhaUsuario);
		textSenhaUsuario.setColumns(10);
	}
	private void cadastrar() {
		//definir variaveis para receber valor
		String senhaUsuario,nomeUsuario;
		
		//pegar informacao que o usuario inseriu
		nomeUsuario=textNomeUsuario.getText();
		senhaUsuario=textSenhaUsuario.getText();
		
		//instanciar Login e setar as informaçoes obtidas
		Login objLogin=new Login();
		objLogin.setUsuario(nomeUsuario);
		objLogin.setSenha(senhaUsuario);
		
		
		//levar para a LoginDao
		LoginDAO objLoginDAO=new LoginDAO();
		if(objLoginDAO.loginExiste(objLogin)) {
			 JOptionPane.showMessageDialog(null, "Essa pessoa já está cadastrada.");
		}else {
		
		objLoginDAO.cadastrarUsuario(objLogin);
		JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso!");
		
		Timer timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	frmCadastrarPessoaView objfrmCadastrarPessoaView=new frmCadastrarPessoaView();
            	objfrmCadastrarPessoaView.setVisible(true);
            	dispose();

            }
        });
        timer.setRepeats(false); // Para garantir que o timer só execute uma vez
        timer.start();}
	
		}
	
	
}
