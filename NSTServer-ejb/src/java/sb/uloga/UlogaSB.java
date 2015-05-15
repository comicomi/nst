/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sb.uloga;

import domen.Ulogaclanakomisije;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author MilicaJelica
 */
@Stateless
public class UlogaSB implements UlogaSBLocal {
    
    @PersistenceContext(unitName = "NSTServer-ejbPU")
    private EntityManager em;
    
    @Override
    public List<Ulogaclanakomisije> vratiUloge() {
        return em.createNamedQuery("Ulogaclanakomisije.findAll").getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Ulogaclanakomisije vratiUlogu(int sifraUloge) {
        return em.find(Ulogaclanakomisije.class, sifraUloge);
    }
}
