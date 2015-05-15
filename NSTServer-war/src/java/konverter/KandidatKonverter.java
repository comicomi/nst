/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package konverter;

import domen.Kandidat;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import pl.Kontroler;
import sb.kandidat.KandidatSB;
import sb.kandidat.KandidatSBLocal;

/**
 *
 * @author MilicaJelica
 */
@FacesConverter(forClass = Kandidat.class, value = "kandidatKonverter")
public class KandidatKonverter implements Converter{
    @EJB
    Kontroler kont;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return kont.vratiKandidata(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Kandidat kandidat=(Kandidat) value;
        return kandidat.getBrojIndexa();
    }
    
}
