package br.com.senaisp.aula28.classes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormCliente extends JFrame {

	private JPanel contentPane;
	private JTable tblCliente;
	private DefaultTableModel tblMdCli;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormCliente frame = new FormCliente();
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
	public FormCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnAdicionar = new JButton("Adicionar");
		panel.add(btnAdicionar);
		
		JButton btnConsultar = new JButton("Consultar");
		panel.add(btnConsultar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormClienteManutencao fmtCli = new FormClienteManutencao();
				fmtCli.setTblMdCli(tblMdCli);
				fmtCli.setLnhaSelecionada(tblCliente.getSelectedRow());
				fmtCli.setTipoOperacao(3);
				fmtCli.setVisible(true);
			}
		});
		panel.add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		panel.add(btnExcluir);
		
		JScrollPane scrCliente = new JScrollPane();
		contentPane.add(scrCliente, BorderLayout.CENTER);
		
		String titulos[] = {"Código", "Nome", "Telefone", "Dt.Nascimento"};
		
		tblMdCli = new DefaultTableModel(titulos, 0) {
			 @Override
			public boolean isCellEditable(int row, int column) {
								return false;
			}
		};
		
		tblCliente = new JTable(tblMdCli) {
			@Override
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component cmp = super.prepareRenderer(renderer, row, column);
				//so nao aplicamos a cor quando a linha est selecionada
				if (!isCellSelected(row, column)) {
					cmp.setBackground(row%2==0?Color.WHITE: Color.LIGHT_GRAY);//operador ternario para colorir linha branca linha cinza 
				
				}
				// alinhando a coluna do codigo
				if (column==0) {
					((JLabel)cmp).setHorizontalAlignment(SwingConstants.RIGHT);
				}else {
					((JLabel)cmp).setHorizontalAlignment(SwingConstants.LEFT);
				}
				//colocando o espacamento entre a borda da celula e o conteudo
				((JLabel)cmp).setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
				
				return cmp;
			}
			
		};
		scrCliente.setViewportView(tblCliente);
		//obtendo o objeto calendario para utilizar datas
		Calendar cal = Calendar.getInstance();
		//obtendo objeto formatador de datas
		DateFormat fmtDt = new SimpleDateFormat("dd/MM/yyyy");//formatacao data dd minusculo dia, MM mes, yyyy ano
		
		for(int lin=1;lin<=5;lin++) {
			cal.set(1980, 0 , lin);
			Date dtNasc = cal.getTime();
		
			Object item[] = {lin, "Cliente" + lin, "14 9999-8833",fmtDt.format(dtNasc)}; 
			//adicionando o item a linha conjunto de dados
			tblMdCli.addRow(item);
			
			}
			}
		
	}


