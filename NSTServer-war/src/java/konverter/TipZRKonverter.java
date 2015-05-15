/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package konverter;

import domen.Tipzavrsnograda;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import pl.Kontroler;
import sb.zr.tip.TipZRSB;
import sb.zr.tip.TipZRSBLocal;

/**
 *
 * @author MilicaJelica
 */
@FacesConverter(forClass = TipZRKonverter.class, value = "tipZRKonverter")
public class TipZRKonverter implements Converter{

    @EJB
    Kontroler kont;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        int sifraTipaZR=Integer.parseInt(value);
        return kont.vratiTipZavrsnogRada(sifraTipaZR);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Tipzavrsnograda tip=(Tipzavrsnograda) value;
        return String.valueOf(tip.getSifraTipaZavrsnogRada());
    }
    
}
