package br.com.senaisp.aula07;

public class ExemplosComandoFor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Lembra do exemplo do whil? olhe agora no for
		for (int intValor = 10; intValor > 0; intValor--) {
			if (intValor % 2 == 0)
				System.out.println("O n?mero" + intValor + "? par");
			else
				System.out.println("O n?mero" + intValor + " ? Impar");
		
		System.out.println("Valor depois do for" + intValor);
		}
	}

	}


