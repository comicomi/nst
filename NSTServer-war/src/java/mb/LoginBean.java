/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import domen.Zaposleni;
import java.io.Serializable;
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
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    /**
     * Creates a new instance of ZaposleniBean
     */
    private Zaposleni zaposleni;
    private boolean ulogovan;
    @EJB
    private Kontroler kont;

    public LoginBean() {
        zaposleni = new Zaposleni();
    }

    public boolean isUlogovan() {
        return ulogovan;
    }

    public void setUlogovan(boolean ulogovan) {
        this.ulogovan = ulogovan;

    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    public void login() {
        if (!ulogovan) {
            FacesMessage msg;
            try {
                Zaposleni z;
                z = (Zaposleni) kont.login(zaposleni);
                if (z != null) {
                    ulogovan = true;
                    zaposleni = z;
                    msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Zaposleni je uspešno prijavljen. Zdravo, " + z.getIme(), null);
                } else {
                    msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Pogrešno ste uneli korisničko ime ili korisnički šifru", null);
                }
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } catch (Exception ex) {
                msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sistem ne može da nađe zaposlenog na osnovu unetih vrednosti", null);
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        }
    }

    public String logout() {
        zaposleni = new Zaposleni();
        ulogovan = false;
        return "prikazZR.xhtml?faces-redirect=true";
    }

}
