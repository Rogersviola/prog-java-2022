package br.com.senaisp.aula14;

import br.com.senaisp.aula14.classes.Mam�feros;

public class ExemploMam�feros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mam�feros boi = new Mam�feros();
		//Objeto mam�fero
boi.Boca = "Pequena";
boi.Pele = "Branca";
boi.Olhos = "Bege";
boi.Peso = 800.5;
//Objeto mam�fero
Mam�feros humano = new Mam�feros();
humano.Boca = "Pequena";
humano.Pele = "Branca";
humano.Olhos = "Bege";
humano.Peso = 85.5;
//Vetor de mam�fero
Mam�feros conjunto[] = new Mam�feros[10];
conjunto [0] = new Mam�feros();
conjunto[0].Pele = "Branca";
conjunto[0].Boca = "Grande";
conjunto[0].Olhos = "Negro";
conjunto[0].Peso = 10;
//Criando o segundo mam�fero
conjunto[1] = new Mam�feros();

	}

}
