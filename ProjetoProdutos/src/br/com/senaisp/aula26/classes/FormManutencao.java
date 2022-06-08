package br.com.senaisp.aula26.classes;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

public class FormManutencao extends JFrame {

	private JPanel contentPane;
	private JFormattedTextField Codigo;
	private JTextField Descricao;
	private int tipoEdicao;
	private JFormattedTextField fmtPreco;
	private Produto prod;
	private JButton btnPesquisar;
	private JButton btnGravar;

	public void setProd(Produto prod) {
		this.prod = prod;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormManutencao frame = new FormManutencao();
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
	public FormManutencao() {
		EventoClick evtClick = new EventoClick();

		setTitle("Manuten\u00E7\u00E3o de Produtos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 552);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelBotoes = new JPanel();
		contentPane.add(panelBotoes, BorderLayout.SOUTH);

		btnGravar = new JButton("Confirmar");
		panelBotoes.add(btnGravar);
		btnGravar.addActionListener(evtClick);

		JButton btnCancelar = new JButton("Cancelar");
		panelBotoes.add(btnCancelar);
		btnCancelar.addActionListener(evtClick);

		JPanel panelCorpo = new JPanel();
		contentPane.add(panelCorpo, BorderLayout.NORTH);
		panelCorpo.setLayout(new GridLayout(3, 0, 0, 0));

		JPanel panelCodigo = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelCodigo.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelCorpo.add(panelCodigo);

		JLabel lblCodigo = new JLabel("C\u00F3digo");
		panelCodigo.add(lblCodigo);

		NumberFormat fmtI = NumberFormat.getInstance();
		NumberFormatter fmttI = new NumberFormatter(fmtI);
		fmttI.setValueClass(Integer.class);
		fmttI.setMinimum(0);
		fmttI.setMaximum(Integer.MAX_VALUE);
		fmttI.setAllowsInvalid(false);

		Codigo = new JFormattedTextField(fmttI);
		panelCodigo.add(Codigo);
		Codigo.setColumns(10);
		Codigo.setValue(0);

		btnPesquisar = new JButton("...");
		panelCodigo.add(btnPesquisar);
		btnPesquisar.addActionListener(evtClick);
		btnPesquisar.setVisible(false);

		JPanel panelDescricao = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelDescricao.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panelCorpo.add(panelDescricao);

		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o");
		panelDescricao.add(lblDescricao);

		Descricao = new JTextField();
		panelDescricao.add(Descricao);
		Descricao.setColumns(30);

		JPanel panelPreco = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panelPreco.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panelCorpo.add(panelPreco);

		JLabel lblPreco = new JLabel("Pre\u00E7o");
		panelPreco.add(lblPreco);
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		NumberFormatter fmtt = new NumberFormatter(fmt);
		fmtt.setMinimum(0.00);
		fmtt.setMaximum(999999999999.99);
		fmtt.setAllowsInvalid(false);

		fmtPreco = new JFormattedTextField(fmtt);
		fmtPreco.setColumns(10);
		fmtPreco.setValue(0.00);
		panelPreco.add(fmtPreco);
	}

	public int getTipoEdicao() {
		return tipoEdicao;
	}

	public void setTipoEdicao(int tipoEdicao) {
		this.tipoEdicao = tipoEdicao;
		// operacao 1- Cadastrar, 2-Consultar, 3- Alterar, 4-Excluir
		Descricao.setEnabled(false);
		fmtPreco.setEnabled(false);
		btnGravar.setEnabled(false);
		
		switch (tipoEdicao) {
		case 1:
			Codigo.setValue(prod.getCodigo());
			Descricao.setText(prod.getDescricao());
			fmtPreco.setValue(prod.getPreco());
			Descricao.setEnabled(true);
			fmtPreco.setEnabled(true);
			btnGravar.setEnabled(true);
			break;
		case 2:
			btnPesquisar.setVisible(true);
			break;
		case 3:
			btnPesquisar.setVisible(true);
			break;
		case 4:
			btnPesquisar.setVisible(true);
			break;
		}
	}

	class EventoClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			Object cmp = e.getSource();
			if (((JButton) cmp).getText() == "Confirmar") {
				prod.setCodigo((int) Codigo.getValue());
				prod.setDescricao(Descricao.getText());
				prod.setPreco((double) fmtPreco.getValue());
				if (tipoEdicao == 1) {
					prod.adicionar();
				} else if (tipoEdicao == 3) {
					prod.alterar();
				} else if (tipoEdicao == 4) {
					if (JOptionPane.showConfirmDialog(null, "Deseja mesmo Excluir", "ATENÇÂO!!!",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
						prod.excluir();
					}
				}
				dispose();
			} else if (cmp == btnPesquisar) {
				if (prod.hasCodigo((int) Codigo.getValue())) {
					prod.setCodigo((int) Codigo.getValue());
					
					prod.consultar();
					Descricao.setText(prod.getDescricao());
					fmtPreco.setValue(prod.getPreco());
					// alteracao - habilitar a edicao de valores
					if (tipoEdicao == 3) {
						Descricao.setEnabled(true);
						fmtPreco.setEnabled(true);
						Codigo.setEnabled(false);

					}
					// operador ternário
					btnGravar.setEnabled(tipoEdicao > 2 ? true : false);
					// ou
					btnGravar.setEnabled(tipoEdicao > 2);

				}
			} else {
				dispose();
			}
		}
	}
}
