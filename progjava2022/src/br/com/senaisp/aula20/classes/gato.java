package br.com.senaisp.aula20.classes;

import br.com.senaisp.aula20.interfaces.InFalantes;

public class gato extends Felinos implements InFalantes {

	public gato(String corPele, int idade) {
		super(corPele, idade);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void falar() {
		System.out.println("Miauuuuu!");
	}

}
