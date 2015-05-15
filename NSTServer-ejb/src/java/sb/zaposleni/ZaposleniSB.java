/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sb.zaposleni;

import domen.Zaposleni;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author MilicaJelica
 */
@Stateless
public class ZaposleniSB implements ZaposleniSBLocal {
    
    @PersistenceContext(unitName = "NSTServer-ejbPU")
    private EntityManager em;

    @Override
    public void sacuvajZaposlenog(Zaposleni zaposleni) {
        Zaposleni z = null;
        if(zaposleni.getSifraZaposlenog()!=null && zaposleni.getSifraZaposlenog()!=0 ) 
            z = em.find(Zaposleni.class, zaposleni.getSifraZaposlenog());
        if (z != null) {
            em.merge(zaposleni);
        } else {
            em.persist(zaposleni);
        }        
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<Zaposleni> vratiZaposlene() {
        return em.createNamedQuery("Zaposleni.findAll").getResultList(); 
    }

    @Override
    public Zaposleni vratiZaposlenog(int id) {
        return em.find(Zaposleni.class, id);
    }

    @Override
    public Zaposleni login(Zaposleni zaposleni) {
       return  (Zaposleni) em.createNamedQuery("Zaposleni.login").setParameter("korisnickaSifra", zaposleni.getKorisnickaSifra()).setParameter("korisnickoIme", zaposleni.getKorisnickoIme()).getSingleResult();
    }
    
   
}
