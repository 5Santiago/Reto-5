
package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.vo.Informe1;
import util.Conexion;

public class Informe1dao {
    
     public List<Informe1> listar() throws SQLException {
        ArrayList<Informe1> respuesta = new ArrayList<Informe1>();
        Connection conn = Conexion.getConnection();
        Statement stmt1 = null;
        ResultSet rset = null;
        String consulta = "SELECT ID_Lider, Nombre, Primer_Apellido, "
                + "Ciudad_Residencia FROM Lider ORDER BY Ciudad_Residencia ASC;";
        try {
            stmt1 = conn.createStatement();
            rset = stmt1.executeQuery(consulta);
            while (rset.next()) {
                Informe1 vo = new Informe1();
                vo.setId(rset.getInt("ID_Lider"));
                vo.setNombre(rset.getString("Nombre"));
                vo.setPrimerapellido(rset.getString("Primer_Apellido"));
                vo.setCiudad(rset.getString("Ciudad_Residencia"));
                respuesta.add(vo);
            }
        } finally {
            if (rset != null) {
                rset.close();
            }
            if (stmt1 != null) {
                stmt1.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return respuesta;
    }
    
}
