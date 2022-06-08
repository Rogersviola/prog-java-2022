package br.com.senaisp.aula26.classes;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FormListarProduto extends JFrame {

	private JPanel contentPane;
	private JTable tblProdutos;
    private Produto prod;
    private DefaultTableModel tblMdProd;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormListarProduto frame = new FormListarProduto();
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
	public FormListarProduto() {
		setTitle("Listagem Produtos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 662, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelBotoes = new JPanel();
		contentPane.add(panelBotoes, BorderLayout.SOUTH);
		
		JButton btnFechar = new JButton("Fechar");
		panelBotoes.add(btnFechar);
		btnFechar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                dispose();

			}
		});
		
		JScrollPane scrTabela = new JScrollPane();
		contentPane.add(scrTabela, BorderLayout.CENTER);
		String cabecalho[] = {"Código" , "Descrição" , "Preço"};
		
		tblMdProd = new DefaultTableModel(cabecalho,0);
		
		
		tblProdutos = new JTable(tblMdProd);
		
		scrTabela.setViewportView(tblProdutos);
	}
   public void setProd(Produto prod) {
	    this.prod = prod;
	    for (int intLin=0;intLin<prod.getListaSize();intLin++) {
		Produto it = prod.getListaProdutos().get(intLin);
		Object item[] = {it.getCodigo(), it.getDescricao(),it.getPreco()};
		tblMdProd.addRow(item);
		
		
		}
	}

}
		
	


