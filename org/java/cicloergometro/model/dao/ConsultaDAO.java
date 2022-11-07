/* ConsultaDAO.java: 
 * 
 * Desenvolvido por Gustavo Bacagine <gustavo.bacagine@protonmail.com>
 * 
 * Data da última modificação: 07/11/2022
 */

package org.java.cicloergometro.model.dao;

import org.java.cicloergometro.connection.ConnectionFactory;
import org.java.cicloergometro.model.bean.Consulta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConsultaDAO{
    private Connection con = ConnectionFactory.getConnection();
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    /* Lista as consultas contidas
     * no banco de dados */
    public void listConsultas(){
        try {
            String sql = "list * from Consulta order by consultaID;";
            this.stmt = con.prepareStatement(sql);
            this.rs = this.stmt.executeQuery(sql);

            while(this.rs.next()){
                System.out.println("Id......: " + this.rs.getString("consultaID") +
                                   "Medico..: " + this.rs.getString("medico") +
                                   "Paciente: " + this.rs.getString("paciente") +
                                   "Data....: " + this.rs.getString("data") +
                                   "Hora....:" + this.rs.getString("hora") +
                                   "Especializacao Medica: " + this.rs.getString("especializacaoMedica") +
                                   "Local: " + this.rs.getString("endereco"));
            }
            
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }

    /* Insere uma consulta no
     * banco de dados */
    public boolean insertConsulta(Consulta consulta){
        try {
            String sql = "insert into Consulta(medico, paciente, data, hora, especializacaoMedica, endereco)" + 
            " values(" + consulta.getCodConsulta() + ", '" + consulta.getFisioterapeuta() + "', '" + consulta.getPaciente() +
            "', '" + consulta.getData() + "', '" + consulta.getHora() + "', '" + /*consulta.getEspecializacaoMedica() +*/
            "', '" + consulta.getEndereco() + "');\n";
            this.stmt = con.prepareStatement(sql);
            this.stmt.executeUpdate(sql);

            return true;
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /* Edita uma consulta no
     * banco de dados */
    public boolean editConsulta(Consulta consulta){
        try {
            String sql = "update Consulta set medico = " + consulta.getFisioterapeuta() + " where consultaID = " + consulta.getCodConsulta();
            sql += "update Consulta set paciente = " + consulta.getPaciente() + " where consultaID = " + consulta.getCodConsulta();
            sql += "update Consulta set data = " + consulta.getData() + " where consultaID = " + consulta.getCodConsulta();
            sql += "update Consulta set hora = " + consulta.getHora() + " where consultaID = " + consulta.getCodConsulta();
//            sql += "update Consulta set especializacaoMedica = " + consulta.getEspecializacaoMedica() + "where consultaID = " + consulta.getCodConsulta();
            sql += "update Consulta set endereco = " + consulta.getEndereco() + "where consultaID = " + consulta.getCodConsulta();
            this.stmt = con.prepareStatement(sql);
            this.stmt.executeUpdate(sql);

            return true; 
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /* Deleta uma consulta do banco de dados */
    public boolean deleteConsulta(int id){
        try {
            String sql = "delete from Consulta where consultaID = " + id + ";";
            this.stmt = con.prepareStatement(sql);
            this.stmt.executeUpdate(sql);

            return true;
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
