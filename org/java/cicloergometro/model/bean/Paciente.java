/* Paciente.java
 * 
 * Desenvolvido por Gustavo Bacagine <gustavo.bacagine@protonmail.com> 
 * 
 * Data: 18/10/2022
 * Data da última modificação: 25/10/2022
 */

package org.java.cicloergometro.model.bean;

public class Paciente extends Pessoa{
    private int codPaciente;

    public Paciente(){

    }

    public Paciente(String login, String senha, String nome, String CPF, char sexo, String telefone, Endereco endereco){
        super(login, senha, nome, CPF, sexo, telefone, endereco);
    }

    @Override
    public String toString(){
        String aux = "Nome: " + this.getNome();
        aux += "\nCPF.:" + this.getCPF();
        aux += "\nSexo: " + this.getSexo();
        aux += "\nTelefone: " + this.getTelefone();
        aux += "\nEndereco: " + this.getEndereco();

        return aux;
    }
}

