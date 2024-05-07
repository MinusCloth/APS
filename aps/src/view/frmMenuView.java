package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



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
		setBounds(100, 100, 450, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelMenu = new JLabel("MENU");
		labelMenu.setBounds(183, 11, 75, 14);
		contentPane.add(labelMenu);
		
		JButton btnVerChamado = new JButton("Vizualizar Carteira");
		btnVerChamado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirCarteira();
			}
		});
		btnVerChamado.setBounds(65, 216, 287, 57);
		contentPane.add(btnVerChamado);
		
		JButton btnGerenciarChamado = new JButton("Gerenciar Chamados");
		btnGerenciarChamado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciadorChamadas();
			}
		});
		btnGerenciarChamado.setBounds(65, 87, 287, 57);
		contentPane.add(btnGerenciarChamado);
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
