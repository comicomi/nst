/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mb;

import domen.Grad;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import pl.Kontroler;

/**
 *
 * @author MilicaJelica
 */
@Named(value = "gradMB")
@RequestScoped
public class GradMB {
    
    @EJB
    Kontroler kont;

    /**
     * Creates a new instance of TitulaMB
     */
    public GradMB() {
    }
    
    public List<Grad> vratiGradove(){
        return kont.vratiGradove();
    }
    
}
