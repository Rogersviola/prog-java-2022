package br.com.senaisp.aula30;

import br.com.senaisp.aula30.classes.Cliente;
import br.com.senaisp.aula30.classes.Cliente.TipoArquivo;

public class testeCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Cliente cli = new Cliente();
//cli.importarArquivo("C:\\Users\\Aluno\\Downloads\\convertcsv.csv",TipoArquivo.CSV);
//cli.importarArquivo("C:\\Users\\Aluno\\Downloads\\data.JSON",TipoArquivo.JSON);
cli.importarArquivo("C:\\Users\\Aluno\\Downloads\\convertjson.xml",TipoArquivo.XML);
for (Object obj[]:cli.getLstClientes()) {
	System.out.println(obj[0]+" - " + obj [1] + " - " + obj [2] + " - " + obj [3] + " - " + obj [4] );
}




	}

}
