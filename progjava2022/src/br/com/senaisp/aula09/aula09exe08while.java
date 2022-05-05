package br.com.senaisp.aula09;

public class aula09exe08while {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int intlinha = 1;
		int intcoluna = 1;
		while (intlinha < 10) {
			intcoluna = 1;
			while (intcoluna < 10) {
				if (intcoluna >= intlinha)
					System.out.print(intlinha + "-" + intcoluna + " ");
				else
					System.out.print("    ");
				intcoluna++;

			}
			System.out.println();
			intlinha++;
		}

	}

}
