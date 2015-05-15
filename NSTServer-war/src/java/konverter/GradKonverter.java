/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package konverter;


import domen.Grad;
import domen.Titula;
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
@FacesConverter(forClass = GradKonverter.class, value = "gradKonverter")
public class GradKonverter implements Converter{

    @EJB
    Kontroler kont;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        int ptt=Integer.parseInt(value);
        return kont.vratiGrad(ptt);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Grad grad = (Grad) value;
        return String.valueOf(grad.getPtt());
    }
    
}
