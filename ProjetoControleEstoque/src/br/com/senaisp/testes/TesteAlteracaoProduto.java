package br.com.senaisp.testes;

import br.com.senaisp.classes.Produto;

public class TesteAlteracaoProduto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Produto prod = new Produto();
//setando o Id para pesquisar
prod.setId(1);
//pesquisando
if (prod.read()) {
	//agora podemos alterar
	System.out.println("Produto encontrado");
	//alterando os dados
	prod.setDescricao("Produto 1 - encontrado");
	prod.setPreco(30.00);
	//executando a alteracao
	if(prod.update()) {
		System.out.println("Alteração fetuada com sucessso!");
		
	}else {
		System.out.println("Problemas ao alterar!");
		System.out.println("Erro:" + prod.getMsgErro());
		
	}
}
	}

}
