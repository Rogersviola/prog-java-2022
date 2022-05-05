package br.com.senaisp.aula09;

public class aula09exe10dowhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int intlinha = 1;
		int intcoluna = 1;
		while(intlinha<10) {
			intcoluna=1;
			while(intcoluna<10) {
				System.out.print(intlinha+"-" + intcoluna+" ");
				intcoluna++;
				
			}
			System.out.println();
			intlinha++;
		}

	}

}
