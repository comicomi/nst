/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mb;

import domen.Tipzavrsnograda;
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
@ManagedBean(name = "tipZRMB")
@RequestScoped
public class TipZRMB implements Serializable{

    @EJB
    Kontroler kont;
    /**
     * Creates a new instance of TipZRMB
     */
    public TipZRMB() {
    }
    

    public List<Tipzavrsnograda> vratiTipoveZR(){
        return kont.vratiTipoveZR();
    }
}
