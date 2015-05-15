/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author MilicaJelica
 */
@Entity
@Table(name = "zavrsnirad")
@NamedQueries({
    @NamedQuery(name = "Zavrsnirad.findAll", query = "SELECT z FROM Zavrsnirad z"),
    @NamedQuery(name = "Zavrsnirad.findBySifraZavrsnogRada", query = "SELECT z FROM Zavrsnirad z WHERE z.sifraZavrsnogRada = :sifraZavrsnogRada"),
    @NamedQuery(name = "Zavrsnirad.findByTema", query = "SELECT z FROM Zavrsnirad z WHERE z.tema = :tema"),
    @NamedQuery(name = "Zavrsnirad.findByDatumPrijave", query = "SELECT z FROM Zavrsnirad z WHERE z.datumPrijave = :datumPrijave"),
    @NamedQuery(name = "Zavrsnirad.findByDatumOdbrane", query = "SELECT z FROM Zavrsnirad z WHERE z.datumOdbrane = :datumOdbrane"),
    @NamedQuery(name = "Zavrsnirad.findByGodinaOdbraneITipZR", query = "SELECT DISTINCT z.brojIndexa FROM Zavrsnirad z WHERE FUNC('YEAR', z.datumOdbrane) = :godinaOdbrane AND z.sifraTipaZavrsnogRada.sifraTipaZavrsnogRada = :sifraTipaZR")})
public class Zavrsnirad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "sifraZavrsnogRada")
    private Integer sifraZavrsnogRada;
    @Size(max = 80)
    @Column(name = "tema")
    private String tema;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datumPrijave")
    @Temporal(TemporalType.DATE)
    private Date datumPrijave;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datumOdbrane")
    @Temporal(TemporalType.DATE)
    private Date datumOdbrane;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sifraZavrsnogRada")
    private List<Fajl> fajlList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zavrsnirad", orphanRemoval = true)
    private List<Komisija> komisijaList;
    @JoinColumn(name = "sifraTipaZavrsnogRada", referencedColumnName = "sifraTipaZavrsnogRada")
    @ManyToOne
    private Tipzavrsnograda sifraTipaZavrsnogRada;
    @JoinColumn(name = "brojIndexa", referencedColumnName = "brojIndexa")
    @ManyToOne
    private Kandidat brojIndexa;

    public Zavrsnirad() {
        fajlList = new ArrayList<>();
    }

    public Zavrsnirad(Integer sifraZavrsnogRada) {
        this.sifraZavrsnogRada = sifraZavrsnogRada;
    }

    public Zavrsnirad(Integer sifraZavrsnogRada, Date datumPrijave, Date datumOdbrane) {
        this.sifraZavrsnogRada = sifraZavrsnogRada;
        this.datumPrijave = datumPrijave;
        this.datumOdbrane = datumOdbrane;
    }

    public Integer getSifraZavrsnogRada() {
        return sifraZavrsnogRada;
    }

    public void setSifraZavrsnogRada(Integer sifraZavrsnogRada) {
        this.sifraZavrsnogRada = sifraZavrsnogRada;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Date getDatumPrijave() {
        return datumPrijave;
    }

    public void setDatumPrijave(Date datumPrijave) {
        this.datumPrijave = datumPrijave;
    }

    public Date getDatumOdbrane() {
        return datumOdbrane;
    }

    public void setDatumOdbrane(Date datumOdbrane) {
        this.datumOdbrane = datumOdbrane;
    }

    public List<Fajl> getFajlList() {
        return fajlList;
    }

    public void setFajlList(List<Fajl> fajlList) {
        this.fajlList = fajlList;
    }

    public List<Komisija> getKomisijaList() {
        return komisijaList;
    }

    public void setKomisijaList(List<Komisija> komisijaList) {
        this.komisijaList = komisijaList;
    }

    public Tipzavrsnograda getSifraTipaZavrsnogRada() {
        return sifraTipaZavrsnogRada;
    }

    public void setSifraTipaZavrsnogRada(Tipzavrsnograda sifraTipaZavrsnogRada) {
        this.sifraTipaZavrsnogRada = sifraTipaZavrsnogRada;
    }

    public Kandidat getBrojIndexa() {
        return brojIndexa;
    }

    public void setBrojIndexa(Kandidat brojIndexa) {
        this.brojIndexa = brojIndexa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sifraZavrsnogRada != null ? sifraZavrsnogRada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zavrsnirad)) {
            return false;
        }
        Zavrsnirad other = (Zavrsnirad) object;
        if ((this.sifraZavrsnogRada == null && other.sifraZavrsnogRada != null) || (this.sifraZavrsnogRada != null && !this.sifraZavrsnogRada.equals(other.sifraZavrsnogRada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return tema;
    }
    
}
