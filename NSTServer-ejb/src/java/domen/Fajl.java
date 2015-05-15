/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domen;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author MilicaJelica
 */
@Entity
@Table(name = "fajl")
@NamedQueries({
    @NamedQuery(name = "Fajl.findAll", query = "SELECT f FROM Fajl f"),
    @NamedQuery(name = "Fajl.findBySifraFajla", query = "SELECT f FROM Fajl f WHERE f.sifraFajla = :sifraFajla"),
    @NamedQuery(name = "Fajl.findByRb", query = "SELECT f FROM Fajl f WHERE f.rb = :rb"),
    @NamedQuery(name = "Fajl.findByNaziv", query = "SELECT f FROM Fajl f WHERE f.naziv = :naziv"),
    @NamedQuery(name = "Fajl.findByPutanja", query = "SELECT f FROM Fajl f WHERE f.putanja = :putanja"),
    @NamedQuery(name = "Fajl.findByVelicina", query = "SELECT f FROM Fajl f WHERE f.velicina = :velicina")})
public class Fajl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sifraFajla")
    private Integer sifraFajla;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rb")
    private int rb;
    @Size(max = 100)
    @Column(name = "naziv")
    private String naziv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "putanja")
    private String putanja;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "velicina")
    private String velicina;
    @JoinColumn(name = "sifraZavrsnogRada", referencedColumnName = "sifraZavrsnogRada")
    @ManyToOne(optional = false)
    private Zavrsnirad sifraZavrsnogRada;
    @JoinColumn(name = "sifraTipaFajla", referencedColumnName = "sifraTipaFajla")
    @ManyToOne
    private Tipfajla sifraTipaFajla;

    public Fajl() {
    }

    public Fajl(Integer sifraFajla) {
        this.sifraFajla = sifraFajla;
    }

    public Fajl(Integer sifraFajla, int rb, String putanja, String velicina) {
        this.sifraFajla = sifraFajla;
        this.rb = rb;
        this.putanja = putanja;
        this.velicina = velicina;
    }

    public Integer getSifraFajla() {
        return sifraFajla;
    }

    public void setSifraFajla(Integer sifraFajla) {
        this.sifraFajla = sifraFajla;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getPutanja() {
        return putanja;
    }

    public void setPutanja(String putanja) {
        this.putanja = putanja;
    }

    public String getVelicina() {
        return velicina;
    }

    public void setVelicina(String velicina) {
        this.velicina = velicina;
    }

    public Zavrsnirad getSifraZavrsnogRada() {
        return sifraZavrsnogRada;
    }

    public void setSifraZavrsnogRada(Zavrsnirad sifraZavrsnogRada) {
        this.sifraZavrsnogRada = sifraZavrsnogRada;
    }

    public Tipfajla getSifraTipaFajla() {
        return sifraTipaFajla;
    }

    public void setSifraTipaFajla(Tipfajla sifraTipaFajla) {
        this.sifraTipaFajla = sifraTipaFajla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sifraFajla != null ? sifraFajla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fajl)) {
            return false;
        }
        Fajl other = (Fajl) object;
        if ((this.sifraFajla == null && other.sifraFajla != null) || (this.sifraFajla != null && !this.sifraFajla.equals(other.sifraFajla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return naziv;
    }
    
}
