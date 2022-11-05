/* PacienteDAO.java: 
 *
 * Desenvolvido por Gustavo Bacagine <gustavo.bacagine@protonmail.com>
 *
 * Data: 03/06/2022
 * Data da última modificação: 17/06/2022
 */

package org.java.cicloergometro.model.dao;

import org.java.cicloergometro.connection.ConnectionFactory;
import org.java.cicloergometro.model.bean.Paciente;

import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PacienteDAO{
	private Connection con = ConnectionFactory.getConnection();
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    /* Mostra todos os pacientes do banco de dados */
    public void listPacientes(){
        try {
            String sql = "select * from Paciente order by pacienteID";
            this.stmt = con.prepareStatement(sql);
            this.rs = this.stmt.executeQuery(sql);
            
            while(this.rs.next()){
                System.out.println("Id......: " + this.rs.getString("pacienteID") +
                                   "Nome....: " + this.rs.getString("nome") +
                                   "RG......: " + this.rs.getString("RG") +
                                   "CPF.....: " + this.rs.getString("CPF") +
                                   "Telefone: " + this.rs.getString("telefone") +
                                   "Convenio: " + this.rs.getString("convenio") +
                                   "Endereco: " + this.rs.getString("endereco"));
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }

    /* Insere um paciente no banco de dados */
    public boolean insertPaciente(Paciente paciente){
        try {
            String sql = "insert into Paciente(nome, login, passwd, RG, CPF, sexo, peso, altura, " + 
                         "telefone, email, dataNasimento, nacionalidade, convenio) values ('" +
            paciente.getNome() + "', '" + paciente.getLogin() + "', '" + paciente.getSenha() +
            "', '" + paciente.getRG() + "', '" +  paciente.getCPF() + "', '" + paciente.getSexo() + 
            "', '" + paciente.getPeso() + "', '" + paciente.getAltura() + "', '" + paciente.getTelefone() +
            "', '" + paciente.getEmail() + "', '" + paciente.getDataNascimento() + "'; '" /*+
            "', '" + paciente.getNacionalidade() + "', '" + paciente.getConvenio() + "');"*/;
            this.stmt = con.prepareStatement(sql);
            this.stmt.executeUpdate(sql);

            return true;
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /* Edita um paciente do banco de dados */
    public boolean editPaciente(Paciente paciente){
        try {
            String sql = "update Paciente set nome = " + paciente.getNome() + "  where pacienteID = " + paciente.getID() + ";\n";
            sql += "update Paciente set login = " + paciente.getLogin() + " where pacienteID = " + paciente.getID() + ";\n";
            sql += "upadte Paciente set passwd = " + paciente.getSenha() + " where pacienteID = " + paciente.getID() + ";\n";
            sql += "update Paciente set RG = " + paciente.getRG() + " where pacienteID = " + paciente.getID() + ";\n";
            sql += "update Paciente set CPF = " + paciente.getCPF() + " where pacienteID = " + paciente.getID() + ";\n";
            sql += "update Paciente set sexo = " + paciente.getSexo() + " where pacienteID = " + paciente.getID() + ";\n";
            sql += "update Paciente set peso = " + paciente.getPeso() + " where pacienteID = " + paciente.getID() + ";\n";
            sql += "update Paciente set altura = " + paciente.getAltura() + " where pacienteID = " + paciente.getID() + ";\n";
            sql += "update Paciente set telefone = " + paciente.getTelefone() + " where pacienteID = " + paciente.getID() + ";\n";
            sql += "update Paciente set email = " + paciente.getEmail() + " where pacienteID = " + paciente.getID() + ";\n"; 
            sql += "update Paceinte set dataNasimento = " + paciente.getDataNascimento() + " where pacienteID = " + paciente.getID() + ";\n";
//            sql += "update Paceinte set nacionalidade = " + paciente.getNacionalidade() + " where pacienteID = " + paciente.getID() + ";\n";
//            sql += "update Paciente set convenio = " + paciente.getConvenio() + " where pacienteID = " + paciente.getID() + ";\n";
            this.stmt = con.prepareStatement(sql);
            this.stmt.executeUpdate(sql);

            return true;
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /* Deleta um paciente do banco de dados */
    public boolean deletePaciente(int pacienteID){
        try {
            String sql = "delete from Paciente where pacienteID = " + pacienteID + ";";
            this.stmt = con.prepareStatement(sql);
            this.stmt.executeUpdate(sql);
            return true;
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
