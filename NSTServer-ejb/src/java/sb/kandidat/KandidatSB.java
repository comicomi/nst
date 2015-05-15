/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sb.kandidat;

import domen.Kandidat;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author MilicaJelica
 */
@Stateless
public class KandidatSB implements KandidatSBLocal {
    
    @PersistenceContext(unitName = "NSTServer-ejbPU")
    private EntityManager em;

    @Override
    public void sacuvajKandidata(Kandidat kandidat) {
        Kandidat k = em.find(Kandidat.class, kandidat.getBrojIndexa());
        if (k != null) {
            em.merge(kandidat);
        } else {
            em.persist(kandidat);
        }
    }

    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<Kandidat> vratiKandidate() {
        return em.createNamedQuery("Kandidat.findAll").getResultList();
    }

    @Override
    public Kandidat vratiKandidata(String brInd) {        
        return em.find(Kandidat.class, brInd);
    }
}
