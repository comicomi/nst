/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domen;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author MilicaJelica
 */
@Entity
@Table(name = "komisija")
@NamedQueries({
    @NamedQuery(name = "Komisija.findAll", query = "SELECT k FROM Komisija k"),
    @NamedQuery(name = "Komisija.findBySifraZavrsnogRada", query = "SELECT k FROM Komisija k WHERE k.komisijaPK.sifraZavrsnogRada = :sifraZavrsnogRada"),
    @NamedQuery(name = "Komisija.findBySifraZaposlenog", query = "SELECT k FROM Komisija k WHERE k.komisijaPK.sifraZaposlenog = :sifraZaposlenog")})
public class Komisija implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected KomisijaPK komisijaPK;
    @JoinColumn(name = "sifraZavrsnogRada", referencedColumnName = "sifraZavrsnogRada", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Zavrsnirad zavrsnirad;
    @JoinColumn(name = "sifraZaposlenog", referencedColumnName = "sifraZaposlenog", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Zaposleni zaposleni;
    @JoinColumn(name = "sifraUloge", referencedColumnName = "sifraUloge")
    @ManyToOne(optional = false)
    private Ulogaclanakomisije sifraUloge;

    public Komisija() {
    }

    public Komisija(KomisijaPK komisijaPK) {
        this.komisijaPK = komisijaPK;
    }

    public Komisija(int sifraZavrsnogRada, int sifraZaposlenog) {
        this.komisijaPK = new KomisijaPK(sifraZavrsnogRada, sifraZaposlenog);
    }

    public KomisijaPK getKomisijaPK() {
        return komisijaPK;
    }

    public void setKomisijaPK(KomisijaPK komisijaPK) {
        this.komisijaPK = komisijaPK;
    }

    public Zavrsnirad getZavrsnirad() {
        return zavrsnirad;
    }

    public void setZavrsnirad(Zavrsnirad zavrsnirad) {
        this.zavrsnirad = zavrsnirad;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    public Ulogaclanakomisije getSifraUloge() {
        return sifraUloge;
    }

    public void setSifraUloge(Ulogaclanakomisije sifraUloge) {
        this.sifraUloge = sifraUloge;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (komisijaPK != null ? komisijaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Komisija)) {
            return false;
        }
        Komisija other = (Komisija) object;
        if ((this.komisijaPK == null && other.komisijaPK != null) || (this.komisijaPK != null && !this.komisijaPK.equals(other.komisijaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Komisija[ komisijaPK=" + komisijaPK + " ]";
    }
}
