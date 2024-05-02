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
		btnAbrirChamado.setBounds(65, 91, 269, 23);
		contentPane.add(btnAbrirChamado);
		
		JButton btnVerChamado = new JButton("Vizualiar Chamados");
		btnVerChamado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vizualizarChamados();
			}
		});
		btnVerChamado.setBounds(65, 177, 269, 23);
		contentPane.add(btnVerChamado);
		
		JButton btnCarteira = new JButton("Vizualizar Carteira");
		btnCarteira.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vizualizarCarteira();
			}
		});
		btnCarteira.setBounds(65, 273, 269, 23);
		contentPane.add(btnCarteira);
	}
	private void abrirChamado() {
		//levar para o abrir chamado
		frmCadastrarChamado objfrmCadastrarChamado=new frmCadastrarChamado();
		objfrmCadastrarChamado.setVisible(true);
		dispose();
		
	}
	
	private void vizualizarChamados() {
		//levar para chamados
		frmVizualizarChamadosView objfrmVizualizarChamadosView=new frmVizualizarChamadosView();
		objfrmVizualizarChamadosView.setVisible(true);
		dispose();
	}
	
	private void vizualizarCarteira() {
		frmCarteiraView objfrmCarteiraView=new frmCarteiraView();
		objfrmCarteiraView.setVisible(true);
	}
	
	
}
