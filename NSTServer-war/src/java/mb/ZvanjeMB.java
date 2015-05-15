/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mb;

import domen.Zvanje;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import pl.Kontroler;

/**
 *
 * @author MilicaJelica
 */
@Named(value = "zvanjeMB")
@RequestScoped
public class ZvanjeMB {
    
    @EJB
    Kontroler kont;

    /**
     * Creates a new instance of TitulaMB
     */
    public ZvanjeMB() {
    }
    
    public List<Zvanje> vratiZvanja(){
        return kont.vratiZvanja();
    }
    
}
