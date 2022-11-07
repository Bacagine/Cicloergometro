/* Agenda.java: 
 * 
 * Desenvolvido por Gustavo Bacagine <gustavo.bacagine@protonmail.com>
 * 
 * Data: 18/10/2022
 * Data da última modificação: 07/11/2022
 */

package org.java.cicloergometro.model.bean;

import java.time.LocalDate;
import java.time.LocalTime;

public class Agenda{
	private int codAgenda;
    private LocalDate data;
    private LocalTime hora;
    private Agenda retorno;

    public Agenda(){

    }

    public Agenda(LocalDate data, LocalTime hora, Agenda retorno){
        this.setData(data);
        this.setHora(hora);
        this.setRetorno(retorno);
    }

    /* Getters */
    public int getCodAgenda(){
        return this.codAgenda;
    }

    public LocalDate getData(){
        return this.data;
    }

    public LocalTime getHora(){
        return this.hora;
    }

    public Agenda getRetorno(){
        return this.retorno;
    }

    /* Setters */
    public void setCodAgenda(int codAgenda){
        this.codAgenda = codAgenda;
    }
    
    public void setData(LocalDate data){
        this.data = data;
    }

    public void setHora(LocalTime hora){
        this.hora = hora;
    }

    public void setRetorno(Agenda retorno){
        this.retorno = retorno;
    }

    /* Outros metodos */
    @Override
    public String toString(){
        String aux;
        aux = "Data: " + this.getData();
        aux += "\nHora: " + this.getHora();
        return aux;
    }

    public void mostrarRetorno(){
        this.retorno.toString();
    }
}
