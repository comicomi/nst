/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mb;

import domen.Kandidat;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import pl.Kontroler;
/**
 *
 * @author MilicaJelica
 */
@ManagedBean (name = "kandidatMB")
@SessionScoped
public class KandidatMB implements Serializable{
  
    /**
     * Creates a new instance of KandidatMB
     */
    @EJB
    Kontroler kont;
 
    Kandidat kandidat;

    public Kandidat getKandidat() {
        return kandidat;
    }

    public void setKandidat(Kandidat kandidat) {
        this.kandidat = kandidat;
    }
    
    public KandidatMB() {
        kandidat=new Kandidat();
    }
    
    public List<Kandidat> vratiKandidate(){
        return kont.vratiKandidate();
    }
    
    public void sacuvaj(){
        FacesContext context = FacesContext.getCurrentInstance();
        try {            
            kont.sacuvajKandidata(kandidat);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sistem je kreirao novog kandidata.", null));
            kandidat = new Kandidat();
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Greška pri unosu kandidata.", null));
        }
    }
}
