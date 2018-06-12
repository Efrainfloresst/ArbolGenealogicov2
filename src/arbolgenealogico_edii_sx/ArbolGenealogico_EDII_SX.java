/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolgenealogico_edii_sx;

/**
 *
 * @author USUARIO
 */

import Modelo.ArbolGenealogico;
public class ArbolGenealogico_EDII_SX {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArbolGenealogico arbolGn=new ArbolGenealogico("Andres","Maria");
        //arbolGn.addHombreOrigen("Andres");
        //arbolGn.addEsposa("Andres","Maria");
        //arbolGn.addEsposa("Andres", "Pepita");
        arbolGn.addHijoPorPadre("Andres", "Andres Jr");
        arbolGn.addEsposa("Andres Jr", "Roberta");
        arbolGn.addHijoPorMadre("Maria","Martin");
        arbolGn.addHijoPorMadre("Maria", "Pedro");
        arbolGn.addHijoPorPadre("Andres Jr","Raul Jr");
        
        
        
        System.out.println(arbolGn.recorridoPorNiveles()); // arreglar
    }
    
}
