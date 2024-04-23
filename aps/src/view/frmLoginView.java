package view;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.LoginDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import entidades.Login;

public class frmLoginView extends JFrame {

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
					frmLoginView frame = new frmLoginView();
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
	public frmLoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelNome = new JLabel("Nome de Usuario");
		labelNome.setBounds(164, 11, 86, 14);
		contentPane.add(labelNome);
		
		textNomeUsuario = new JTextField();
		textNomeUsuario.setBounds(164, 54, 86, 20);
		contentPane.add(textNomeUsuario);
		textNomeUsuario.setColumns(10);
		
		JLabel labelSenha = new JLabel("Senha");
		labelSenha.setBounds(189, 120, 46, 14);
		contentPane.add(labelSenha);
		
		textSenhaUsuario = new JTextField();
		textSenhaUsuario.setBounds(164, 168, 86, 20);
		contentPane.add(textSenhaUsuario);
		textSenhaUsuario.setColumns(10);
		
		JButton btnLogar = new JButton("Logar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nomeUsuario,senhaUsuario;
					
					//definir variavel com os valores dos campos de textos na interface
					nomeUsuario=textNomeUsuario.getText();
					senhaUsuario=textSenhaUsuario.getText();
					
					//instanciar obj de Login e definir Usuario e Senha com as variaveis criadas anteriormente
					Login objLogin= new Login(); 
					objLogin.setUsuario(nomeUsuario);
					objLogin.setSenha(senhaUsuario);
					
					//instanciar classe LoginDAO,e trás o resultado para a variavel rloginDAO
					LoginDAO objlogindao =new LoginDAO();
					ResultSet rloginDAO=objlogindao.autenticacaoUsuario(objLogin);//se tiver um resultado ele vai trazer para a variavel
					
					if(rloginDAO.next()) {
					//chamar tela que eu quero abrir
					}else {
						//enviar mensagem dizendo incorreto
						JOptionPane.showInternalMessageDialog(null,"Usuario ou senha invalido");
					}
					
					
				} catch (SQLException erro) {
					JOptionPane.showInternalMessageDialog(null,"frmLoginView"+erro);
					
				}
				
				
				
				
			}
		});
		btnLogar.setBounds(164, 213, 89, 23);
		contentPane.add(btnLogar);
	}
}
