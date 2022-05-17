package br.com.senaisp.aula17.classes;

public class Cachorro extends Mamiferos {
private String Raca;

public String getRaca() {
	return Raca;
}

public void setRaca(String raca) {
	Raca = raca;
}
public void Falar() {
	System.out.println("Au AU AU");
}
}
