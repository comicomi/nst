/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package konverter;


import domen.Titula;
import domen.Zvanje;
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
@FacesConverter(forClass = ZvanjeKonverter.class, value = "zvanjeKonverter")
public class ZvanjeKonverter implements Converter{

    @EJB
    Kontroler kont;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        int sifraZvanja=Integer.parseInt(value);
        return kont.vratiZvanje(sifraZvanja);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Zvanje zvanje = (Zvanje) value;
        return String.valueOf(zvanje.getSifraZvanja());
    }
    
}
