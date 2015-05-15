/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sb.komisija;

import domen.Komisija;
import javax.ejb.Local;

/**
 *
 * @author MilicaJelica
 */
@Local
public interface KomisijaSBLocal {
    
    
    
    public void sacuvajKomisiju(Komisija komisija);    
    
    
}
