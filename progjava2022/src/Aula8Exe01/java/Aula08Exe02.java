package Aula8Exe01.java;

import java.util.Scanner;

public class Aula08Exe02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int intContador = 0, intSoma = 0;
		int intNumero;
			Scanner sc = new Scanner(System.in);
		System.out.println("Programa média de números positivos");
		do {
			System.out.println("digite um número positivo:" + "(negativo finaliza o programa)");
			intNumero = sc.nextInt();
			if (intNumero >= 0) {
				intContador++;
				intSoma+=intNumero;
			}
		} while (intNumero >= 0);
		//temos que testar se nenhum valor foi computado
		if (intContador>0)
			System.out.println("A media de números" + "positivos digitados foi de " + (intSoma / intContador));
			sc.close();
		

	}

}
