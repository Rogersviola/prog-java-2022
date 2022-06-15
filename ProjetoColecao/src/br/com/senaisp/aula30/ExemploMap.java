package br.com.senaisp.aula30;


import java.util.Map;
import java.util.Collection;
import java.util.HashMap;

public class ExemploMap {
private Map<Integer,String>ListaFilmes;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ExemploMap ex = new ExemploMap();
ex.ListaFilmes = new HashMap<Integer,String>();
System.out.println("Exemplo de uso de interface List");
System.out.println();

ex.insere(2,"Blade Runner - O caçador de androides");
ex.insere(1,"O exterminador do futuro 2");
		
ex.insere(3,"Apocalipse Now");
ex.insere(4,"Star Wars IV - Uma nova esperança");

ex.insere(5,"Curtindo a vida adoidado");
ex.insere(6,"Dracula - D e Bram Stocker");
ex.insere(7,"2001 - Uma odisseia no espaço");

ex.imprimirLista();

ex.remove(3);
ex.remove(6);

ex.imprimirLista();

	}


public void insere(int intChave,String strTitulo) {
	ListaFilmes.put(intChave, strTitulo);
}
public void remove(int intChave) {
	ListaFilmes.remove(intChave);
}

public void imprimirLista() {
	System.out.println();
	System.out.println();
	
	Collection<String> strTitulos = ListaFilmes.values();
	for (String strTitulo : strTitulos) {
		System.out.println("Titulo do filme:" + strTitulo);
	}
	
	
	}
}

	
	


