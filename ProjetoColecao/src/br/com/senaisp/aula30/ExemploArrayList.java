package br.com.senaisp.aula30;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExemploArrayList {
private List<String>ListaFilmes;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ExemploArrayList ex = new ExemploArrayList();
ex.ListaFilmes = new ArrayList<String>();
System.out.println("Exemplo de uso de interface List");
System.out.println();

ex.insereInicio("Blade Runner - O caçador de androides");
ex.insereInicio("O exterminador do futuro 2");
		
ex.insereFim("Apocalipse Now");
ex.insereFim("Star Wars IV - Uma nova esperança");

ex.insereInicio("Curtindo a vida adoidado");
ex.insereFim("Dracula - D e Bram Stocker");
ex.insereFim("2001 - Uma odisseia no espaço");

ex.imprimirLista();

ex.removeInicio();
ex.removeFim();

ex.imprimirLista();

	}
public  void insereInicio(String strTitulo) {
	ListaFilmes.add(strTitulo);
}
public void insereFim(String strTitulo) {
	ListaFilmes.add(strTitulo);
}
public void removeInicio() {
	ListaFilmes.remove(0);
}
public void removeFim() {
	int intUlt = ListaFilmes.size() -1;
	ListaFilmes.remove(intUlt);
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
