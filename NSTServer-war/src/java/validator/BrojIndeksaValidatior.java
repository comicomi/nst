/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author MilicaJelica
 */
@FacesValidator("brojIndeksaValidator")
public class BrojIndeksaValidatior implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String brojIndeksa = (String) value;
           if(!(brojIndeksa.contains("/") && (brojIndeksa.indexOf('M')!=-1 || brojIndeksa.indexOf('I')!=-1))) throw  new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Pogrešan format indeksa. Broj indeksa unesite u formatu YYYY/BR sa obaveznom oznakom za smer na kraju, M ili I", null));
    }
    
   
    
}
