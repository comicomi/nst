/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package konverter;


import domen.Zavrsnirad;
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
@FacesConverter(forClass = ZRKonverter.class, value = "zRKonverter")
public class ZRKonverter implements Converter{

    @EJB
    Kontroler kont;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        int sifraZR=Integer.parseInt(value);
        return kont.vratiZavrsniRad(sifraZR);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Zavrsnirad zr = (Zavrsnirad) value;
        return zr.getSifraZavrsnogRada()+"";
    }
    
}
