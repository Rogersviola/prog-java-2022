package br.com.senaisp.aula30.classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.xml.crypto.dsig.Transform;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Cliente {
	private String nome;
	private int idade;
	private String cpf;
	private String rg;
	private Date dtNascimento;
	
	private List<Object[]>lstClientes;
	private DateFormat dtFmt;
	
	public Cliente() {
		lstClientes = new ArrayList<Object[]>();
		nome = "";
		idade = 0;
		cpf = "";
		rg ="";
		dtFmt = new SimpleDateFormat("dd/MM/yyyy");
		try {
			dtNascimento = dtFmt.parse("30/12/1899");
			
		}catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Date getDtnascimento() {
		return dtNascimento;
	}

	public void setDtnascimento(Date dtnascimento) {
		this.dtNascimento = dtNascimento;
	}

	public List<Object[]> getLstClientes() {
		return lstClientes;
	}
	
	public enum TipoArquivo{
		CSV,
		JSON,
		XML
		
	}
				
	
	public boolean importarArquivo(String strArquivo, TipoArquivo tpArq) {
		
		
		boolean ret = false;
		switch (tpArq) {
		case CSV:
			ret = lerCSV(strArquivo);
			break;
		case JSON:
			ret = lerJSON(strArquivo);
		case XML:
			ret = lerXML(strArquivo);
		}
		return ret;
	}

	public boolean exportarArquivo(String strArquivo, TipoArquivo tpArq) {
		boolean ret = false;
		switch (tpArq) {
		case CSV: ret = escreverCSV (strArquivo); break;
		case JSON: ret = escreverJSON (strArquivo);break;
		case XML: ret = escreverXML (strArquivo);break;
		
		}
		return ret;
	}
	public boolean gravarEstadoObjeto(String strArquivo) {
		boolean ret = false;
		File arq = new File(strArquivo);
		try {
			arq.delete();
			arq.createNewFile();
			FileOutputStream fos = new FileOutputStream(arq);
			ObjectOutputStream objStm = new ObjectOutputStream(fos);
			//gravar o objeto desejado
			objStm.writeObject(lstClientes);
			objStm.close();
			ret = true;
		}catch(Exception e ) {
			e.printStackTrace();
		}
		return ret ;
		
	}
	//deserializar objeto
	public boolean lerEstadoObjeto(String strArquivo) {
		boolean ret = false;
		lstClientes.clear();
		File arq = new File(strArquivo);
		//verificando se o arquivo existe no disco
		if(arq.exists()) {
			try {
			FileInputStream fis =new FileInputStream(arq);
			ObjectInputStream oiStm=new ObjectInputStream(fis);
			lstClientes = (ArrayList<Object[]>)oiStm.readObject();
			oiStm.close();
			ret=true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		}
		return ret;
	}
	private boolean escreverCSV(String strArquivo) {
		boolean ret = false;
		try {
			FileOutputStream fos = new FileOutputStream(strArquivo);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			BufferedWriter buf = new BufferedWriter(osw);
			//gravando o cabecalho do arquivo csv
			buf.write("nome, idade, cpf, rg, data_nasc\r\n");
			//usando o foreach para pegar os itens da lista
			for (Object it[] : lstClientes) {
				buf.write(it[0] + " , ");//nome
				buf.write(it[1] + " , ");//idade
				buf.write(it[2] + " , ");//cpf
				buf.write(it[3] + " , ");//rg
				buf.write(dtFmt.format(it[4] + " , "));//data_nasc
				buf.write( "\r\n ");//quebra de linha
				
								
				
			}
		buf.close();
		ret=true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	
	
	
	
	
	private boolean escreverXML(String strArquivo) {
		boolean ret = false;
		DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder build = fact.newDocumentBuilder();
			Document doc = build.newDocument();
			//criando o elemento principal do documento
			Element root = doc.createElement("root");
			doc.appendChild(root);
			for(Object objs[]: lstClientes) {
				Element linha = doc.createElement("row");
				
				linha.appendChild(criarNo(doc,"nome",(String)objs[0]));
				linha.appendChild(criarNo(doc,"idade",Integer.toString((int)objs[1])));
				linha.appendChild(criarNo(doc,"cpf",(String)objs[2]));
				linha.appendChild(criarNo(doc,"rg",(String)objs[3]));
				linha.appendChild(criarNo(doc,"data_nasc",dtFmt.format((Date)objs[4])));
				//adicionando a linha ao root
				root.appendChild(linha);
				
			}
			TransformerFactory transfFact = TransformerFactory.newInstance();
			Transformer transf = transfFact.newTransformer();
			DOMSource  dom = new DOMSource(doc);
			FileOutputStream fos = new FileOutputStream(strArquivo);
			StreamResult strRes = new StreamResult(fos);
			transf.transform(dom, strRes);
			ret = true;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return ret;
	}

	private Element criarNo(Document doc, String nomeNo, String conteudoNo) {
		Element el = doc.createElement(nomeNo);
		el.appendChild(doc.createTextNode(conteudoNo));
		return el;
	}

	private boolean escreverJSON(String strArquivo) {
		boolean ret = false;
		try {
			FileOutputStream fos = new FileOutputStream(strArquivo);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			BufferedWriter buf = new BufferedWriter(osw);
			
			JSONArray itens = new JSONArray();
			for(Object objs[] : lstClientes) {
				//criando objeto JSON
			
				JSONObject item = new JSONObject();
				item.put("nome", objs[0]);
				item.put("idade", objs[1]);
				item.put("cpf", objs[2]);
				item.put("rg", objs[3]);
				item.put("data_nasc",dtFmt.format( objs[4]));
				//adicionando item ao vetor
				itens.put(item);
					
			}
		//gravando o JSON String
		buf.write(itens.toString());
		buf.close();
		ret = true;
		
		
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	return ret;
	}

	

	private boolean lerXML(String strArquivo) {
		boolean  ret = false;
		lstClientes.clear();
		try {
			FileInputStream fis = new FileInputStream(strArquivo);
			DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
			DocumentBuilder build = fact.newDocumentBuilder();
			//transformando o arquivo em objeto xml (DOM)
			Document doc = build.parse(fis);
			//obtendo o objeto raiz
			Element noRoot = doc.getDocumentElement();
			//obtendo os elementos "row"
			NodeList listaNos = noRoot.getElementsByTagName("row");
			//percorrendo os elementos
			for (int intI=0; intI<listaNos.getLength(); intI++) {
				Node item = listaNos.item(intI);
				//vereficando se é elemento xml
				if(item instanceof Element) {
					Element itt = (Element) item;
					nome = itt.getElementsByTagName("nome").item(0).getTextContent();
					idade = Integer.parseInt(itt.getElementsByTagName("idade").item(0).getTextContent());
					cpf = itt.getElementsByTagName("cpf").item(0).getTextContent();
					rg = itt.getElementsByTagName("rg").item(0).getTextContent();
					dtNascimento = dtFmt.parse(itt.getElementsByTagName("data_nasc").item(0).getTextContent());
					Object obj[] = {
							nome,
							idade,
							cpf,
							rg,
							dtNascimento
					};
					lstClientes.add(obj);
					
					
				}
			}
			ret = true;
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		
		return ret;
	}

	private boolean lerJSON(String strArquivo) {
		boolean ret =false;
		lstClientes.clear();
		try {
			FileInputStream fis = new FileInputStream(strArquivo);
			InputStreamReader isr = new InputStreamReader(fis,StandardCharsets.UTF_8);
			BufferedReader buf = new BufferedReader(isr);
			StringBuilder stb = new StringBuilder();
						String linha ;
			//lendo a partir 2 linha 
			while ((linha = buf.readLine())!=null) {
				stb.append(linha);
					
			}
			buf.close();
			//criando objeo vetor JSON a partir do texto Json
			JSONArray itens = new JSONArray(stb.toString());
			for(int intI=0;intI<itens.length();intI++) {
				JSONObject it = itens.getJSONObject(intI);
				Object obj[] = {
						it.getString("nome"),
						it.getInt("idade"),
						it.getString("cpf"),
						it.getString("rg"),
						
						dtFmt.parse(it.getString("data_nasc"))
				};
				lstClientes.add(obj);
			}
			ret = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return ret;
	}

	private boolean lerCSV(String strArquivo) {
		boolean ret =false;
		lstClientes.clear();
		try {
			FileInputStream fis = new FileInputStream(strArquivo);
			InputStreamReader isr = new InputStreamReader(fis,StandardCharsets.UTF_8);
			BufferedReader buf = new BufferedReader(isr);
			//retirando primeira linha
			String linha = buf.readLine();
			//lendo a partir 2 linha 
			while ((linha = buf.readLine())!=null) {
				List <String> itens = Arrays.asList(linha.split("\\s*,\\s*"));
				dtNascimento = dtFmt.parse(itens.get(4));
				Object obj[] = {//nome,
					itens.get(0),//nome
					Integer.parseInt(itens.get(1)),//idade
					itens.get(2),
					itens.get(3),
					dtNascimento
					
				};
				lstClientes.add(obj);
			}
			buf.close();
			ret = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return ret;
	}

}
