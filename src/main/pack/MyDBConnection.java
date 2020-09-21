/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.pack;

import java.sql.*;

/**
 *
 * @author arisp
 */
public class MyDBConnection {
    private Connection myConnection;
    static final String DB_URL = "jdbc:mysql://localhost/private_school?serverTimezone=UTC";
    static final String DB_USER = "root";
    static final String DB_PASSWD = "1234";
    private Statement stmt = null;
    private PreparedStatement prStmt = null;
    
    public void init()  {
        try {
            if (myConnection == null) {
                myConnection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            }
        }
        catch(SQLException e){
            System.out.println("Failed to connect");
            e.printStackTrace();
        } finally {
            System.out.println("Connection initiated.");
        }
        
    }

    
    public Connection getMyConnection() {
        return myConnection;
    }

    public Statement getMyStatement() {
        try {
            stmt = myConnection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stmt;
    }

    public PreparedStatement getMyPrepStatement(String query) {
        try {
            prStmt = myConnection.prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prStmt;
    }
    
    public void close(ResultSet rs) {
        if(rs != null) {
            try{
                rs.close();
            }
            catch(SQLException e){
                e.printStackTrace();
            }

        }
    }
    
    public void close (Statement stmt) {
        if (stmt != null){
            try{
                stmt.close();
            }
            catch(SQLException e){
                e.printStackTrace();
            }
            
        }
    }
    
    public void destroy(){
        if (myConnection != null){
            try{
                myConnection.close();
                System.out.println("Connection successfully closed.");
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
    }


    
}

