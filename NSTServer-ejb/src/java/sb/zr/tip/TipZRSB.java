/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sb.zr.tip;

import domen.Tipzavrsnograda;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author MilicaJelica
 */
@Stateless
public class TipZRSB implements TipZRSBLocal {

    
    @PersistenceContext(unitName = "NSTServer-ejbPU")
    private EntityManager em;
    
    @Override
    public List<Tipzavrsnograda> vratiTipoveZR() {
        return em.createNamedQuery("Tipzavrsnograda.findAll").getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Tipzavrsnograda vratiTipZR(int sifraTipaZR) {
        return em.find(Tipzavrsnograda.class, sifraTipaZR);
    }
    
}
