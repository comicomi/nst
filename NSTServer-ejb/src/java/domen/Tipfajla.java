/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domen;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author MilicaJelica
 */
@Entity
@Table(name = "tipfajla")
@NamedQueries({
    @NamedQuery(name = "Tipfajla.findAll", query = "SELECT t FROM Tipfajla t"),
    @NamedQuery(name = "Tipfajla.findBySifraTipaFajla", query = "SELECT t FROM Tipfajla t WHERE t.sifraTipaFajla = :sifraTipaFajla"),
    @NamedQuery(name = "Tipfajla.findByNaziv", query = "SELECT t FROM Tipfajla t WHERE t.naziv = :naziv"),
    @NamedQuery(name = "Tipfajla.findByExtenzija", query = "SELECT t FROM Tipfajla t WHERE t.extenzija = :extenzija")})
public class Tipfajla implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "sifraTipaFajla")
    private Integer sifraTipaFajla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "naziv")
    private String naziv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "extenzija")
    private String extenzija;
    @OneToMany(mappedBy = "sifraTipaFajla")
    private List<Fajl> fajlList;

    public Tipfajla() {
    }

    public Tipfajla(Integer sifraTipaFajla) {
        this.sifraTipaFajla = sifraTipaFajla;
    }

    public Tipfajla(Integer sifraTipaFajla, String naziv, String extenzija) {
        this.sifraTipaFajla = sifraTipaFajla;
        this.naziv = naziv;
        this.extenzija = extenzija;
    }

    public Integer getSifraTipaFajla() {
        return sifraTipaFajla;
    }

    public void setSifraTipaFajla(Integer sifraTipaFajla) {
        this.sifraTipaFajla = sifraTipaFajla;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getExtenzija() {
        return extenzija;
    }

    public void setExtenzija(String extenzija) {
        this.extenzija = extenzija;
    }

    public List<Fajl> getFajlList() {
        return fajlList;
    }

    public void setFajlList(List<Fajl> fajlList) {
        this.fajlList = fajlList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sifraTipaFajla != null ? sifraTipaFajla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipfajla)) {
            return false;
        }
        Tipfajla other = (Tipfajla) object;
        if ((this.sifraTipaFajla == null && other.sifraTipaFajla != null) || (this.sifraTipaFajla != null && !this.sifraTipaFajla.equals(other.sifraTipaFajla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Tipfajla[ sifraTipaFajla=" + sifraTipaFajla + " ]";
    }
    
}
