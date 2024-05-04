package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import viewCadastrar.frmCadastrarChamado;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmMenuView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmMenuView frame = new frmMenuView();
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
	public frmMenuView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 548);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelMenu = new JLabel("MENU");
		labelMenu.setBounds(183, 11, 75, 14);
		contentPane.add(labelMenu);
		
		JButton btnAbrirChamado = new JButton("Abrir Chamado");
		btnAbrirChamado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirChamado();
			}
		});
		btnAbrirChamado.setBounds(65, 143, 269, 23);
		contentPane.add(btnAbrirChamado);
		
		JButton btnVerChamado = new JButton("Vizualizar Carteira");
		btnVerChamado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirCarteira();
			}
		});
		btnVerChamado.setBounds(65, 229, 269, 23);
		contentPane.add(btnVerChamado);
		
		JButton btnGerenciarChamado = new JButton("Gerenciar Chamados");
		btnGerenciarChamado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciadorChamadas();
			}
		});
		btnGerenciarChamado.setBounds(65, 321, 269, 23);
		contentPane.add(btnGerenciarChamado);
	}
	private void abrirChamado() {
		//levar para o abrir chamado
		frmCadastrarChamado objfrmCadastrarChamado=new frmCadastrarChamado();
		objfrmCadastrarChamado.setVisible(true);
		dispose();
		
	}
	
	private void gerenciadorChamadas() {
		//levar para chamados
		frmGerenciadorChamadosView objfrmVizualizarChamadosView=new frmGerenciadorChamadosView();
		objfrmVizualizarChamadosView.setVisible(true);
		dispose();
	}
	
	private void abrirCarteira() {
		frmCarteiraView objfrmCarteiraView=new frmCarteiraView();
		objfrmCarteiraView.setVisible(true);
		dispose();
	}
	
	
	
}
