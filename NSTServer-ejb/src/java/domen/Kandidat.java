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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "kandidat")
@NamedQueries({
    @NamedQuery(name = "Kandidat.findAll", query = "SELECT k FROM Kandidat k"),
    @NamedQuery(name = "Kandidat.findByBrojIndexa", query = "SELECT k FROM Kandidat k WHERE k.brojIndexa = :brojIndexa"),
    @NamedQuery(name = "Kandidat.findByIme", query = "SELECT k FROM Kandidat k WHERE k.ime = :ime"),
    @NamedQuery(name = "Kandidat.findByPrezime", query = "SELECT k FROM Kandidat k WHERE k.prezime = :prezime"),
    @NamedQuery(name = "Kandidat.findByPol", query = "SELECT k FROM Kandidat k WHERE k.pol = :pol"),
    @NamedQuery(name = "Kandidat.findByBrojTelefona", query = "SELECT k FROM Kandidat k WHERE k.brojTelefona = :brojTelefona"),
    @NamedQuery(name = "Kandidat.findByMejl", query = "SELECT k FROM Kandidat k WHERE k.mejl = :mejl"),
    @NamedQuery(name = "Kandidat.findByAdresa", query = "SELECT k FROM Kandidat k WHERE k.adresa = :adresa")})
public class Kandidat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "brojIndexa")
    private String brojIndexa;
    @Size(max = 20)
    @Column(name = "ime")
    private String ime;
    @Size(max = 30)
    @Column(name = "prezime")
    private String prezime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pol")
    private boolean pol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "brojTelefona")
    private String brojTelefona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "mejl")
    private String mejl;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "adresa")
    private String adresa;
    @JoinColumn(name = "ptt", referencedColumnName = "ptt")
    @ManyToOne(optional = false)
    private Grad ptt;
    @OneToMany(mappedBy = "brojIndexa")
    private List<Zavrsnirad> zavrsniradList;

    public Kandidat() {
    }

    public Kandidat(String brojIndexa) {
        this.brojIndexa = brojIndexa;
    }

    public Kandidat(String brojIndexa, boolean pol, String brojTelefona, String mejl, String adresa) {
        this.brojIndexa = brojIndexa;
        this.pol = pol;
        this.brojTelefona = brojTelefona;
        this.mejl = mejl;
        this.adresa = adresa;
    }

    public String getBrojIndexa() {
        return brojIndexa;
    }

    public void setBrojIndexa(String brojIndexa) {
        this.brojIndexa = brojIndexa;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public boolean getPol() {
        return pol;
    }

    public void setPol(boolean pol) {
        this.pol = pol;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getMejl() {
        return mejl;
    }

    public void setMejl(String mejl) {
        this.mejl = mejl;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Grad getPtt() {
        return ptt;
    }

    public void setPtt(Grad ptt) {
        this.ptt = ptt;
    }

    public List<Zavrsnirad> getZavrsniradList() {
        return zavrsniradList;
    }

    public void setZavrsniradList(List<Zavrsnirad> zavrsniradList) {
        this.zavrsniradList = zavrsniradList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (brojIndexa != null ? brojIndexa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kandidat)) {
            return false;
        }
        Kandidat other = (Kandidat) object;
        if ((this.brojIndexa == null && other.brojIndexa != null) || (this.brojIndexa != null && !this.brojIndexa.equals(other.brojIndexa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ime+" "+prezime+" "+brojIndexa;
    }
    
}
