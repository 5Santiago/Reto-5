
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection getConnection() throws SQLException{
        Connection Conexion = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Conexion= DriverManager.getConnection("jdbc:mariadb://localhost:3306/proyectosconstruccion","root","asdfg");
        } catch ( Exception e) {
            System.out.println("Error"+e);
        }
         return Conexion;
            
            
        }
}
