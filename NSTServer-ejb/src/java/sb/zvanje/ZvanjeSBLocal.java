/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sb.zvanje;

import domen.Zvanje;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MilicaJelica
 */
@Local
public interface ZvanjeSBLocal {
 
    public List<Zvanje> vratiZvanja();

    public Object vratiZvanje(int sifraZvanja);
    
}
