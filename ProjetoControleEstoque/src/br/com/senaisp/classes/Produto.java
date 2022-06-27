package br.com.senaisp.classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Produto {
private int id;
private String descricao;
private int saldo;
private double preco;
private String local_estoque;

private ConexaoBD conn;
private boolean haErro;
private String msgErro;

public Produto() {
	conn = ConexaoBD.getInstance();
	novo();
	
			
}
 public boolean create() {
	 boolean ret = false;
	 // ????significa que vai esperar parametro
	 String sql = "insert into produtos(descricao, saldo,preco,local_estoque)values(?,?,?,?)";
	 try {
		conn.conectarBD();
		//
		PreparedStatement stmt = conn.getConector().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		stmt.setString(1, descricao);
		stmt.setInt(2,saldo);
		stmt.setDouble(3, preco);
		stmt.setString(4, local_estoque);
		//executando o comando de insercao
		int rowsAff = stmt.executeUpdate();
		//log
		System.out.println("Linhas inseridas:" + rowsAff);
		//obtendo o valor do id gerado
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
		id = rs.getInt(1);//so ha uma coluna, por isso 1
		//log
		System.out.println("ID ->" + id);
		//se tudo ocorreu bem, chegou ate aqui e esta tudo certo
		ret = true;
		//desconectando do banco de dados
		conn.desconectarBD();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		haErro = true;
		msgErro = e.getMessage();


	}
	 return ret;
 }
public void novo() {
	id = 0;
	descricao = null;
	saldo = 0;
	preco = 0;
	local_estoque = null;
	
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getDescricao() {
	return descricao;
}

public void setDescricao(String descricao) {
	this.descricao = descricao;
}

public int getSaldo() {
	return saldo;
}

public void setSaldo(int saldo) {
	this.saldo = saldo;
}

public double getPreco() {
	return preco;
}

public void setPreco(double preco) {
	this.preco = preco;
}

public String getLocal_estoque() {
	return local_estoque;
}

public void setLocal_estoque(String local_estoque) {
	this.local_estoque = local_estoque;
}

}
