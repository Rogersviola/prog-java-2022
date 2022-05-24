package br.com.senaisp.aula20.classes;

import br.com.senaisp.aula20.interfaces.InFalantes;

public class Humano extends Mamiferos implements InFalantes {
public Humano(String corPele, int idade) {
		super(corPele, idade);
		// TODO Auto-generated constructor stub
	}
private String etnia;
	public String getEtnia() {
	return etnia;
}
public void setEtnia(String etnia) {
	this.etnia = etnia;
}
	@Override
	public void falar() {
		System.out.println("Humano falando!");
	}

}
