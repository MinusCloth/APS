package view;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.LoginDAO;
import entidades.Login;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class frmMenuView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static Login login;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmMenuView frame = new frmMenuView(login);
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
	
	
	public frmMenuView(Login login) {
		super();
		this.login=login;
		LoginDAO objLoginDAO=new LoginDAO();
		objLoginDAO.obterIDLogin(login);
		 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelMenu = new JLabel("MENU");
		labelMenu.setBounds(183, 11, 75, 14);
		contentPane.add(labelMenu);
		
		JButton btnGerenciadorPatrimonio = new JButton("Gerenciar Patrimonio");
		btnGerenciadorPatrimonio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirCarteira();
			}
		});
		btnGerenciadorPatrimonio.setBounds(65, 216, 287, 57);
		contentPane.add(btnGerenciadorPatrimonio);
		
		JButton btnGerenciarChamado = new JButton("Gerenciar Chamados");
		btnGerenciarChamado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciadorChamadas();
			}
		});
		btnGerenciarChamado.setBounds(65, 87, 287, 57);
		contentPane.add(btnGerenciarChamado);
		
		JLabel labelImagem = new JLabel("");
		//labelImagem.setIcon(new ImageIcon(frmMenuView.class.getResource("/imagens/imagem1.jpg")));
		labelImagem.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Destaque-Guia-Help-Desk.png")).getImage().getScaledInstance(434,363,Image.SCALE_SMOOTH)));
		labelImagem.setBounds(0, 0, 434, 363);
		contentPane.add(labelImagem);
	}
	
	private void gerenciadorChamadas() {
		//levar para chamados
		frmGerenciadorChamadosView objfrmVizualizarChamadosView=new frmGerenciadorChamadosView(login);
		objfrmVizualizarChamadosView.setVisible(true);
		dispose();
	}
	
	private void abrirCarteira() {
		frmGerenciadorPatrimonioView objfrmGerenciadorPatrimonioView=new frmGerenciadorPatrimonioView(login);
		objfrmGerenciadorPatrimonioView.setVisible(true);
		dispose();
	}
	
	
	
}
