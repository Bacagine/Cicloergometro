/* Recepcao.java
 * 
 * Desenvolvido por Gustavo Bacagine <gustavo.bacagine@protonmail.com> 
 * 
 * Data: 18/10/2022
 * Data da última modificação: 07/11/2022
 */

package org.java.cicloergometro.model.bean;

public class Recepcionista extends Pessoa{
    private int codRecepcionista;
    private Recepcao recepcao;

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
        String aux = "Cod....: " + this.getCodRecepcionista();
        aux += "Nome....: " + this.getNome();
        aux += "\nRecepcao: " + this.recepcao.getCodRecepcao();

        return aux;
    }
}
