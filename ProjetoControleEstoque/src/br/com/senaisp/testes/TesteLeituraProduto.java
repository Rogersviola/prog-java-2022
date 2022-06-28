package br.com.senaisp.testes;

import br.com.senaisp.classes.Produto;

public class TesteLeituraProduto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Produto prod =  new Produto();
//indicando o produto que quero pesquisar
prod.setId(1);
//verificando se existe
if(prod.read()) {
	System.out.println("Encontrei o produto!");
	System.out.println("Descri��o:" + prod.getDescricao());
	System.out.println("saldo:" + prod.getSaldo());
	System.out.println("Pre�o:" + prod.getPreco());
	System.out.println("Local Estoque:" + prod.getLocal_estoque());
		
}else {
	System.out.println("N�o foi encontrado o produto!");
	if(prod.isHaErro()) {
		System.out.println("Ha erro no BD!");
		System.out.println(prod.getMsgErro());
	}
}
	}

}