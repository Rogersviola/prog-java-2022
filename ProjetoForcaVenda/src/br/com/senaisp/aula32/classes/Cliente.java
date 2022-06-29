package br.com.senaisp.aula32.classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

public class Cliente {
private int id;
private String nome;
private String endereco;
private String numero;
private String complemento;
private String bairro;
private String cidade;
private String uf;
private String cpf;
private String rg;
private Date data_nasc;

private DateFormat dtFmt;
private DateFormat dtFmtBD;

private ConexaoBD conn;
private String cep;

public Cliente() {
	dtFmt = new SimpleDateFormat("dd/MM/yyyy");
	dtFmtBD = new SimpleDateFormat("yyyy-MM-dd");
	conn = ConexaoBD.getInstance();
	
}

public void criar() {
	
}

public void criarNaoUse() throws SQLException {
	conn.conectarBD();
Statement stmt = conn.getConector().createStatement();
String strDtNasc = "";
if (data_nasc!=null)strDtNasc = dtFmtBD.format(data_nasc);
String sql="insert into cliente(nome,endereco,numero,complemento,bairro,cidade,uf,cep,cpf,rg,data_nasc)\r\n"
		+ "values('"+nome+"',"
        + "'"+endereco+"',"
		+ " '"+numero+"',"
		+ (complemento == null ? "null," : "'" +complemento+"',")
		+ "'"+bairro+"',"
		+ "'"+cidade+"',"
		+ "'"+uf+"',"
		+ "'"+cep+"',"
		+ "'"+cpf+"',"
	    + "'"+rg+"',"
		+( data_nasc == null ? "null" :""+strDtNasc+"'")
		+")";
System.out.println("SQL:" + sql);
//executando a insercao de registro
int rowsAff = stmt.executeUpdate(sql);
System.out.println("Linhas afetadas:" + rowsAff);
//obtendo o ID gerado na insercao do registro
ResultSet rs = stmt.executeQuery("select last_insert_id();");
rs.next();
//pegando o valor do registro do SQL disparado
id = rs.getInt(1);
System.out.println("ID ->" + id);

}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getEndereco() {
	return endereco;
}
public void setEndereco(String endereco) {
	this.endereco = endereco;
}
public String getNumero() {
	return numero;
}
public void setNumero(String numero) {
	this.numero = numero;
}
public String getComplemento() {
	return complemento;
}
public void setComplemento(String complemento) {
	this.complemento = complemento;
}
public String getBairro() {
	return bairro;
}
public void setBairro(String bairro) {
	this.bairro = bairro;
}
public String getCidade() {
	return cidade;
}
public void setCidade(String cidade) {
	this.cidade = cidade;
}
public String getUf() {
	return uf;
}
public void setUf(String uf) {
	this.uf = uf;
}
public String getCpf() {
	return cpf;
}
public void setCpf(String cpf) {
	this.cpf = cpf;
}
public String getRg() {
	return rg;
}
public void setRg(String rg) {
	this.rg = rg;
}
public Date getData_nasc() {
	return data_nasc;
}
public void setData_nasc(Date data_nasc) {
	this.data_nasc = data_nasc;
}

public void setCep(String string) {
	cep = string;
	
}

public DefaultTableModel listaCliente() {
	// TODO Auto-generated method stub
	return null;
}





}
