/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sb.zr.fajl.tip;

import domen.Tipfajla;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MilicaJelica
 */
@Local
public interface TipFajlaSBLocal {

    public List<Tipfajla> vratiTipoveFajla();
    
}
