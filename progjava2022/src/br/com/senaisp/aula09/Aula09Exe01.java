package br.com.senaisp.aula09;

public class Aula09Exe01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Aplicativo para monstrar linhas e colunas");
		int intlinha = 1;
		int intcoluna = 1;
		
		
		for (intlinha = 1; intlinha<=9; intlinha++) {
			System.out.println();
			
			for (intcoluna =1; intcoluna<=9; intcoluna++)
				System.out.print(intlinha + "-" + intcoluna + " ");
		 	
		}
				

	}

}
