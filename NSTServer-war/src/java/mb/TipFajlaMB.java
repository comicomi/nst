/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mb;

import domen.Tipfajla;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pl.Kontroler;

/**
 *
 * @author MilicaJelica
 */
@ManagedBean(name = "tipFajlaMB")
@SessionScoped
public class TipFajlaMB implements Serializable{

    @EJB
    Kontroler kont;
    /**
     * Creates a new instance of TipFajlaMB
     */
    public TipFajlaMB() {
        
    }
    
    public List<Tipfajla> vratiTipoveFajla(){
        return kont.vratiTipoveFajla();
    }
}
