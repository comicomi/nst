/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sb.zaposleni;

import domen.Zaposleni;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MilicaJelica
 */
@Local
public interface ZaposleniSBLocal {
     List<Zaposleni> vratiZaposlene();
     void sacuvajZaposlenog(Zaposleni zaposleni);
     Zaposleni vratiZaposlenog (int id);
     Zaposleni login(Zaposleni zaposleni);
     
}
