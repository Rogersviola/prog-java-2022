package br.com.senaisp.aula04;

public class ExemploConversoes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Definindo uma vari?vel double com um valor qualquer
		double dblTeste = 51.12;
		System.out.println("Double:" + dblTeste);
		//Convertendo para float
		float fltTeste = (float) dblTeste;
		System.out.println("Float:" + fltTeste);
		//Convertendo para long (inteiro)
		long lngTeste = (long) fltTeste;
		System.out.println("Long:" + lngTeste);
		//Convertendo para int (inteiro)
		int intTeste = (int)lngTeste;
		System.out.println("Int:" + intTeste);
		//Convertendo para short (inteiro)
		short shtTeste = (short) intTeste;
		System.out.println("Short:" + shtTeste);
		//Convertendo para byte (inteiro)
		byte bytTeste = (byte) shtTeste;
		System.out.println("Byte:" + bytTeste);
		//Convertendo texto para n?mero
		System.out.println("Vamos iniciar Convers?o de String para N?meros");
		String strValor = "52";
		//Convertendo para Double 
		dblTeste = Double.parseDouble(strValor);
		System.out.println("Double:" + dblTeste);
		//Convertendo para Float
		fltTeste = Float.parseFloat(strValor);
		System.out.println("Float:" + fltTeste);
		//Convertendo para Long
		lngTeste = Long.parseLong(strValor);
		System.out.println("Long:" + lngTeste);
		//Convertendo para Int
		intTeste = Integer.parseInt(strValor);
		System.out.println("Int:" + intTeste);
		//Convertendo para Short
		shtTeste = Short.parseShort(strValor);
		System.out.println("Short;" + shtTeste);
		//convertendo para Byte
		bytTeste = Byte.parseByte(strValor);
		System.out.println("Byte:" + bytTeste);
		//Convertendo para String
		System.out.println("Agora vamos de n?meros para String/Caracter");
		intTeste = 65; //Tabela Ascii A = 65
		char chrTeste = (char) intTeste;
		System.out.println("Char:" + chrTeste);
		//Convertendo de Double para string
		dblTeste = 52.12;
		String strTeste = Double.toString(dblTeste);
		System.out.println("Double para String:" + strTeste );
		//Convertendo de Float para string
		fltTeste = 52.12f;
		strTeste = Float.toString(fltTeste);
		System.out.println("Float para String:" + fltTeste);
		//Convertendo de Long para string
		lngTeste = 523;
		strTeste = Long.toString(lngTeste);
		System.out.println("long para string:" + strTeste);
		//Convertendo de Inteiro para String
		intTeste = 523;
		strTeste = Integer.toString(intTeste);
		System.out.println("Inteiro para String:" + strTeste);
		
		
		

	}

}
