/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mb;

import domen.Ulogaclanakomisije;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import pl.Kontroler;

/**
 *
 * @author MilicaJelica
 */
@ManagedBean(name = "ulogaMB")
@RequestScoped
public class UlogaMB implements Serializable{

    @EJB
    Kontroler kont;
    /**
     * Creates a new instance of TipZRMB
     */
    public UlogaMB() {
    }

    public List<Ulogaclanakomisije> vratiUloge(){
        return kont.vratiUloge();
    }
}
