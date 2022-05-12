package br.com.senaisp.aula14;

import java.util.Scanner;

import br.com.senaisp.aula14.classes.MamiferosEncapsulada;
import br.com.senaisp.aula14.classes.MamíferosEncapsulada;

public class ExemploMamíferosEncapsulado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MamiferosEncapsulada humano = new MamiferosEncapsulada ();
		Scanner sc = new Scanner (System.in);
		System.out.println("Digite a cor da pele do humano:");
		humano.setPele(sc.nextLine());
					
		do {
			System.out.println("Digite a cor dos olhos do humano:");
		try {
			humano.setOlhos(sc.nextLine());
			break;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	} while (true);
				
		System.out.println("Digite o tamanho da boca do humano:");
		humano.setBoca(sc.nextLine());
		
		System.out.println("Digite o peso do humano:");
		humano.setPeso(sc.nextDouble());
		
		//mostrando os dados cadastrados
		System.out.println("Pele digitada: " + humano.getPele());
		System.out.println("Olhos digitados: " + humano.getOlhos());
		System.out.println("Boca digitada: " + humano.getBoca());
		System.out.println("Peso digitado: " + humano.getPeso());
		
		sc.close();
		
		
	}

}
