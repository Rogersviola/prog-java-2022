package br.com.senaisp.aula15.classes;

public class ConversorTemperatura {
private int tempOri;
private int tempDes;
private double temperatura;
public ConversorTemperatura() {
	// TODO Auto-generated constructor stub
	this.tempOri = 1;//indicador temperatura origem
	this.tempDes = 1;// tipo temperatura destino
	this.temperatura = 0;//valor temperatura
	
	
	
	
	
}
public int getTempOri() {
	return tempOri;
	
}
public void setTempOri(int tempOri) throws Exception {
	if (tempOri!=1 && tempOri!=2 && tempOri!=3){
		throw new Exception ("Valor inválido!");
		
	}
	this.tempOri = tempOri;
}
public int getTempDes() {
	return tempDes;
}
public void setTempDes(int tempDes) {
	this.tempDes = tempDes;
}
public double getTemperatura() {
	return temperatura;
}
public void setTemperatura(double temperatura) {
	this.temperatura = temperatura;
}
}
