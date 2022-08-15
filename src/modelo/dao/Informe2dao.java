
package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.vo.Informe2;
import util.Conexion;

public class Informe2dao {
    
     public List<Informe2> listar2() throws SQLException {
        ArrayList<Informe2> respuesta = new ArrayList<Informe2>();
        Connection conn = Conexion.getConnection();
        Statement stmt2 = null;
        ResultSet rset = null;
        String consulta = "SELECT ID_Proyecto,Constructora,Numero_Habitaciones,"
                + "Ciudad FROM Proyecto WHERE Clasificacion = 'Casa Campestre' "
                + "AND Ciudad IN ('Barranquilla', 'Santa Marta', 'Cartagena') ";
        try {
            stmt2 = conn.createStatement();
            rset = stmt2.executeQuery(consulta);
            while (rset.next()) {
                Informe2 vo = new Informe2();
                vo.setID(rset.getInt("ID_Proyecto"));
                vo.setConstructora(rset.getString("Constructora"));
                vo.setNumeroHabitaciones(rset.getInt("Numero_Habitaciones"));
                vo.setCiudad(rset.getString("Ciudad"));
                respuesta.add(vo);
            }
        } finally {
            if (rset != null) {
                rset.close();
            }
            if (stmt2 != null) {
                stmt2.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return respuesta;
    }
}
