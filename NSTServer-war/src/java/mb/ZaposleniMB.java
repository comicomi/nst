/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mb;

import domen.Zaposleni;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import pl.Kontroler;

/**
 *
 * @author MilicaJelica
 */
@Named(value = "zaposleniMB")
@RequestScoped
public class ZaposleniMB {

    @EJB
    Kontroler kont;
    Zaposleni zaposleni;
    
    /**
     * Creates a new instance of ZaposleniMB
     */
    public ZaposleniMB() {
        zaposleni = new Zaposleni();
    }
    
    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

   public List<Zaposleni> vratiZaposlene(){
        return kont.vratiZaposlene();
    }
   
   public void sacuvaj(){
       FacesContext context = FacesContext.getCurrentInstance();
        try {            
            kont.sacuvajZaposlenog(zaposleni);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sistem je kreirao novog zaposlenog.", null));
            zaposleni = new Zaposleni();
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Greška pri unosu zaposlenog.", null));
        }
   }

}
