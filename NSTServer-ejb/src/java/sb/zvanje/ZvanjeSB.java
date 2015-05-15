/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sb.zvanje;

import domen.Zvanje;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author MilicaJelica
 */
@Stateless
public class ZvanjeSB implements ZvanjeSBLocal {
    
    @PersistenceContext(unitName = "NSTServer-ejbPU")
    private EntityManager em;

    @Override
    public List<Zvanje> vratiZvanja() {
         return em.createNamedQuery("Zvanje.findAll").getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Object vratiZvanje(int sifraZvanja) {
        return em.find(Zvanje.class, sifraZvanja);
    }
}
