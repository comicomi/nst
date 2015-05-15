/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sb.grad;

import domen.Grad;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author MilicaJelica
 */
@Stateless
public class GradSB implements GradSBLocal {
    
    @PersistenceContext(unitName = "NSTServer-ejbPU")
    private EntityManager em;

    @Override
    public List<Grad> vratiGradove() {
        return em.createNamedQuery("Grad.findAll").getResultList();
    }

    @Override
    public Grad vratiGrad(int ptt) {
        return em.find(Grad.class, ptt);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
