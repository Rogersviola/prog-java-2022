package br.com.senaisp.Forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.FlowLayout;

public class FormProdutosManutencao extends JFrame {

	private JPanel contentPane;
	private JTextField textId;
	private JTextField textDescricao;
	private JTextField textLocalEstoque;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormProdutosManutencao frame = new FormProdutosManutencao();
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
	public FormProdutosManutencao() {
		setTitle("Manuten\u00E7\u00E3o Produtos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlBotoes = new JPanel();
		contentPane.add(pnlBotoes, BorderLayout.SOUTH);
		
		JButton btnConfirmar = new JButton("Confirmar");
		pnlBotoes.add(btnConfirmar);
		
		JButton btnCancelar = new JButton("Cancelar");
		pnlBotoes.add(btnCancelar);
		
		JPanel pnlMeio = new JPanel();
		contentPane.add(pnlMeio, BorderLayout.NORTH);
		pnlMeio.setLayout(new GridLayout(5, 0, 0, 0));
		
		JPanel pnlId = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnlId.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		pnlMeio.add(pnlId);
		
		JLabel ldlId = new JLabel("Id");
		pnlId.add(ldlId);
		
		textId = new JTextField();
		pnlId.add(textId);
		textId.setColumns(10);
		
		JPanel pnlDescricao = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) pnlDescricao.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		pnlMeio.add(pnlDescricao);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o");
		pnlDescricao.add(lblDescricao);
		
		textDescricao = new JTextField();
		pnlDescricao.add(textDescricao);
		textDescricao.setColumns(30);
		
		JPanel pnlSaldo = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) pnlSaldo.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		pnlMeio.add(pnlSaldo);
		
		JLabel lblSaldo = new JLabel("Saldo");
		pnlSaldo.add(lblSaldo);
		
		JFormattedTextField fmtSaldo = new JFormattedTextField();
		fmtSaldo.setColumns(10);
		pnlSaldo.add(fmtSaldo);
		
		JPanel pnlPreco = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) pnlPreco.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		pnlMeio.add(pnlPreco);
		
		JLabel lblPreco = new JLabel("Pre\u00E7o");
		pnlPreco.add(lblPreco);
		
		JFormattedTextField fmtPreco = new JFormattedTextField();
		fmtPreco.setColumns(15);
		pnlPreco.add(fmtPreco);
		
		JPanel pnlLocalEstoque = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) pnlLocalEstoque.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		pnlMeio.add(pnlLocalEstoque);
		
		JLabel lblLocalEstoque = new JLabel("Local Estoque");
		pnlLocalEstoque.add(lblLocalEstoque);
		
		textLocalEstoque = new JTextField();
		pnlLocalEstoque.add(textLocalEstoque);
		textLocalEstoque.setColumns(20);
	}

}
