package br.com.senaisp.aula13;

import java.util.Scanner;

public class aula13exer01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strNome[] = new String [10];
		Scanner sc = new Scanner (System.in);
		//Entrando com os nomes dos clientes
				for(int intI=0;intI<10;intI++) {
					System.out.println("Digite nome para cadastro " + (intI + 1) +" :");
					strNome[intI] = sc.nextLine();
				}
		// Ordenando os Valores - BubbleSort - Bolha
				String strApoio;
				for (int intI=0; intI<9; intI++) {
					for (int intF = intI; intF<10; intF++) {
						//Ordena��o ascendente
						if (strNome[intI].compareToIgnoreCase(strNome[intF])>0) {
							strApoio = strNome[intI];
							strNome[intI] = strNome[intF];
							strNome[intF] = strApoio;
							
							
						}
					}
				}
				
				
				//Mostrando os nomes
				System.out.println("Mostrando os nomes digitados!");
				for (int intI=0;intI < 10; intI++){
					System.out.println(strNome[intI]);
				}
				sc.close();
	}

}
