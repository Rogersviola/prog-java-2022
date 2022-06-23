package br.com.senaisp.aula32;

import java.sql.SQLException;

import br.com.senaisp.aula32.classes.Cliente;

public class TesteCliente {

	public static void main(String[] args) {
		Cliente cli = new Cliente();
		cli.setNome("Roberto");
		cli.setEndereco("Rua das Ruas");
cli.setNumero("s/n");
cli.setBairro("centro");
cli.setCidade("Bauru");
cli.setUf("SP");
cli.setCep("17051-000");
cli.setCpf("111.111.111.-11");
cli.setRg("11.111.111.-1");
		
try {
	cli.criarNaoUse();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

	}

}
