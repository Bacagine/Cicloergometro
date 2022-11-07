/* Consulta.java: Classe que representa uma consulta medica
 * 
 * Desenvolvido por Gustavo Bacagine <gustavo.bacagine@protonmail.com>
 * 
 * Data: 03/06/2022
 * Data da última modificação: 07/11/2022
 */

package org.java.cicloergometro.model.bean;

import java.time.LocalDate;
import java.time.LocalTime;

 public class Consulta{
	private int codConsulta;
	private Fisioterapeuta fisioterapeuta;
	private Paciente paciente;
	private LocalDate data;
	private LocalTime hora;
//	private String especializacaoMedica;
	private Endereco endereco;
	private String observacoes;
//	private double valor;

	/* Construtores */
	public Consulta(){

	}
/*
	public Consulta(Fisioterapeuta fisioterapeuta, Paciente paciente, LocalDate data,
			LocalTime hora, String especializacaoMedica, Endereco endereco, double valor){
		this.setFisioterapeuta(fisioterapeuta);
		this.setPaciente(paciente);
		this.setData(data);
		this.setHora(hora);
		this.setEspecializacaoMedica(especializacaoMedica);
		this.setEndereco(endereco);
		this.setValor(valor);
	}
*/
	public Consulta(Fisioterapeuta fisioterapeuta, Paciente paciente, LocalDate data,
			LocalTime hora, String especializacaoMedica, Endereco endereco, String observacoes, double valor){
		this.setFisioterapeuta(fisioterapeuta);
		this.setPaciente(paciente);
		this.setData(data);
		this.setHora(hora);
//		this.setEspecializacaoMedica(especializacaoMedica);
		this.setEndereco(endereco);
		this.setObservacoes(observacoes);
//		this.setValor(valor);
	}

	

	public Consulta(Fisioterapeuta fisioterapeuta, Paciente paciente, LocalDate data, LocalTime hora, String especialidade,
            String observacao, double valor){
		this.setFisioterapeuta(fisioterapeuta);
		this.setPaciente(paciente);
		this.setData(data);
		this.setHora(hora);
//		this.setEspecializacaoMedica(especializacaoMedica);
		this.setObservacoes(observacoes);
//		this.setValor(valor);
    }

    /* Getters */
	public int getCodConsulta(){
		return this.codConsulta;
	}

	public Fisioterapeuta getFisioterapeuta(){
		return this.fisioterapeuta;
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
/*
	public String getEspecializacaoMedica(){
		return this.especializacaoMedica;
	}
*/
	public Endereco getEndereco(){
		return this.endereco;
	}

	public String getObservacoes(){
		return this.observacoes;
	}
/*
	public double getValor(){
		return this.valor;
	}
*/
	/* Setters */
	public void setCodConsulta(int codConsulta){
		this.codConsulta = codConsulta;
	}

	public void setFisioterapeuta(Fisioterapeuta fisioterapeuta){
		this.fisioterapeuta = fisioterapeuta;
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
/*
	public void setEspecializacaoMedica(String especializacaoMedica){
		this.especializacaoMedica = especializacaoMedica;
	}
*/
	public void setEndereco(Endereco endereco){
		this.endereco = endereco;
	}

	public void setObservacoes(String observacoes){
		this.observacoes = observacoes;
	}
/*
	public void setValor(double valor){
		this.valor = valor;
	}
*/
	@Override
	public String toString(){
		String aux = "Paciente.....: " + this.paciente.getNome() + " Idade: " + this.paciente.getIdade();
        aux += "\nData.........: " + this.data.getDayOfMonth() + "/" + this.data.getMonthValue() + "/" + this.data.getYear();
        aux += "\nHora.........: " + this.getHora();
        aux += "\nFisioterapeuta.......: " + this.getFisioterapeuta();
//		aux += "\nEspecialidade: " + this.getEspecializacaoMedica();
		if(this.getObservacoes() != null){
			aux += "\nObservações....: " + this.getObservacoes();
		}
		aux += this.getEndereco();

        return aux;
	}
}
