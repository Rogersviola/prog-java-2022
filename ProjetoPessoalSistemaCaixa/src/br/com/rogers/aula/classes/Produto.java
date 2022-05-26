package br.com.rogers.aula.classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.senaisp.aula21.classes.Produto;



public class Produto {
	private List<Produto> listaProduto;
private int Id;
private String Descricao;
private double precoUnitario;
private int saldo;
private String dataVencimento;
private String dataFabricacao;
public Produto() {
	super();
	ConexaoFake fake = ConexaoFake.getInstance();
	
	ArrayList<Produto> listaProduto = new ArrayList<Produto>();
}
public int getId() {
	return Id;
}
public void setId(int id) {
	Id = id;
}
public String getDescricao() {
	return Descricao;
}
public void setDescricao(String descricao) {
	Descricao = descricao;
}
public double getPrecoUnitario() {
	return precoUnitario;
}
public void setPrecoUnitario(double precoUnitario) {
	this.precoUnitario = precoUnitario;
}
public int getSaldo() {
	return saldo;
}
public void setSaldo(int saldo) {
	this.saldo = saldo;
}
public String getDataVencimento() {
	return dataVencimento;
}
public void setDataVencimento(String dataVencimento) {
	this.dataVencimento = dataVencimento;
}
public String getDataFabricacao() {
	return dataFabricacao;
}
public void setDataFabricacao(String dataFabricacao) {
	this.dataFabricacao = dataFabricacao;
}
public void adicionar() {
	int intId = pesqProduto(this.Id);
	if (intId ==-1) {
		//criar o objeto produto para adicionar as informacoes
		Produto prod = new Produto();
		//setando os dados para o novo objeto
		prod.setId(Id);
		prod.setDescricao(Descricao);
		prod.setprecoUnitario(precoUnitario);
		prod.setSaldo(saldo);
		prod.setDataVencimento(dataVencimento);
		prod.setDataFabricacao(dataFabricacao);
		//colocando o objeto na lista
		
		listaProduto.add(this);
		
	}else {
		System.out.println("Já existe esse Produto!");
	}
}

private int pesqProduto(int codigo2) {
	int intRet = -1;
	for (int intId = 0; intId < listaProduto.size(); intId++) {
		if (listaProduto.get(intId).getId() == codigo2) {
			intRet = intId;
			break;
		}
	}
	return intRet;
}
public void listarProduto() {
	System.out.println("Listagem de Produto");
	System.out.println("# - Id - Descricao");
	System.out.println("-----------------------");
	for(int intId=0;intId<listaproduto.size();intId++) {
		Produto prod = listaProduto.get(intId);
		System.out.print(intId + " - ");
		System.out.print(prod.getId() + " - ");
		System.out.print(prod.getDescricao() + " - ");
		System.out.println(prod.toString() + " - " + prod.getListaSize());
		
		
		
	}
	
}
public int getListaSize() {
	return listaProduto.size();
	
}
public void alterar() {
	int intId=pesqproduto(codigo);
	if (intId >-1) {
		
		
		
		
		
		
		
	}
}
}

