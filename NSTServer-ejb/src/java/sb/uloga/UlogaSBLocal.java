/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sb.uloga;

import domen.Ulogaclanakomisije;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MilicaJelica
 */
@Local
public interface UlogaSBLocal {
    
    public List<Ulogaclanakomisije> vratiUloge();

    public Ulogaclanakomisije vratiUlogu(int sifraUloge);
    
}
