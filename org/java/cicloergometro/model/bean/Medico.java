/* Medico.java
 * 
 * Desenvolvido por Gustavo Bacagine <gustavo.bacagine@protonmail.com> 
 * 
 * Data: 18/10/2022
 */

package org.java.cicloergometro.model.bean;

public class Medico extends ProfissionalDeSaude{
	private String CRM;
	private String especialidade;

	/* Construtores */
	public Medico(){

	}

	public Medico(String login, String senha, String nome, String CPF, char sexo, String CRM, String especialidade){
		super(login, senha, nome, CPF, sexo);
		this.setCRM(CRM);
		this.setEspecialidade(especialidade);
	}

	public Medico(String login, String senha, String nome, String RG, String CPF, char sexo, String telefone, Endereco endereco, String CRM, String especialidade){
		super(login, senha, nome, CPF, sexo, telefone, endereco);
		this.setCRM(CRM);
		this.setEspecialidade(especialidade);
	}

	public Medico(String nome, String CRM, String especialidade){
		this.setNome(nome);
		this.setCRM(CRM);
		this.setEspecialidade(especialidade);
    }

    /* Getters */
	public String getCRM(){
		return this.CRM;
	}
	
	public String getEspecialidade(){
		return this.especialidade;
	}

	/* Setters */
	public void setCRM(String CRM){
		this.CRM = CRM;
	}

	public void setEspecialidade(String especialidade){
		this.especialidade = especialidade;
	}

	@Override
	public String toString(){
		String aux = "Nome.........: " + this.getNome() + "\n";
//		aux += "RG...........: " + this.getRG() + "\n";
		aux += "CPF..........: " + this.getCPF() + "\n";
		aux += "CRM..........: " + this.getCRM() + "\n";
//		aux += "Telefone.....: " + this.getTelefone() + "\n";
		aux += "Especialidade: " + this.getEspecialidade() + "\n";
		return aux;
	}
}
