/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domen;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author MilicaJelica
 */
@Embeddable
public class KomisijaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "sifraZavrsnogRada")
    private int sifraZavrsnogRada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sifraZaposlenog")
    private int sifraZaposlenog;

    public KomisijaPK() {
    }

    public KomisijaPK(int sifraZavrsnogRada, int sifraZaposlenog) {
        this.sifraZavrsnogRada = sifraZavrsnogRada;
        this.sifraZaposlenog = sifraZaposlenog;
    }

    public int getSifraZavrsnogRada() {
        return sifraZavrsnogRada;
    }

    public void setSifraZavrsnogRada(int sifraZavrsnogRada) {
        this.sifraZavrsnogRada = sifraZavrsnogRada;
    }

    public int getSifraZaposlenog() {
        return sifraZaposlenog;
    }

    public void setSifraZaposlenog(int sifraZaposlenog) {
        this.sifraZaposlenog = sifraZaposlenog;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) sifraZavrsnogRada;
        hash += (int) sifraZaposlenog;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KomisijaPK)) {
            return false;
        }
        KomisijaPK other = (KomisijaPK) object;
        if (this.sifraZavrsnogRada != other.sifraZavrsnogRada) {
            return false;
        }
        if (this.sifraZaposlenog != other.sifraZaposlenog) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.KomisijaPK[ sifraZavrsnogRada=" + sifraZavrsnogRada + ", sifraZaposlenog=" + sifraZaposlenog + " ]";
    }
    
}
