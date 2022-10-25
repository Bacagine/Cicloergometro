/* ProfissionalDeSaude.java: 
 * 
 * Desenvolvido por Gustavo Bacagine <gustavo.bacagine@protonmail.com> 
 * 
 * Data: 18/10/2022
 */

package org.java.cicloergometro.model.bean;

public class ProfissionalDeSaude extends Pessoa{
//	private int codProfissional;
	
	public ProfissionalDeSaude(){

	}

	public ProfissionalDeSaude(String nome, String CPF, char sexo){
		super(nome, CPF, sexo);
	}

	public ProfissionalDeSaude(String login, String senha, String nome, String CPF, char sexo){
		super(login, senha, nome, CPF, sexo);
	}

	public ProfissionalDeSaude(String login, String senha, String nome, String CPF, char sexo, String telefone, Endereco endereco){
		super(login, senha, nome, CPF, sexo, telefone, endereco);
	}
}
