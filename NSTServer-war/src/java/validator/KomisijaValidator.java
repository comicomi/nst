/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package validator;

import domen.Komisija;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author MilicaJelica
 */
public class KomisijaValidator{

    public static void validujKomisiju(List<Komisija> komisija) throws ValidatorException {
        int mentor = 0;
        for (Komisija clan : komisija) {
            if(clan.getSifraUloge().getNaziv().equals("mentor")) mentor++;
        }
        if(mentor!=1) throw  new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Samo jedan član komisije može biti mentor.", null));
    }
    
}
