package br.com.senaisp.aula14.classes;

public class ClasseCliente {
	public int C�digo;
	public String Nome;
	public String Ende�o;
	public int getC�digo() {
		return C�digo;
	}
	public void setC�digo(int c�digo) {
		C�digo = c�digo;
	}
	public String getNome() {
		return Nome;
		
	}
	public void setNome(String nome) {
		Nome = nome;
		if (nome.lengeth()<3) {
			throw new ParametroInvalidoException("Nome deve ter pelo menos 3 letras!")
		}
	}
	public String getEnde�o() {
		return Ende�o;
	}
	public void setEnde�o(String ende�o) {
		Ende�o = ende�o;
	}
	

}
