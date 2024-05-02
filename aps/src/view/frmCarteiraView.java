package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidades.Patrimonio;

import javax.swing.JLabel;

public class frmCarteiraView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmCarteiraView frame = new frmCarteiraView();
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
	public frmCarteiraView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//instanciar Patrimonio
		Patrimonio objPatrimonio=new Patrimonio();
		
		
		JLabel labelCarteira = new JLabel("Carteira");
		labelCarteira.setBounds(167, 11, 188, 14);
		contentPane.add(labelCarteira);
		
		JLabel labelCorrente = new JLabel("Conta Corrente:"+objPatrimonio.getContaCorrente());
		labelCorrente.setBounds(35, 44, 351, 36);
		contentPane.add(labelCorrente);
		
		JLabel labelContaPoupanca = new JLabel("Conta Poupanca:"+objPatrimonio.getContaPoupanca());
		labelContaPoupanca.setBounds(35, 106, 351, 36);
		contentPane.add(labelContaPoupanca);
		
		JLabel labelInvestimentos = new JLabel("Investimentos:"+objPatrimonio.getOutrosInvestimentos());
		labelInvestimentos.setBounds(35, 174, 351, 36);
		contentPane.add(labelInvestimentos);
	}
}
