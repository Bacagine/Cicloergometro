/*Prontuario.java: 
 * 
 * Desenvolvido por Gustavo Bacagine <gustavo.bacagine@protonmail.com> 
 * 
 * Data: 18/10/2022
 */

package org.java.cicloergometro.model.bean;

import java.time.LocalDate;
import java.time.LocalTime;

public class Prontuario{
    private int codProntuario;
    private LocalDate data;
    private LocalTime hora;
    private String descricao;
    private String CID;
    private String status;

    public Prontuario(){

    }

    public Prontuario(LocalDate data, LocalTime hora, String descricao,
                      String CID, String status){
        this.setData(data);
        this.setHora(hora);
        this.setDescricao(descricao);
        this.setCID(CID);
        this.setStatus(status);
    }

    /* Getters */
    public LocalDate getData(){
        return this.data;
    }

    public LocalTime getHora(){
        return this.hora;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public String getCID(){
        return this.CID;
    }

    public String getStatus(){
        return this.status;
    }

    /* Setters */
    public void setData(LocalDate data){
        this.data = data;
    }

    public void setHora(LocalTime hora){
        this.hora = hora;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public void setCID(String CID){
        this.CID = CID;
    }

    public void setStatus(String status){
        this.status = status;
    }

    /* Outros metodos */

    @Override
    public String toString(){
        String aux = "CID: " + this.getCID();
        aux += "\nData: " + this.getData();
        aux += "\nHora: " + this.getHora();
        aux += "\nStatus: " + this.getStatus();
        aux += "\nDescricao: " + this.getDescricao();

        return aux;
    }
}
