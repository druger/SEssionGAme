/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DataBase {

    public static void main(String[] args) {
        
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            Class.forName("org.h2.Driver");
            // установка соединения
            conn = DriverManager.getConnection("jdbc:h2:file://c:\\Users\\druger\\test\\testbase","admin","");
            
            // создание statement (для возвращения результатов SQL запроса, обработки)                    
            stmt = conn.createStatement();                    
           
                        
            // выполнение запроса               
            rs = stmt.executeQuery("select * from QUESTIONS");
            
            while (rs.next()) {
                System.out.println("Предмет = " + rs.getString("subject")+", вопрос = " + rs.getString("question")+", Варианты ответов: 1. = " + rs.getString("answer1")+", 2. = " + rs.getString("answer2")+", 3. = " + rs.getString("answer3"));          
            }
            
        
        
        
        
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        } finally {            
                try {
                    if (rs != null) rs.close();
                    if (stmt != null) stmt.close();
                    if (conn != null) conn.close();
                    
                    
                } catch (SQLException ex) {
                    Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }        
    }    
}
