package Funciones;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MyConnection {
    
     public static Connection getConnection() {
    Connection con = null;
    
    
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Data_Base","root","1D0n7G37D0wn");
    }
    
    catch (ClassNotFoundException | SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return con;
    
    }
    
}
