/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sb.tutila;

import domen.Titula;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MilicaJelica
 */
@Local
public interface TitulaSBLocal {
    
    public List<Titula> vratiTitule();

    public Titula vratiTitulu(int sifraTitule);
    
}
