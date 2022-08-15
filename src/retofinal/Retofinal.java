
package retofinal;

import controller.Controller;
import modelo.dao.Informe1dao;
import modelo.dao.Informe2dao;
import modelo.dao.Informe3dao;
import view.Vista;


public class Retofinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Informe1dao model1 = new Informe1dao();
        Informe2dao model2 = new Informe2dao();
        Informe3dao model3 = new Informe3dao();
        Vista vista = new Vista();
        
        Controller controller = new Controller(vista,model1,model2,model3);
        controller.inicio();
        vista.setVisible(true);
    }
    
}
