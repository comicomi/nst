/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mb;

import domen.Titula;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import pl.Kontroler;

/**
 *
 * @author MilicaJelica
 */
@Named(value = "titulaMB")
@RequestScoped
public class TitulaMB {
    
    @EJB
    Kontroler kont;

    /**
     * Creates a new instance of TitulaMB
     */
    public TitulaMB() {
    }
    
    public List<Titula> vratiTitule(){
        return kont.vratiTitule();
    }
    
}
