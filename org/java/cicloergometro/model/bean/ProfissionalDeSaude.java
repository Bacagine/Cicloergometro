/* ProfissionalDeSaude.java: 
 * 
 * Desenvolvido por Gustavo Bacagine <gustavo.bacagine@protonmail.com> 
 * 
 * Data: 18/10/2022
 * Data da última modificação: 07/11/2022
 */

package org.java.cicloergometro.model.bean;

public class ProfissionalDeSaude extends Pessoa{
	private int codProfissional;
	private String especializacao;

	/* Construtores */
	public ProfissionalDeSaude(){

	}

	public ProfissionalDeSaude(String nome, String CPF, char sexo){
		super(nome, CPF, sexo);
	}

	public ProfissionalDeSaude(String login, String senha, String nome, String CPF, String especializacao){
		super(login, senha, nome, CPF);
		this.setEspecializacao(especializacao);
	}

	public ProfissionalDeSaude(String login, String senha, String nome, String CPF, char sexo){
		super(login, senha, nome, CPF, sexo);
	}

	public ProfissionalDeSaude(String login, String senha, String nome, String CPF, char sexo, String telefone, Endereco endereco){
		super(login, senha, nome, CPF, sexo, telefone, endereco);
	}

	/* Getters */
	public int getCodProfissional(){
		return this.codProfissional;
	}

	public String getEspecializacao(){
		return this.especializacao;
	}

	/* Setters */
	public void setCodProfissional(int codProfissional){
		this.codProfissional = codProfissional;
	}

	public void setEspecializacao(String especializacao){
		this.especializacao = especializacao;
	}
}
