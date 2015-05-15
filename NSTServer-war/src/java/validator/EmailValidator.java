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
@FacesValidator("emailValidator")
public class EmailValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
       String email = (String) value;
           if(email.indexOf("@")==-1 || email.indexOf(".")==-1) throw  new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nevalidan unos e-mail adrese.", null));
    }
    
}
