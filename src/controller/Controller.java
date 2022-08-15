
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.dao.Informe1dao;
import modelo.dao.Informe2dao;
import modelo.dao.Informe3dao;
import modelo.vo.Informe1;
import modelo.vo.Informe2;
import modelo.vo.Informe3;
import view.Vista;

public class Controller implements ActionListener{
    private Vista view;
    private Informe1dao Inf1;
    private Informe2dao Inf2;
    private Informe3dao Inf3;

    public Controller(Vista view, Informe1dao Inf1, Informe2dao Inf2, Informe3dao Inf3) {
        this.view = view;
        this.Inf1 = Inf1;
        this.Inf2 = Inf2;
        this.Inf3 = Inf3;
        this.view.btninforme1.addActionListener(this);
        this.view.btninforme2.addActionListener(this);
        this.view.btninfome3.addActionListener(this);
    }
    
    

   
    public void inicio(){
        view.setVisible(true);
        view.setTitle("Generador de informes");
    }
  
    
    
    @Override 
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == view.btninforme1){
            String[] titulo =new String[] {"ID","Nombre","Apellido","Ciudad Residencia"};
            view.mostrar.setColumnIdentifiers(titulo);
            view.mostrar.setNumRows(0);
            
            List<Informe1> Listado;
            try {
                Listado = Inf1.listar();
                Listado.forEach(stmt1 -> {
                    view.mostrar.addRow(new Object[] {
                        stmt1.getId(),
                        stmt1.getNombre(),
                        stmt1.getPrimerapellido(),
                        stmt1.getCiudad()
                    });
                });
            } 
            catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error en la consulta" + ex);
            }

        }
        if (e.getSource() == view.btninforme2){
            String[] titulo =new String[] {"ID","Constructora","Numero de habitaciones","Ciudad"};
            view.mostrar.setColumnIdentifiers(titulo);
            view.mostrar.setNumRows(0);
            
            List<Informe2> Listado;
            try {
                Listado = Inf2.listar2();
                Listado.forEach(stmt2 -> {
                    view.mostrar.addRow(new Object[] {
                        stmt2.getID(),
                        stmt2.getConstructora(),
                        stmt2.getNumeroHabitaciones(),
                        stmt2.getCiudad()
                    });
                });
            } 
            catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error en la consulta" + ex);
            }

        }
        
        if (e.getSource() == view.btninfome3){
            String[] titulo =new String[] {"ID","Constructora","Banco"};
            view.mostrar.setColumnIdentifiers(titulo);
            view.mostrar.setNumRows(0);
            
            List<Informe3> Listado;
            try {
                Listado = Inf3.listar3();
                Listado.forEach(stmt3 -> {
                    view.mostrar.addRow(new Object[] {
                        stmt3.getId(),
                        stmt3.getConstructora(),
                        stmt3.getBanco(),
                    });
                });
            } 
            catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error en la consulta" + ex);
            }

        }
        
        
    }
     
    
}
