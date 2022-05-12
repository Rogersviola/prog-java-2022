package br.com.senaisp.aula14.classes;

public class ClasseCliente {
	public int Código;
	public String Nome;
	public String Endeço;
	public int getCódigo() {
		return Código;
	}
	public void setCódigo(int código) {
		Código = código;
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
	public String getEndeço() {
		return Endeço;
	}
	public void setEndeço(String endeço) {
		Endeço = endeço;
	}
	

}
