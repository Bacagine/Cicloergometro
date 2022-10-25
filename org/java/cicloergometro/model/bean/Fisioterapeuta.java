/* Fisioterapeuta.java
 * 
 * Desenvolvido por Gustavo Bacagine <gustavo.bacagine@protonmail.com> 
 * 
 * Data: 18/10/2022
 */

package org.java.cicloergometro.model.bean;

public class Fisioterapeuta extends ProfissionalDeSaude{
    private int codFisioterapeuta;

    public Fisioterapeuta(){
        
    }

    public Fisioterapeuta(String login, String senha, String nome, String CPF, char sexo){
		super(login, senha, nome, CPF, sexo);
	}

    public int getCodFisioterapeuta(){
        return this.codFisioterapeuta;
    }

    public void setCodFisioterapeuta(int codFisioterapeuta){
        this.codFisioterapeuta = codFisioterapeuta;
    }

    @Override
    public String toString(){
        String aux = "Cod.: " + this.getCodFisioterapeuta();
        aux += "\nNome: " + this.getNome();

        return aux;
    }
}
