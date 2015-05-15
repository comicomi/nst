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
@Table(name = "grad")
@NamedQueries({
    @NamedQuery(name = "Grad.findAll", query = "SELECT g FROM Grad g"),
    @NamedQuery(name = "Grad.findByPtt", query = "SELECT g FROM Grad g WHERE g.ptt = :ptt"),
    @NamedQuery(name = "Grad.findByNaziv", query = "SELECT g FROM Grad g WHERE g.naziv = :naziv")})
public class Grad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ptt")
    private Integer ptt;
    @Size(max = 100)
    @Column(name = "naziv")
    private String naziv;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ptt")
    private List<Kandidat> kandidatList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ptt")
    private List<Zaposleni> zaposleniList;

    public Grad() {
    }

    public Grad(Integer ptt) {
        this.ptt = ptt;
    }

    public Integer getPtt() {
        return ptt;
    }

    public void setPtt(Integer ptt) {
        this.ptt = ptt;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public List<Kandidat> getKandidatList() {
        return kandidatList;
    }

    public void setKandidatList(List<Kandidat> kandidatList) {
        this.kandidatList = kandidatList;
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
        hash += (ptt != null ? ptt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grad)) {
            return false;
        }
        Grad other = (Grad) object;
        if ((this.ptt == null && other.ptt != null) || (this.ptt != null && !this.ptt.equals(other.ptt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return naziv;
    }
    
}
