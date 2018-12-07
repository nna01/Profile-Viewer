
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arony
 */
public class myDBConnection {
    
    Connection conn;
    
    public Connection getCon(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/myinfo","root","");
            
        } catch (ClassNotFoundException | SQLException ex) {
            
            Logger.getLogger(myDBConnection.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return conn;
    
}
    
    
}
