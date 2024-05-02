package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class frmVizualizarChamadosView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmVizualizarChamadosView frame = new frmVizualizarChamadosView();
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
	public frmVizualizarChamadosView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelChamadosAbertos = new JLabel("Chamados Abertos");
		labelChamadosAbertos.setBounds(129, 11, 228, 14);
		contentPane.add(labelChamadosAbertos);
		
		JLabel labelEstado = new JLabel("estado");
		labelEstado.setBounds(10, 58, 69, 30);
		contentPane.add(labelEstado);
		
		JLabel labelDescricao = new JLabel("Descricao");
		labelDescricao.setBounds(110, 66, 180, 104);
		contentPane.add(labelDescricao);
	}
}
