package br.com.senaisp.aula22;

import br.com.senaisp.aula21.classes.Cliente;

public class TesteCliente {

	public static void main(String[] args) {
		Cliente cli = new Cliente();
		
		for (int intI=0;intI<10;intI++) {
			cli.setCodigo(intI + 1);
			cli.setNome("Genérico" + (intI + 1));
			cli.setEndereco("Rua" + (intI + 1)) ;
			cli.adicionar();
		}
		cli.listarClientes();
		
		
		
		
		
		
	}

}
