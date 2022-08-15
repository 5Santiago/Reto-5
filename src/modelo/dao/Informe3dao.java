
package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.vo.Informe3;
import util.Conexion;



public class Informe3dao {
    
    public List<Informe3> listar3() throws SQLException {
        ArrayList<Informe3> respuesta = new ArrayList<Informe3>();
        Connection conn = Conexion.getConnection();
        Statement stmt3 = null;
        ResultSet rset = null;
        String consulta = "SELECT Y.ID_Compra,X.Constructora,X.Banco_Vinculado FROM "
                + "PRoyecto X JOIN Compra Y ON X.ID_Proyecto = Y.ID_Proyecto "
                + "WHERE Y.Proveedor = 'Homecenter' AND X.Ciudad = 'Salento'; ";
        try {
            stmt3 = conn.createStatement();
            rset = stmt3.executeQuery(consulta);
            while (rset.next()) {
                Informe3 vo = new Informe3();
                vo.setId(rset.getInt("ID_Compra"));
                vo.setConstructora(rset.getString("Constructora"));
                vo.setBanco(rset.getString("Banco_Vinculado"));
                respuesta.add(vo);
            }
        } finally {
            if (rset != null) {
                rset.close();
            }
            if (stmt3 != null) {
                stmt3.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return respuesta;
    }
    
}
