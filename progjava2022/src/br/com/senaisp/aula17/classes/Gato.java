package br.com.senaisp.aula17.classes;

public class Gato extends Felino {
private String Raca;

public String getRaca() {
	return Raca;
}

public void setRaca(String raca) {
	Raca = raca;
}
@Override//ctrl + spaco e digitar fa e selecionar falar
	public void Falar() {
		// TODO Auto-generated method stub
		super.Falar();
		System.out.println(" miauuuuu");
	}
}
