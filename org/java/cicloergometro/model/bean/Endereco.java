/* Endereco.java: Classe que representa um endereço
 * 
 * Desenvolvido por Gustavo Bacagine <gustavo.bacagine@protonmail.com> 
 * 
 * Data: 03/06/2022
 * Data da última modificação: 25/10/2022
 */

package org.java.cicloergometro.model.bean;

public class Endereco{
	private int enderecoID;
	private String logradouro;
	private String bairro;
	private String CEP;
	private int numero;
	private String cidade;
	private String UF;
	private String complemento;

	/* Construtores */
	public Endereco(){

	}

	public Endereco(String logradouro, String bairro, String CEP, 
			        int numero, String cidade, String UF,
			        String complemento){
		this.setLogradouro(logradouro);
		this.setBairro(bairro);
		this.setCEP(CEP);
		this.setNumero(numero);
		this.setCidade(cidade);
		this.setUF(UF);
//		this.setLogradouro(logradouro);
		this.setComplemento(complemento);
	}

	/* Getters */
	public int getID(){
		return this.enderecoID;
	}

	public String getLogradouro(){
		return this.logradouro;
	}

	public String getBairro(){
		return this.bairro;
	}

	public String getCEP(){
		return this.CEP;
	}

	public int getNumero(){
		return this.numero;
	}

	public String getCidade(){
		return this.cidade;
	}

	public String getUF(){
		return this.UF;
	}
/*
	public String getLogradouro(){
		return this.logradouro;
	}
*/
	public String getComplemento(){
		return this.complemento;
	}

	/* Setters */
	public void setID(int enderecoID){
		this.enderecoID = enderecoID;
	}
	
	public void setLogradouro(String logradouro){
		this.logradouro = logradouro;
	}

	public void setBairro(String bairro){
		this.bairro = bairro;
	}

	public void setCEP(String CEP){
		this.CEP = CEP;
	}

	public void setNumero(int numero){
		this.numero = numero;
	}

	public void setCidade(String cidade){
		this.cidade = cidade;
	}

	public void setUF(String UF){
		this.UF = UF;
	}
/*
	public void setLogradouro(String logradouro){
		this.logradouro = logradouro;
	}
*/
	public void setComplemento(String complento){
		this.complemento = complento;
	}

	@Override
	public String toString(){
		String aux = "\nEndereco\nRua...: " + this.getLogradouro() + "\n";
		aux += "Bairro: " + this.getBairro() + "\n";
		aux += "CEP...: " + this.getCEP() + "\n";
		aux += "Numero: " + this.getNumero() + "\n";
		aux += "Cidade: " + this.getCidade() + "\n";
		aux += "UF: " + this.getUF() + "\n";
		return aux;
	}
}
