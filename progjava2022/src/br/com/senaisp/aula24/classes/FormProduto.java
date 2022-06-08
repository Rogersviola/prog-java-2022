package br.com.senaisp.aula24.classes;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormProduto extends JFrame {

	private JPanel contentPane;
	private JTextField txtDescricao;
	private JTextField txtPreco;
	private JTextField txtCodigo;
	private Produto produto;
	private int operacao; //1 - cadastrar, 2 - alterar, 3 - consultar, 4 - excluir

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormProduto frame = new FormProduto();
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
	public FormProduto() {
		setTitle("Manuten\u00E7\u00E3o de Produtos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 594, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
			
		JPanel pnlTopo = new JPanel();
		contentPane.add(pnlTopo, BorderLayout.NORTH);
		pnlTopo.setLayout(new GridLayout(3, 1, 0, 0));

		JPanel pnlCodigo = new JPanel();
		pnlCodigo.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnlTopo.add(pnlCodigo);
		
		JPanel pnlDescricao = new JPanel();
		pnlDescricao.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnlTopo.add(pnlDescricao);

		JPanel pnlPreco = new JPanel();
		pnlPreco.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnlTopo.add(pnlPreco);
		
		JLabel lblCodigo = new JLabel("C�digo do produto");
		pnlCodigo.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);

		pnlCodigo.add(txtCodigo);

		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o do Produto");
		pnlDescricao.add(lblDescricao);
		
		txtDescricao = new JTextField();
		txtDescricao.setColumns(50);

		pnlDescricao.add(txtDescricao);
	
		
		JLabel lblPreco = new JLabel("Pre\u00E7o do Produto");
		pnlPreco.add(lblPreco);
		
		txtPreco = new JTextField();
		txtPreco.setColumns(10);

		pnlPreco.add(txtPreco);
		

		JPanel pnlBotoes = new JPanel();
		contentPane.add(pnlBotoes, BorderLayout.SOUTH);
		pnlBotoes.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnGravar = new JButton("Confirmar");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(operacao) {
				case 1:
					produto.setCodigo(Integer.parseInt(txtCodigo.getText()));
					produto.setDescricao(txtDescricao.getText());
					produto.setPreco(Double.parseDouble(txtPreco.getText()));
					
					System.out.println(produto.getCodigo());
					System.out.println(produto.getDescricao());
					System.out.println(produto.getPreco());
					
					produto.adicionar(); 
					break;
				case 2: produto.alterar(); break;
				case 3: produto.consultar(); break;
				case 4: produto.excluir();
				}
				dispose();
			}
		});
		pnlBotoes.add(btnGravar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		pnlBotoes.add(btnCancelar);
		
	}
	
	public void setProduto(Produto value) {
		produto = value;
		txtCodigo.setText(Integer.toString(produto.getCodigo()));
		txtDescricao.setText(produto.getDescricao());
		txtPreco.setText(Double.toString(produto.getPreco()));
	}
	public void setOperacao(int value) {
		if (value < 1 || value > 4) { 
			JOptionPane.showMessageDialog(null,"Valor Inv�lido!");
		} else {
			operacao = value;
		}
	}

}
