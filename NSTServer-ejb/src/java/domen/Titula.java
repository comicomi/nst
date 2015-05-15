/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domen;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "titula")
@NamedQueries({
    @NamedQuery(name = "Titula.findAll", query = "SELECT t FROM Titula t"),
    @NamedQuery(name = "Titula.findBySifraTitule", query = "SELECT t FROM Titula t WHERE t.sifraTitule = :sifraTitule"),
    @NamedQuery(name = "Titula.findByNaziv", query = "SELECT t FROM Titula t WHERE t.naziv = :naziv")})
public class Titula implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "sifraTitule")
    private Integer sifraTitule;
    @Size(max = 20)
    @Column(name = "naziv")
    private String naziv;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sifraTitule")
    private List<Zaposleni> zaposleniList;

    public Titula() {
    }

    public Titula(Integer sifraTitule) {
        this.sifraTitule = sifraTitule;
    }

    public Integer getSifraTitule() {
        return sifraTitule;
    }

    public void setSifraTitule(Integer sifraTitule) {
        this.sifraTitule = sifraTitule;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public List<Zaposleni> getZaposleniList() {
        return zaposleniList;
    }

    public void setZaposleniList(List<Zaposleni> zaposleniList) {
        this.zaposleniList = zaposleniList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sifraTitule != null ? sifraTitule.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Titula)) {
            return false;
        }
        Titula other = (Titula) object;
        if ((this.sifraTitule == null && other.sifraTitule != null) || (this.sifraTitule != null && !this.sifraTitule.equals(other.sifraTitule))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return naziv;
    }
    
}
