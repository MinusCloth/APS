package viewCadastrar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.PatrimonioDAO;
import entidades.Patrimonio;
import view.frmMenuView;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmCadastrarPatrimonioView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCorrente;
	private JTextField textPoupanca;
	private JTextField textInvestimentos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmCadastrarPatrimonioView frame = new frmCadastrarPatrimonioView();
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
	public frmCadastrarPatrimonioView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelCorrentePatrimonio = new JLabel("Cadastrar Conta Corrente");
		labelCorrentePatrimonio.setBounds(48, 11, 258, 14);
		contentPane.add(labelCorrentePatrimonio);
		
		textCorrente = new JTextField();
		textCorrente.setBounds(48, 53, 133, 20);
		contentPane.add(textCorrente);
		textCorrente.setColumns(10);
		
		JLabel labelCadastrarPoupanca = new JLabel("Cadastrar Poupanca");
		labelCadastrarPoupanca.setBounds(48, 106, 192, 14);
		contentPane.add(labelCadastrarPoupanca);
		
		textPoupanca = new JTextField();
		textPoupanca.setBounds(48, 159, 133, 20);
		contentPane.add(textPoupanca);
		textPoupanca.setColumns(10);
		
		JLabel labelInvestimentos = new JLabel("Cadastrar Outros Investimentos");
		labelInvestimentos.setBounds(48, 248, 279, 14);
		contentPane.add(labelInvestimentos);
		
		textInvestimentos = new JTextField();
		textInvestimentos.setBounds(48, 330, 133, 20);
		contentPane.add(textInvestimentos);
		textInvestimentos.setColumns(10);
		
		JButton btnCadastrarPatrimonio = new JButton("Cadastrar");
		btnCadastrarPatrimonio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//criar variaveis para receber os valores inseridos pelo usuario
				double corrente,poupanca,investimentos;
				corrente = Double.parseDouble(textCorrente.getText());
				poupanca = Double.parseDouble(textPoupanca.getText());
				investimentos = Double.parseDouble(textInvestimentos.getText());
				
				//instanciar Patrimonio para setar os valores
				Patrimonio objPatrimonio=new Patrimonio(corrente,poupanca,investimentos);
				
				//passar esses valores para a DAO
				PatrimonioDAO objPatrimonioDAO=new PatrimonioDAO();
				objPatrimonioDAO.cadastrarPatrimonio(objPatrimonio);
				 JOptionPane.showMessageDialog(null, "Patrimonio cadastrado com sucesso!");
			
			            	frmMenuView objfrmMenuView=new frmMenuView();
			            	objfrmMenuView.setVisible(true);
			            	dispose();
			            }
			       
	
		});
		btnCadastrarPatrimonio.setBounds(172, 453, 180, 23);
		contentPane.add(btnCadastrarPatrimonio);
	}
}
