
public class Aula09Exe02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Aplicativo para monstrar linhas e colunas");
		int intlinha = 1;
		int intcoluna = 1;
		
		
		for (intlinha = 1; intlinha<=9; intlinha++) {
			System.out.println();
			
			for (intcoluna =1; intcoluna<=9; intcoluna++)
				if (intcoluna <= intlinha)
				System.out.print(intlinha + "-" + intcoluna + " ");
				else
					System.out.print("    ");
			
		 	
		}
				

	}


	}


