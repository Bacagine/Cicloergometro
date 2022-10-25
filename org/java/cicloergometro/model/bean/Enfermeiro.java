/* Enfermeiro.java: Classe que representa um enfermeiro
 * 
 * Desenvolvido por Gustavo Bacagine <gustavo.bacagine@protonmail.com> 
 * 
 * Data: 18/10/2022
 */

package org.java.cicloergometro.model.bean;

public class Enfermeiro extends ProfissionalDeSaude{
	private int codEnfermeiro;

	public Enfermeiro(){
		
	}

	public Enfermeiro(String login, String senha, String nome, String CPF, char sexo){
		super(login, senha, nome, CPF, sexo);
	}

	public Enfermeiro(String nome, String CPF, char sexo){
		super(nome, CPF, sexo);
	}

	public int getCodEnfermeiro(){
		return this.codEnfermeiro;
	}

	public void setCodEnfermeiro(int codEnfermeiro){
		this.codEnfermeiro = codEnfermeiro;
	}

	@Override
	public String toString(){
		String aux = "Cod: " + this.getCodEnfermeiro();
		aux += "\nNome: " + this.getNome();
		aux += "\nSexo: " + this.getSexo();
		
		return aux;
	}
}
