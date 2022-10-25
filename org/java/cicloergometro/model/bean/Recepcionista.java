/* Recepcao.java
 * 
 * Desenvolvido por Gustavo Bacagine <gustavo.bacagine@protonmail.com> 
 * 
 * Data: 18/10/2022
 */

package org.java.cicloergometro.model.bean;

public class Recepcionista extends Pessoa{
    //private int codRecepcao;
    private int codRecepcionista;

    public Recepcionista(){

    }

    public Recepcionista(String login, String senha, String nome, String CPF, char sexo){
        super(login, senha, nome, CPF, sexo);
    }

    public int getCodRecepcionista(){
        return this.codRecepcionista;
    }

    public void setCodRecepcionista(int codRecepcionista){
        this.codRecepcionista = codRecepcionista;
    }

    @Override
    public String toString(){
        String aux = "Cod.: " + this.getCodRecepcionista();
        aux += "Nome: " + this.getNome();

        return aux;
    }
}
