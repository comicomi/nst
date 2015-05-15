/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sb.komisija;

import domen.Komisija;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author MilicaJelica
 */
@Stateless
public class KomisijaSB implements KomisijaSBLocal {
    
    @PersistenceContext(unitName = "NSTServer-ejbPU")
    private EntityManager em;
    
    @Override
    public void sacuvajKomisiju(Komisija komisija) {
        Komisija k = em.find(Komisija.class, komisija.getKomisijaPK());
        if (k != null) {
            em.merge(komisija);
        } else {
            em.persist(komisija);
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
