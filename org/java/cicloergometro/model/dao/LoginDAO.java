/* LoginDAO.java: Classe usada para verificar login e senha dos usuários
 * do sistema
 * 
 * Desenvolvido por Gustavo Bacagine <gustavo.bacagine@protonmail.com>
 * 
 * Data da última modificação: 17/06/2022
 */

package org.java.cicloergometro.model.dao;

import org.java.cicloergometro.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LoginDAO{
    private Connection con = ConnectionFactory.getConnection();
    private Statement stmt = null;
    private ResultSet rs = null;

    /* Este metodo  foi baseado nos artigo a seguir:
     * https://pt.stackoverflow.com/questions/390863/valida%C3%A7%C3%A3o-de-dados-login-senha 
     * https://stackoverflow.com/questions/69715378/java-sql-sqlexception-operation-not-allowed-for-a-result-set-of-type-resultset */
    public boolean verificaLogin(String tipoUsuario, String login, String password){
        String sql = "select * from " + tipoUsuario + " where login = '" + login + "';";
        try {
            //this.stmt = this.con.prepareStatement(sql);
            this.stmt = this.con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            this.rs = this.stmt.executeQuery(sql);
            if(this.rs.first()){
                if(this.rs.getString("passwd").equals(password)){
                    return true;
                }
            }
            return false;
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
