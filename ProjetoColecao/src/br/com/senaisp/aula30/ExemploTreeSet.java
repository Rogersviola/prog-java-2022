package br.com.senaisp.aula30;

import java.util.TreeSet;
import java.util.Iterator;
import java.util.Set;

public class ExemploTreeSet {
private Set<String>ListaFilmes;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ExemploTreeSet ex = new ExemploTreeSet();
ex.ListaFilmes = new TreeSet<String>();
System.out.println("Exemplo de uso de interface List");
System.out.println();

ex.insere("Blade Runner - O caçador de androides");
ex.insere("O exterminador do futuro 2");
		
ex.insere("Apocalipse Now");
ex.insere("Star Wars IV - Uma nova esperança");

ex.insere("Curtindo a vida adoidado");
ex.insere("Dracula - D e Bram Stocker");
ex.insere("2001 - Uma odisseia no espaço");

ex.imprimirLista();

ex.remove("Apocalipse Now");
ex.remove("2001 - Uma odisseia no espaço");

ex.imprimirLista();

	}


public void insere(String strTitulo) {
	ListaFilmes.add(strTitulo);
}
public void remove(String strTitulo) {
	ListaFilmes.remove(strTitulo);
}

public void imprimirLista() {
	System.out.println();
	System.out.println();
	Iterator<String>iteratorLista = ListaFilmes.iterator();
	while(iteratorLista.hasNext()) {
		System.out.println("titulo do filme:" + iteratorLista.next());
	}
}

	

	}


