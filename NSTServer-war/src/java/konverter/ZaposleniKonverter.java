/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package konverter;

import domen.Zaposleni;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import pl.Kontroler;

/**
 *
 * @author MilicaJelica
 */
@FacesConverter(forClass = Zaposleni.class, value = "zaposleniKonverter")
public class ZaposleniKonverter implements Converter{

    @EJB
    Kontroler kont;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        int id=Integer.parseInt(value);
        return kont.vratiZaposlenog(id);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Zaposleni z= (Zaposleni) value;
        return z.getSifraZaposlenog()+"";
    }
    
}
