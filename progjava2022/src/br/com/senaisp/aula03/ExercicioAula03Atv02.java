package br.com.senaisp.aula03;

import java.util.Scanner;

public class ExercicioAula03Atv02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    System.out.println("Sistema de convers�o de temperatura:");
	    System.out.println("Entre com a  temperatura em C�lsius:");	    
	    Scanner sc = new Scanner(System.in);
	    double dblTemperatura = sc.nextDouble();
	    //Posso calcular diretamente
	    System.out.println("A temperatura em Fahrenheit �" + (9 *dblTemperatura / 5 + 32));
	    //Calcular em uma vari�vel
	    double dblTemperaturaF = 9 * dblTemperatura / 5 + 32;
	    System.out.println("A temperatura em Fahrenheit �" + dblTemperaturaF);
	    
	    

	}

}
