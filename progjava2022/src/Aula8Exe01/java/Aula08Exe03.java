package Aula8Exe01.java;

import java.util.Scanner;

public class Aula08Exe03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int intmenor = Integer.MAX_VALUE;
		int intmaior = Integer.MIN_VALUE;
		int intnumero;
		Scanner sc = new Scanner(System.in);
		System.out.println("Programa menor e maior de numeros positivos");
		do {
			System.out.println("Digite um numero positivo: " + "(negativo finaliza o programa");
			intnumero = sc.nextInt();
			if (intnumero >= 0) {
				if (intnumero > intmaior)
					intmaior = intnumero;
				if (intnumero < intmenor)
					intmenor = intnumero;
			}
		} while (intnumero >= 0);
		System.out.println(" o menor é" + intmenor);
		System.out.println(" o maior é" + intmaior);

	}

}
