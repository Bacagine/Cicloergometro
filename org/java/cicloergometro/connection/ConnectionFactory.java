/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.java.cicloergometro.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gustavo Bacagine
 */
public class ConnectionFactory {
    private static final String url = "jdbc:mysql://localhost:3306/cicloergometro?useTimezone=true&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String user = "root";
    private static final String password = "123";
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    
    public static Connection getConnection(){
        try{
            Class.forName(driver);
            
            return DriverManager.getConnection(url, user, password);
        }
        catch(ClassNotFoundException | SQLException e){
            //Logger.getLogger(ConnectionFactory.class.getName()).log(Level.server, null, e);
            throw new RuntimeException("Erro na conexao: ", e);
        }
    }
    
    public static void closeConnection(Connection con){
        try{
            if(con != null){
                con.close();
            }
        }
        catch(SQLException e){
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt){
        closeConnection(con);
        try{
            if(stmt != null){
                stmt.close();
            }
        }
        catch(SQLException e){
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        closeConnection(con, stmt);
        try{
            if(rs != null){
                rs.close();
            }
        }
        catch(SQLException e){
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
