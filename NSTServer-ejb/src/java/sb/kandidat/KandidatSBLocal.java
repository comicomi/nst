/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sb.kandidat;

import domen.Kandidat;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author MilicaJelica
 */
@Remote
public interface KandidatSBLocal {
    
    void sacuvajKandidata(Kandidat kandidat);

    List<Kandidat> vratiKandidate();

    Kandidat vratiKandidata(String brInd);
}
