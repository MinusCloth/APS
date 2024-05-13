package view;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import viewCadastrar.frmCadastrarLoginView;
import viewEntrar.frmEntrarLoginView;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class frmInicialView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmInicialView frame = new frmInicialView();
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
	public frmInicialView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelBemVindo = new JLabel("Bem-Vindo");
		labelBemVindo.setBounds(155, 11, 224, 22);
		contentPane.add(labelBemVindo);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//BtnCadastrar
				//levar para a tela de cadastrar login
				//abrir tela de login 
				//instanciar frmLogin
				frmCadastrarLoginView objfrmCadastrarLoginView =new frmCadastrarLoginView();
				objfrmCadastrarLoginView.setVisible(true);
				dispose();
				
				
			}
		});
		btnCadastrar.setBounds(127, 84, 123, 39);
		contentPane.add(btnCadastrar);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//abrir tela de login 
				//instanciar frmLogin
				frmEntrarLoginView objfrmLoginView =new frmEntrarLoginView();
				objfrmLoginView.setVisible(true);
				dispose();
			}
		});
		btnEntrar.setBounds(127, 164, 123, 39);
		contentPane.add(btnEntrar);
		
		JLabel labelImagem = new JLabel("New label");
	//	labelImagem.setIcon(new ImageIcon(frmInicialView.class.getResource("/imagens/imagem1.jpg")));
		labelImagem.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Destaque-Guia-Help-Desk.png")).getImage().getScaledInstance(434,261,Image.SCALE_SMOOTH)));
		labelImagem.setBounds(0, 0, 434, 261);
		contentPane.add(labelImagem);
	}
}
