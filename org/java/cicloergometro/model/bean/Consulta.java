/* Consulta.java: Classe que representa uma consulta medica
 * 
 * Desenvolvido por Gustavo Bacagine <gustavo.bacagine@protonmail.com>
 * 
 * Data: 03/06/2022
 * Data da última modificação: 16/06/2022
 */

package org.java.cicloergometro.model.bean;

import java.time.LocalDate;
import java.time.LocalTime;

 public class Consulta{
	private int id;
	private Medico medico;
	private Paciente paciente;
	private LocalDate data;
	private LocalTime hora;
	private String especializacaoMedica;
	private Endereco endereco;
	private String observacoes;
	private double valor;

	/* Construtores */
	public Consulta(){

	}
/*
	public Consulta(Medico medico, Paciente paciente, LocalDate data,
			LocalTime hora, String especializacaoMedica, Endereco endereco, double valor){
		this.setMedico(medico);
		this.setPaciente(paciente);
		this.setData(data);
		this.setHora(hora);
		this.setEspecializacaoMedica(especializacaoMedica);
		this.setEndereco(endereco);
		this.setValor(valor);
	}
*/
	public Consulta(Medico medico, Paciente paciente, LocalDate data,
			LocalTime hora, String especializacaoMedica, Endereco endereco, String observacoes, double valor){
		this.setMedico(medico);
		this.setPaciente(paciente);
		this.setData(data);
		this.setHora(hora);
		this.setEspecializacaoMedica(especializacaoMedica);
		this.setEndereco(endereco);
		this.setObservacoes(observacoes);
		this.setValor(valor);
	}

	

	public Consulta(Medico medico, Paciente paciente, LocalDate data, LocalTime hora, String especialidade,
            String observacao, double valor){
		this.setMedico(medico);
		this.setPaciente(paciente);
		this.setData(data);
		this.setHora(hora);
		this.setEspecializacaoMedica(especializacaoMedica);
		this.setObservacoes(observacoes);
		this.setValor(valor);
    }

    /* Getters */
	public int getID(){
		return this.id;
	}

	public Medico getMedico(){
		return this.medico;
	}

	public Paciente getPaciente(){
		return this.paciente;
	}

	public LocalDate getData(){
		return this.data;
	}

	public LocalTime getHora(){
		return this.hora;
	}

	public String getEspecializacaoMedica(){
		return this.especializacaoMedica;
	}

	public Endereco getEndereco(){
		return this.endereco;
	}

	public String getObservacoes(){
		return this.observacoes;
	}

	public double getValor(){
		return this.valor;
	}

	/* Setters */
	public void setID(int id){
		this.id = id;
	}

	public void setMedico(Medico medico){
		this.medico = medico;
	}

	public void setPaciente(Paciente paciente){
		this.paciente = paciente;
	}

	public void setData(LocalDate data){
		this.data = data;
	}

	public void setHora(LocalTime hora){
		this.hora = hora;
	}

	public void setEspecializacaoMedica(String especializacaoMedica){
		this.especializacaoMedica = especializacaoMedica;
	}

	public void setEndereco(Endereco endereco){
		this.endereco = endereco;
	}

	public void setObservacoes(String observacoes){
		this.observacoes = observacoes;
	}

	public void setValor(double valor){
		this.valor = valor;
	}

	@Override
	public String toString(){
		String aux = "Paciente.....: " + this.paciente.getNome() + " Idade: " + this.paciente.getIdade();
        aux += "\nData.........: " + this.data.getDayOfMonth() + "/" + this.data.getMonthValue() + "/" + this.data.getYear();
        aux += "\nHora.........: " + this.getHora();
        aux += "\nMedico.......: " + this.getMedico();
		aux += "\nEspecialidade: " + this.getEspecializacaoMedica();
		if(this.getObservacoes() != null){
			aux += "\nObservações....: " + this.getObservacoes();
		}
		aux += this.getEndereco();

        return aux;
	}
}
