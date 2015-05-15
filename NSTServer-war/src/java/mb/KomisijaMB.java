/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import domen.Komisija;
import domen.KomisijaPK;
import domen.Zaposleni;
import domen.Zavrsnirad;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DualListModel;
import pl.Kontroler;
import validator.KomisijaValidator;

/**
 *
 * @author MilicaJelica
 */
@Named(value = "komisijaMB")
@SessionScoped
public class KomisijaMB implements Serializable {

    @EJB
    Kontroler kont;
    List<Komisija> listaClanovaKomisije;
    //Zavrsnirad zr;

    DualListModel<Zaposleni> zaposleniPL;

    /**
     * Creates a new instance of KomisijaMB
     */
    public KomisijaMB() {
        listaClanovaKomisije = new ArrayList<Komisija>();
    }

    @PostConstruct
    public void napuniPickList() {
        List<Zaposleni> sviZaposleni = kont.vratiZaposlene();
        List<Zaposleni> zaposleniUKomisiji = new ArrayList<>();
        zaposleniPL = new DualListModel<>(sviZaposleni, zaposleniUKomisiji);
    }

    public DualListModel<Zaposleni> getZaposleniPL() {
        return zaposleniPL;
    }

    public void setZaposleniPL(DualListModel<Zaposleni> zaposleniPL) {
        this.zaposleniPL = zaposleniPL;
    }

    public List<Komisija> getListaClanovaKomisije() {
        return listaClanovaKomisije;
    }

    public void setListaClanovaKomisije(List<Komisija> listaClanovaKomisije) {
        this.listaClanovaKomisije = listaClanovaKomisije;
    }

    public void ubaciZaposleneUKomisiju() {
        listaClanovaKomisije.clear();
        for (Zaposleni zaposleni : zaposleniPL.getTarget()) {
            Komisija komisija = new Komisija();
            komisija.setZaposleni(zaposleni);
            listaClanovaKomisije.add(komisija);
        }
    }

    public void sacuvajKomisiju(Zavrsnirad zavrsnirad) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            KomisijaValidator.validujKomisiju(listaClanovaKomisije);

            for (Komisija komisija : listaClanovaKomisije) {
                komisija.setKomisijaPK(new KomisijaPK(zavrsnirad.getSifraZavrsnogRada(), komisija.getZaposleni().getSifraZaposlenog()));
                komisija.setZavrsnirad(zavrsnirad);
            }
            zavrsnirad.setKomisijaList(listaClanovaKomisije);
            kont.sacuvajKomisiju(listaClanovaKomisije);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sistem je sačuvao komisiju.", null));
            RequestContext.getCurrentInstance().execute("komisija.hide()");
        } catch (ValidatorException e) {
            context.addMessage(null, e.getFacesMessage());
        }
    }

    public void postaviKomisiju(Zavrsnirad zr) {
        listaClanovaKomisije = zr.getKomisijaList();
        zaposleniPL.getTarget().clear();
        for (Komisija clanKomisije : listaClanovaKomisije) {
            Zaposleni zaposleni = clanKomisije.getZaposleni();
            zaposleniPL.getTarget().add(zaposleni);
            zaposleniPL.getSource().remove(zaposleni);
        }
        RequestContext.getCurrentInstance().execute("komisija.show()");
    }
}
