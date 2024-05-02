package viewCadastrar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.ChamadosDAO;
import entidades.Chamados;
import view.frmMenuView;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmCadastrarChamado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textDescricao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmCadastrarChamado frame = new frmCadastrarChamado();
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
	public frmCadastrarChamado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelChamado = new JLabel("Cadastrar Chamado");
		labelChamado.setBounds(146, 0, 206, 14);
		contentPane.add(labelChamado);
		
		textDescricao = new JTextField();
		textDescricao.setBounds(58, 60, 310, 148);
		contentPane.add(textDescricao);
		textDescricao.setColumns(10);
		
		JLabel labelDescricao = new JLabel("Como podemos te ajudar!");
		labelDescricao.setBounds(57, 35, 311, 14);
		contentPane.add(labelDescricao);
		
		JButton btnCadastrarChamado = new JButton("Cadastrar Chamado");
		btnCadastrarChamado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarChamado();
			}
		});
		btnCadastrarChamado.setBounds(84, 227, 241, 23);
		contentPane.add(btnCadastrarChamado);
	}
	
	private void cadastrarChamado() {
		//definir variaveis
		String descricao;
		
		//obter conteudo
		descricao=textDescricao.getText();
		
		//setar
		Chamados objChamados=new Chamados(descricao);
		
		//levar para DAO
		ChamadosDAO objChamadosDAO=new ChamadosDAO();
		objChamadosDAO.cadastrarChamado(objChamados);
		
		//mensagem na tela
		JOptionPane.showInternalMessageDialog(null,"Chamado cadastrado com sucesso!");
		
		//Voltar para o menu
		frmMenuView objfrmMenuView=new frmMenuView();
		objfrmMenuView.setVisible(true);
		dispose();
		
		
	}
	
}
