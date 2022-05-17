package br.com.senaisp.aula17;

import br.com.senaisp.aula17.classes.Cachorro;
import br.com.senaisp.aula17.classes.Gato;
import br.com.senaisp.aula17.classes.Humano;
import br.com.senaisp.aula17.classes.Mamiferos;

public class ExemploHeranca {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// primeira coisa chamar classe pai "Mamiferos"
		Mamiferos mam[] = new Mamiferos[4];// posicinar em cima mamiferos clicar ctrl shift e "o"
		//criando um cachorro
		mam[0] = new Cachorro();// posicinar em cima mamiferos clicar ctrl shift e "o", da pra importar todo
								// conjunto colocando (.*)
		mam[0].setCorPelo("Malhado");
		mam[0].setIdade(5);
		mam[0].setNome("Toto");
//Cast para importar definicoes especifica da classe 
		((Cachorro) mam[0]).setRaca("SRD");
		
		//criando um gato
		mam[1] = new Gato();
		mam[1].setCorPelo("Preto");
		mam[1].setIdade(3);
		mam[1].setNome("Gatinho");
//cast
		((Gato) mam[1]).setRaca("SRD");
		((Gato) mam[1]).setPorte("Pequeno");
		// criando um humano
		mam[2] = new Humano();
		mam[2].setCorPelo("Loiro");
		mam[2].setIdade(30);
		mam[2].setNome("Jordan");
		//cast
		((Humano) mam[2]).setCorPele("Branca");
		//criando um mamifero 
		mam[3] = new Mamiferos();
		mam[3].setCorPelo("Azul");
		mam[3].setIdade(45);
		mam[3].setNome("Avatar");
		
		for (int intI=0;intI<4;intI++) {
			System.out.println("Nome: " +mam[intI].getNome());
			System.out.println("Cor Pelo: " +mam[intI].getCorPelo());
			System.out.println("idade: " +mam[intI].getIdade());
			mam[intI].Falar();
			System.out.println("---------------");
			
			
		}
		

	}

}
