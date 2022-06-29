package br.com.senaisp.testes;

import br.com.senaisp.classes.Produto;

public class TesteDelecaoProduto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Produto prod = new Produto();
		//setando o Id para pesquisar
		prod.setId(1);
		//pesquisando
		if (prod.read()) {
			//agora podemos excluir
			System.out.println("Produto encontrado");
			
			//executando a exclusao
			if(prod.delete()) {
				System.out.println("Exclus�o efetuada com sucessso!");
				
			}else {
				System.out.println("Problemas ao excluir!");
				System.out.println("Erro:" + prod.getMsgErro());
				
			}
		}else {
			System.out.println("Produto n�o encontrado!");
		}
	}

}
