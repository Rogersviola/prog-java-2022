package br.com.senaisp.aula14;

import br.com.senaisp.aula14.classes.Mamíferos;

public class ExemploMamíferos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mamíferos boi = new Mamíferos();
		//Objeto mamífero
boi.Boca = "Pequena";
boi.Pele = "Branca";
boi.Olhos = "Bege";
boi.Peso = 800.5;
//Objeto mamífero
Mamíferos humano = new Mamíferos();
humano.Boca = "Pequena";
humano.Pele = "Branca";
humano.Olhos = "Bege";
humano.Peso = 85.5;
//Vetor de mamífero
Mamíferos conjunto[] = new Mamíferos[10];
conjunto [0] = new Mamíferos();
conjunto[0].Pele = "Branca";
conjunto[0].Boca = "Grande";
conjunto[0].Olhos = "Negro";
conjunto[0].Peso = 10;
//Criando o segundo mamífero
conjunto[1] = new Mamíferos();

	}

}
