/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sb.zr;

import domen.Kandidat;
import domen.Zavrsnirad;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author MilicaJelica
 */
@Stateless
public class ZavrsniRadSB implements ZavrsniRadSBLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "NSTServer-ejbPU")
    private EntityManager em;

    @Override
    public void sacuvajZavrsniRad(Zavrsnirad zavrsniRad) {
        Zavrsnirad zr = em.find(Zavrsnirad.class, zavrsniRad.getSifraZavrsnogRada());
        if (zr != null) {
            em.merge(zavrsniRad);
        } else {
            em.persist(zavrsniRad);
        }
    }

    @Override
    public List<Zavrsnirad> vratiZavrsneRadove() {
        return em.createNamedQuery("Zavrsnirad.findAll").getResultList();
    }

    @Override
    public Zavrsnirad vratiZavrsniRad(int id) {
        Zavrsnirad z=em.find(Zavrsnirad.class, id);
        return z;
    }

    @Override
    public int uzmiTekucuSifru() {
        return (int) em.createNativeQuery("SELECT sifraZavrsnogRada FROM sifarnik").getResultList().get(0);
    }

    @Override
    public void azurirajTekucuSifru(int tekucaSifraZR) {
        em.createNativeQuery("UPDATE sifarnik SET sifraZavrsnogRada = "+tekucaSifraZR).executeUpdate();
    }

    @Override
    public long vratiMinGodinu() {
        return (long) em.createNativeQuery("SELECT MIN(EXTRACT(YEAR FROM datumOdbrane)) FROM zavrsnirad").getResultList().get(0);
    }
    
    @Override
    public long vratiMaxGodinu() {
        return (long) em.createNativeQuery("SELECT MAX(EXTRACT(YEAR FROM datumOdbrane)) FROM zavrsnirad").getResultList().get(0);
    }
    
    @Override
    public List<Kandidat> vratiKandidateZaGodinu(long godina, int sifraTipaZR){
        return em.createNamedQuery("Zavrsnirad.findByGodinaOdbraneITipZR").setParameter("godinaOdbrane",godina).setParameter("sifraTipaZR",sifraTipaZR).getResultList();
    } 
    
   
}
