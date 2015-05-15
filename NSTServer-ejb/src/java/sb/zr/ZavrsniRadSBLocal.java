/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sb.zr;

import domen.Kandidat;
import domen.Zavrsnirad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MilicaJelica
 */
@Local
public interface ZavrsniRadSBLocal {

    void sacuvajZavrsniRad(Zavrsnirad zavrsniRad);

    List<Zavrsnirad> vratiZavrsneRadove();

    Zavrsnirad vratiZavrsniRad(int id);
    
    int uzmiTekucuSifru();

    void azurirajTekucuSifru(int tekucaSifraZR);

    public long vratiMinGodinu();
    
    public long vratiMaxGodinu();
    
    public List<Kandidat> vratiKandidateZaGodinu(long godina, int sifraTipaZR);
}
