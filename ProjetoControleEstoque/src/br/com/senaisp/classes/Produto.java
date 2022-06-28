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
public boolean read() {
	boolean ret = false;
	String sql = "select id, descricao,saldo,preco, local_estoque from produtos where id=?";
	try {
		conn.conectarBD();
		PreparedStatement stmt = conn.getConector().prepareStatement(sql);
		//setando os parametros
		stmt.setInt(1, id);
		//executando a instrucao
		ResultSet rs = stmt.executeQuery();
		//verificando se encontrou o dado
		if (rs.next()) {
			//log
			System.out.println("Encontrou o registro!");
			id = rs.getInt(1);
			descricao = rs.getString(2);
			saldo = rs.getInt(3);
			preco = rs.getDouble(4);
			local_estoque = rs.getString(5);
			
			ret =  true;
			
		}else {
			//log
			System.out.println("Não encontrou o registro!");
		}
		conn.desconectarBD();
	} catch (SQLException e) {
haErro = true;
msgErro = e.getMessage();
	}
	return ret;
	
}
public boolean update() {
	boolean ret = false;
	//update nunca esqueca colocar where(quando) senao ira setar tudo
	String sql = "update produtos set descricao =?,saldo=?,preco=?,local_estoque=? where id = ?";
	try {
		conn.conectarBD();
		PreparedStatement stmt = conn.getConector().prepareStatement(sql);
		//setando os valores
		stmt.setString(1, descricao);
		stmt.setInt(2, saldo);
		stmt.setDouble(3, preco);
		stmt.setString(4, local_estoque);
		stmt.setInt(5, id);
		//executando alteracao
		int rowsAff = stmt.executeUpdate();
		//log
		System.out.println("LInhas alteradas:" + rowsAff);
		//desconectando do banco de dados
		conn.desconectarBD();
		ret = true;
	} catch (SQLException e) {
haErro = true;
msgErro= e.getMessage();


	}
	return ret;
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
public boolean isHaErro() {
	return haErro;
}
public void setHaErro(boolean haErro) {
	this.haErro = haErro;
}
public void setMsgErro(String msgErro) {
	this.msgErro = msgErro;
}
public String getMsgErro() {
	// TODO Auto-generated method stub
	return msgErro;
}

}
